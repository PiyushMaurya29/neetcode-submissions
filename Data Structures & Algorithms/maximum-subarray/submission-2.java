class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];
        for(int i=1 ; i<nums.length ; i++){
            currSum = Math.max(nums[i], nums[i]+currSum);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;


        // int n = nums.length;
        // int maxSum = Integer.MIN_VALUE;
        // for(int i=0 ; i<n ; i++){
        //     int sum = 0;
        //     for(int j=i ; j<n ; j++){
        //         sum += nums[j];
        //         maxSum = Math.max(maxSum, sum);
        //     }
        // }
        // return maxSum;
    }
}
