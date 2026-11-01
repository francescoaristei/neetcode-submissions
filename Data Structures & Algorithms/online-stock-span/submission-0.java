class StockSpanner {
    private List<Integer> list;

    public StockSpanner() {
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        int count = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) <= price) {
                count++;
            } else {
                break;
            }
        }
        list.add(price);
        return 1 + count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */