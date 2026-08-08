class Solution {
    public int calPoints(String[] operations) {
        // Stack<String> stack = new Stack<>();
        Deque<String> stack = new ArrayDeque<>();
        for(var o : operations){
            if(o.equals("+")){
                String prev = stack.pop();
                String secPrev = stack.pop();

                int sum = Integer.parseInt(prev) + Integer.parseInt(secPrev);
                stack.push(secPrev);
                stack.push(prev);
                stack.push(sum+"");
            }
            else if(o.equals("D")){
                String prev = stack.pop();
                int curr = 2 * Integer.parseInt(prev);
                stack.push(prev);
                stack.push(curr+"");
            }
            else if(o.equals("C")) stack.pop();
            else stack.push(o);
        }
        int result = 0;
        while(!stack.isEmpty()){
            result += Integer.parseInt(stack.pop());
        }
        return result;
    }
}