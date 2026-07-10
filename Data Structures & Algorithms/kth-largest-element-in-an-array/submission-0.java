class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = 
            new PriorityQueue<>(Collections.reverseOrder());

        for (Integer n: nums) {
            pq.add(n);
        }

        while(k > 1) {
            pq.poll();
            k--;
        }
        return pq.poll();
    }
}
