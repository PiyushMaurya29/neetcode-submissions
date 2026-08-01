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
        return dp[index][sum1] = (take || notTake);
    }
    public boolean solve(int index, int[] nums, int target, Boolean[][] dp){
        if(target == 0) return true;
        if(index>=nums.length || target<0) return false;
        if(dp[index][target] != null){
            return dp[index][target];
        }
        boolean take = solve(index+1, nums, target-nums[index], dp);
        boolean notTake = solve(index+1, nums, target, dp);
        return dp[index][target] = (take || notTake);
    }
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        if(totalSum%2 == 1) return false;
        int target = totalSum/2;
        Boolean[][] dp = new Boolean[nums.length+1][target+1];
        return solve(0, nums, target, dp);

        // int totalSum = 0;
        // for(int num : nums){
        //     totalSum += num;
        // }
        // if(totalSum%2 == 1) return false;
        // Boolean[][] dp = new Boolean[nums.length+1][totalSum];
        // return solve(0, nums, 0, totalSum, dp);
    }
}
