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
        int n = nums.length;
        int maxIndex = 0;
        for(int i=0 ; i<n ; i++){
            if(maxIndex < i) return false;
            maxIndex = Math.max(maxIndex, i+nums[i]);
            if(maxIndex >= n-1) return true; 
        }
        return false;

        // Boolean[] dp = new Boolean[nums.length+1];
        // return solve(0, nums, dp);
    }
}
