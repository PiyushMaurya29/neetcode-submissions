class Solution {
    public int solve(int index, int currSum, int target, int[] nums){
        if(index >= nums.length){
            if(currSum == target) return 1;
            return 0;
        }
        int takeAdd = solve(index+1, currSum+nums[index], target, nums);
        int takeSubtract = solve(index+1, currSum-nums[index], target, nums);
        return takeAdd + takeSubtract;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return solve(0, 0, target, nums);
    }
}
