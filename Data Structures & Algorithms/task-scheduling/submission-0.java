class Solution {
    record Pair(Integer count, Integer idle) {};

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character t: tasks) {
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
                continue;
            }
            map.put(t, 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        for (Integer value: map.values()) {
            pq.add(value);
        }

        Deque<Pair> dq = new ArrayDeque<>();

        int time = 0;

        while (!pq.isEmpty() || !dq.isEmpty()) {
            time += 1;

            if (!pq.isEmpty()) {
                Integer c = pq.poll() - 1;
                if (c > 0) {
                    dq.offerFirst(new Pair(c, time + n));
                }        
            }

            if (!dq.isEmpty() && dq.getLast().idle == time) {
                Integer c = dq.removeLast().count;
                pq.add(c);
            }
        }

        return time;
    }
}
