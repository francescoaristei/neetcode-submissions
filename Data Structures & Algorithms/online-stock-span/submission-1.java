class StockSpanner {
    private record Pair(Integer price, Integer span) {};
    private Deque<Pair> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int span = 0;
        while (!stack.isEmpty() && stack.peek().price <= price) {
            span += stack.peek().span;
            stack.pop();
        }
        stack.push(new Pair(price, span + 1));
        return span + 1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */