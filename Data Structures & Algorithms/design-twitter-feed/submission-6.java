class Twitter {
    // map user id, followed users
    private Map<Integer, Set<Integer>> followed;
    // map user id, its own tweets
    private Map<Integer, List<Pair>> tweets;

    // record map tweet with time it was posted
    private record Pair(Integer tweet, Integer time) implements Comparable<Pair> {
        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.time, other.time);
        }
    };

    // monotonically increasing time for a user feed
    private Integer time;

    public Twitter() {
        // NOTE: this does not initialise nor the priority queue, nor the set
        time = 0;
        followed = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (tweets.get(userId) != null) {
            time += 1;
            tweets.get(userId).add(new Pair(tweetId, time));
        } else {
            List<Pair> list = new ArrayList<>();
            time += 1;
            list.add(new Pair(tweetId, time));
            tweets.put(userId, list);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            Collections.reverseOrder()
        );
        List<Integer> result = new ArrayList<>();

        /*
        When you insert elements into a priority queue (heap) one by one:
        Inserting the 1st element: heap size is 1 → cost O(log 1)
        Inserting the 2nd element: heap size is 2 → cost O(log 2)
        Inserting the 3rd element: heap size is 3 → cost O(log 3)
        ...
        Inserting the nth element: heap size is n → cost O(log n)
        Total = O(log 1 + log 2 + log 3 + … + log n)
        
        Here you have n steps that you're summing, because the loop runs n times. 
        You can't drop the other terms — they all contribute to the total work:
        log 1 + log 2 + log 3 + … + log n
        
        This is a sum of n terms, not a choice between independent stages. 
        Even if each individual term is at most O(log n), you have n of them, so the upper bound is:
        n × O(log n) = O(n · log n)
        */
        if (tweets.containsKey(userId)) {
            for (Pair tweet: tweets.get(userId)) {
                pq.add(tweet);
            }
        }

        // O(log(n + m1)) + O(log(n + m1 + m2)) +....+O(log(n +...+mk))
        // therefore O((n + mk) * log(n + mk))
        // n = tweets posted by userId
        // mj = tweets posted by followedId
        // k = number of users followed by userId
        if (followed.containsKey(userId)) {
            for (Integer followedId: followed.get(userId)) {
                for (Pair tweet: tweets.get(followedId)) {
                    pq.add(tweet);
                }
            }
        }

        int counter = 0;
        while (!pq.isEmpty() && counter < 10) {
            result.add(pq.poll().tweet);
            counter++;
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        // cannot follow yourself
        if (followerId == followeeId) return;

        if (followed.containsKey(followerId)) {
            followed.get(followerId).add(followeeId);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            followed.put(followerId, set);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followed.containsKey(followerId)) {
            followed.get(followerId).remove(followeeId);
        }
    }
}
