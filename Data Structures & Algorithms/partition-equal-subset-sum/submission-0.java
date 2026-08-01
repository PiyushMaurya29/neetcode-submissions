class Solution {
    public boolean solve(int index, int[] nums, int sum1, int totalSum){
        if(index >= nums.length){
            int sum2 = totalSum - sum1;
            return sum1 == sum2 ? true : false;
        }
        boolean take = solve(index+1, nums, sum1+nums[index], totalSum);
        boolean notTake = solve(index+1, nums, sum1, totalSum);
        return take || notTake;
    }
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        if(totalSum%2 == 1) return false;
        return solve(0, nums, 0, totalSum);
    }
}
