class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i=n-2 ; i>=0 ; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for(int i=1 ; i<n ; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        int result = 0;
        for(int i=0 ; i<n ; i++){
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return result;

        // int n = height.length;
        // int result = 0;
        // for(int i=0 ; i<n ; i++){
        //     int leftMax = height[i];
        //     for(int j=0 ; j<i ; j++){
        //         leftMax = Math.max(leftMax, height[j]);
        //     }
        //     int rightMax = height[i];
        //     for(int j=i+1 ; j<n ; j++){
        //         rightMax = Math.max(rightMax, height[j]);
        //     }
        //     result += Math.min(leftMax, rightMax) - height[i];
        // }
        // return result;
    }
}
