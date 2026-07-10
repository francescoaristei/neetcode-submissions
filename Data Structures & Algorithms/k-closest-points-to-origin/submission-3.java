class Solution {
    record Entry(Double d, Integer i, Integer j) {};

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Entry> pq = new PriorityQueue<>(
            Comparator.comparing(Entry::d));
        
        for (int i = 0; i < points.length; i++) {
            double distance = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            Entry entry = new Entry(distance, points[i][0], points[i][1]);
            pq.offer(entry);
        }

        int[][] result = new int[k][2];

        int counter = k - 1;
        while (counter >= 0) {
            Entry entry = pq.poll();
            result[counter][0] = entry.i;
            result[counter][1] = entry.j;
            counter--;
        }

        return result;
    }
}
