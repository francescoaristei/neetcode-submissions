// max heap

class KthLargest {
    private List<Integer> maxHeap = new ArrayList<>();
    private int kth;

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private void shiftUp(int i) {
        while (i > 0 && maxHeap.get(parent(i)) < maxHeap.get(i)) {
            Collections.swap(maxHeap, parent(i), i);
            i = parent(i);
        }
    }

    private void shiftDown(int i) {
        int size = maxHeap.size();
        int maxIndex = i;
        int l = left(i);
        if (l < size && maxHeap.get(l) > maxHeap.get(maxIndex)) {
            maxIndex = l;
        }
        int r = right(i);
        if (r < size && maxHeap.get(r) > maxHeap.get(maxIndex)) {
            maxIndex = r;
        }

        if (maxIndex != i) {
            Collections.swap(maxHeap, i, maxIndex);
            shiftDown(maxIndex);
        }
    }

    private int pop() {
        int size = maxHeap.size();
        if (size == 0) {
            return -1;
        }
        int result = maxHeap.get(0);
        maxHeap.set(0, maxHeap.get(size - 1));
        maxHeap.remove(size - 1);
        shiftDown(0);
        return result;
    }

    public List<Integer> getMaxHeap() {
        return maxHeap;
    }

    public int getKth() {
        return kth;
    }

    public KthLargest(int k, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
            shiftUp(maxHeap.size() - 1);
        }
        kth = k;
    }

    public KthLargest(KthLargest kthLargest) {
        for (Integer n: kthLargest.getMaxHeap()) {
            maxHeap.add(n);
        }
        kth = kthLargest.getKth();
    }

    private int getKthLargest() {
        KthLargest kthLargest = new KthLargest(this);
        int counter = kthLargest.getKth();
        int result = 0;
        while(counter > 0) {
            result = kthLargest.pop();
            counter--;
        }
        return result;
    }

    public int add(int val) {
        maxHeap.add(val);
        shiftUp(maxHeap.size() - 1);
        return getKthLargest();
    }

    public void printHeap() {
        for (int x : maxHeap) System.out.print(x + " ");
        System.out.println();
    }
}
