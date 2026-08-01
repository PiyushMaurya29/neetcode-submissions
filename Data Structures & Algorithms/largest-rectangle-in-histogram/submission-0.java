class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int result = 0;
        for(int i=0 ; i<n ; i++){
            int prevSmaller = -1;
            for(int j=i-1 ; j>=0 ; j--){
                if(heights[j] < heights[i]){
                    prevSmaller = j;
                    break;
                }
            }

            int nextSmaller = n;
            for(int j=i+1 ; j<n ; j++){
                if(heights[j] < heights[i]){
                    nextSmaller = j;
                    break;
                }
            }
            int width = nextSmaller - prevSmaller - 1;
            int area = heights[i] * width;
            result = Math.max(result, area);
        }
        return result;
    }
}
