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

        if (tweets.containsKey(userId)) {
            for (Pair tweet: tweets.get(userId)) {
                System.out.print(userId);
                System.out.print(": ");
                System.out.print(tweet.tweet);
                System.out.print(", ");
                System.out.print(tweet.time);
                System.out.print("\n");
                pq.add(tweet);
            }
        }


        if (followed.containsKey(userId)) {
            for (Integer followedId: followed.get(userId)) {
                for (Pair tweet: tweets.get(followedId)) {
                    System.out.print(userId);
                    System.out.print(": ");
                    System.out.print(tweet.tweet);
                    System.out.print(": ");
                    System.out.print(tweet.time);
                    System.out.print("\n");
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
