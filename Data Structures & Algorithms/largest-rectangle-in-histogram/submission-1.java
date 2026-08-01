class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] pse = new int[n];
        for(int i=0 ; i<n ; i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()) pse[i] = -1;
            else pse[i] = stack.peek();
            stack.push(i);
        }

        stack.clear();
        stack = new Stack<>();

        int[] nse = new int[n];
        for(int i=n-1 ; i>=0 ; i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()) nse[i] = n;
            else nse[i] = stack.peek();
            stack.push(i);
        }
        int result = 0;
        for(int i=0 ; i<n ; i++){
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;
            result = Math.max(result, area);
        }
        return result;


        // int n = heights.length;
        // int result = 0;
        // for(int i=0 ; i<n ; i++){
        //     int prevSmaller = -1;
        //     for(int j=i-1 ; j>=0 ; j--){
        //         if(heights[j] < heights[i]){
        //             prevSmaller = j;
        //             break;
        //         }
        //     }

        //     int nextSmaller = n;
        //     for(int j=i+1 ; j<n ; j++){
        //         if(heights[j] < heights[i]){
        //             nextSmaller = j;
        //             break;
        //         }
        //     }
        //     int width = nextSmaller - prevSmaller - 1;
        //     int area = heights[i] * width;
        //     result = Math.max(result, area);
        // }
        // return result;
    }
}
