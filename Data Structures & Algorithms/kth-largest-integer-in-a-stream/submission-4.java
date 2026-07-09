// min heap

class KthLargest {
    private PriorityQueue<Integer> q;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.q = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            q.offer(nums[i]);
            if (q.size() > k) {
                q.poll();
            }
        }
    }
    
    public int add(int val) {
        this.q.offer(val);
        if (this.q.size() > this.k) {
            this.q.poll();
        }
        return this.q.peek();
    }
}
