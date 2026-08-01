class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(var t : tokens){
            if(t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")){
                int val2 = stack.pop();
                int val1 = stack.pop();
                if(t.equals("+")){
                    stack.push(val1+val2);
                }
                else if(t.equals("-")){
                    stack.push(val1-val2);
                }
                else if(t.equals("*")){
                    stack.push(val1*val2);
                }
                else{
                    stack.push(val1/val2);
                }
            }
            else{
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}
