class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = 
            new PriorityQueue<>(Collections.reverseOrder());
        
        for (Integer n: stones) {
            pq.offer(n);
        }

        while(pq.size() > 1) {
            Integer n1 = pq.poll();
            Integer n2 = pq.poll();

            if (n1 == n2) continue;

            pq.offer(n1 - n2);
        }

        if (pq.isEmpty()) {
            return 0;
        }

        return pq.poll();
    }
}
