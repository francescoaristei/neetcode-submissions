class Solution {
    private record Pair(Integer end, Integer capacity) {};

    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            Comparator.comparingInt(pair -> pair.end)
        );

        // initialize with first trip

        int currCapacity = 0;
        int i = 0;
        while (i < trips.length) {
            while (!pq.isEmpty() && pq.peek().end <= trips[i][1]) {
                Pair pair = pq.poll();
                currCapacity -= pair.capacity;
            }

            currCapacity += trips[i][0];

            if (currCapacity > capacity) {
                return false;
            }

            pq.offer(new Pair(trips[i][2], trips[i][0]));
            i++;
        }

        return true;
    }
}