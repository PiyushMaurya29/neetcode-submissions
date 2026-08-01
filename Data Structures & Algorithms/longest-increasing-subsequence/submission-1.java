class Solution {
    public int solve(int[] nums, int index, int prevIndex){
        if(index >= nums.length){
            return 0;
        }
        int take = 0;
        if(prevIndex==-1 || nums[index] > nums[prevIndex]){
            take = 1 + solve(nums, index+1, index);
        }
        int notTake = solve(nums, index+1, prevIndex);
        return Math.max(take, notTake);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n==0 || n==1) return n;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        int maxLIS = 0;
        for(int i=1 ; i<n ; i++){
            for(int j=0 ; j<i ; j++){
                if(nums[i]>nums[j] && 1+dp[j]>dp[i]){
                    dp[i] = 1 + dp[j];
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        return maxLIS;

        // return solve(nums, 0, -1);
    }
}
