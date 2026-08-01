class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int result = 0;
        int left=0, right=n-1;
        
        while(left < right){
            int currWater = (right-left) * Math.min(heights[left], heights[right]);
            result = Math.max(result, currWater);

            if(heights[left] > heights[right]) right--;
            else left++;
        }
        return result;
        

        // int n = heights.length;
        // int result = 0;
        // for(int i=0 ; i<n ; i++){
        //     for(int j=0 ; j<n ; j++){
        //         int currWater = (j-i) * Math.min(heights[i], heights[j]);
        //         result = Math.max(result, currWater);
        //     }
        // }
        // return result;
    }
}
