class Solution {
    public int solve(int index, int[] nums, int[] dp){
        if(index >= nums.length) return 0;
        if(dp[index] != -1){
            return dp[index];
        }
        int take = nums[index] + solve(index+2, nums, dp);
        int notTake = solve(index+1, nums, dp);
        return dp[index] = Math.max(take, notTake);
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return solve(0, nums, dp);
    }
}
