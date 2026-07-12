class Twitter {
    private record Pair(Integer life, Integer tweet) {};
    private Map<Integer, List<Pair>> tweetMap;
    private Map<Integer, Set<Integer>> followMap;
    private int time;

    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k ->
        new ArrayList<>()).add(new Pair(time--, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();

        PriorityQueue<int[]> pq = 
            new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        followMap.computeIfAbsent(userId, k ->
            new HashSet<>()).add(userId);
        
        for (Integer followee: followMap.get(userId)) {
            if (tweetMap.containsKey(followee)) {
                List<Pair> tweets = tweetMap.get(followee);
                int index = tweets.size() - 1;
                Pair pair = tweets.get(index);
                pq.add(new int[]{pair.life, pair.tweet, followee, index});
            }
        }

        while (!pq.isEmpty() && result.size() < 10) {
            int[] tweet = pq.poll();
            result.add(tweet[1]);
            int followee = tweet[2];
            int index = tweet[3];
            if (index > 0) {
                Pair pair = tweetMap.get(followee).get(index - 1);
                pq.add(new int[]{pair.life, pair.tweet, followee, index - 1});
            }
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> 
        new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            if (followMap.get(followerId).contains(followeeId)) {
                followMap.get(followerId).remove(followeeId);
            }
        }
    }
}
