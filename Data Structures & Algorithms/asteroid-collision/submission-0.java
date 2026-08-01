class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int a : asteroids){
            if(stack.isEmpty() || a>=0){
                stack.push(a);
            }
            else{ // a < 0
                int curr = -a;
                while(!stack.isEmpty() && stack.peek()>0 && stack.peek()<curr){
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek()<0) stack.push(a);
                else if(stack.peek()>0 && stack.peek()==curr){
                    stack.pop();
                }
                // else if(stack.peek()>0 && stack.peek()>curr){
                    
                // }
            }
        }

        int[] result = new int[stack.size()];
        int index = stack.size()-1;
        while(!stack.isEmpty()){
            result[index--] = stack.pop();
        }
        return result;
    }
}