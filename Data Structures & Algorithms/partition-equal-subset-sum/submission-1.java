class Solution {
    public boolean solve(int index, int[] nums, int sum1, int totalSum, Boolean[][] dp){
        if(index >= nums.length){
            int sum2 = totalSum - sum1;
            return sum1 == sum2 ? true : false;
        }
        if(dp[index][sum1] != null){
            return dp[index][sum1];
        }
        boolean take = solve(index+1, nums, sum1+nums[index], totalSum, dp);
        boolean notTake = solve(index+1, nums, sum1, totalSum, dp);
        return dp[index][sum1] = take || notTake;
    }
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        if(totalSum%2 == 1) return false;
        Boolean[][] dp = new Boolean[nums.length+1][totalSum];
        return solve(0, nums, 0, totalSum, dp);
    }
}
