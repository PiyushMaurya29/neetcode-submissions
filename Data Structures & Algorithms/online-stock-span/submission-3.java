class StockSpanner {
    Stack<int[]> stack;
    int index;
    public StockSpanner() {
        stack = new Stack<>();
        index = -1;
    }
    
    public int next(int price) {
        index++;
        while(!stack.isEmpty() && stack.peek()[0]<=price){
            stack.pop();
        }
        // int result = -1;
        // if(stack.isEmpty()) result = index+1;
        // else result = (index-stack.peek()[1]);

        int result = stack.isEmpty() ? index+1 : index-stack.peek()[1];

        stack.push(new int[]{price, index});
        return result;
    }
}



// class StockSpanner {
//     List<Integer> list;
//     public StockSpanner() {
//         list = new ArrayList<>();
//     }
    
//     public int next(int price) {
//         list.add(price);
//         int n = list.size();
//         int count = 0;
//         for(int i=n-1 ; i>=0 ; i--){
//             if(list.get(i) > price){
//                 return count;
//             }
//             count++;
//         }
//         return count;
//     }
// }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */