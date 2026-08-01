class Solution {
    public boolean solve(int index, int[] nums, Boolean[] dp){
        if(index >= nums.length-1) return true;
        if(dp[index] != null){
            return dp[index];
        }
        boolean result = false;
        for(int i=index+1 ; i<=index+nums[index] ; i++){
            if(solve(i, nums, dp)){
                return dp[index] = true;
            }
        }
        return dp[index] = false;
    }
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length+1];
        return solve(0, nums, dp);
    }
}
