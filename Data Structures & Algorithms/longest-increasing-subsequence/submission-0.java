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
        return solve(nums, 0, -1);
    }
}
