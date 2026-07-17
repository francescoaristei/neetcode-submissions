class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    private void pushInMinStack(int val) {
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            if (minStack.peek() >= val) {
                minStack.push(val);
            } else {
                Deque<Integer> temp = new ArrayDeque<>();
                while (!minStack.isEmpty() 
                    && minStack.peek() < val) {
                    temp.push(minStack.pop());
                }
                minStack.push(val);
                while (!temp.isEmpty()) {
                    minStack.push(temp.pop());
                }
            }
        }
    }
    
    public void push(int val) {
        stack.push(val);
        pushInMinStack(val);
    }

    private void popInMinStack(int val) {
        Deque<Integer> temp = new ArrayDeque<>();
        while (minStack.peek() != val) {
            temp.push(minStack.pop());
        }
        minStack.pop();
        while (!temp.isEmpty()) {
            minStack.push(temp.pop());
        }
    }
    
    public void pop() {
        int popped = stack.pop();
        popInMinStack(popped);
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
