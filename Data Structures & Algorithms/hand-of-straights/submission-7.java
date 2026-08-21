class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int num: hand) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(count.keySet());

        while (!heap.isEmpty()) {
            int min = heap.peek();
            for (int i = min; i < min + groupSize; i++) {
                if (!count.containsKey(i)) {
                    return false;
                }
                count.put(i, count.get(i) - 1);
                if (count.get(i) == 0) {
                    if (i != heap.peek()) {
                        return false;
                    }
                    heap.poll();
                }
            }
        }
        return true;
    }
}
