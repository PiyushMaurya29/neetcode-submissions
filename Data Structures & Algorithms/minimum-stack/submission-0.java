class MinStack {
    Stack<int[]> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new int[]{val, val});
        }
        else{
            stack.push(new int[]{val, Math.min(val, stack.peek()[1])});
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        stack.pop();
    }
    
    public int top() {
        if(stack.isEmpty()) return -1;
        return stack.peek()[0];
    }
    
    public int getMin() {
        if(stack.isEmpty()) return -1;
        return stack.peek()[1];
    }
}
