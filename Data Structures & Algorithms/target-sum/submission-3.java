class Solution {
    Map<String, Integer> dpMap;
    public int solve(int index, int currSum, int target, int[] nums){
        if(index >= nums.length){
            // if(currSum == target) return 1;
            // return 0;
            return (currSum == target) ? 1 : 0;
        }
        String str = index+","+currSum;
        if(dpMap.containsKey(str)){
            return dpMap.get(str);
        }
        int takeAdd = solve(index+1, currSum+nums[index], target, nums);
        int takeSubtract = solve(index+1, currSum-nums[index], target, nums);
        int result = takeAdd + takeSubtract;
        dpMap.put(str, result);
        return result;
    }
    int sum = 0;
    public int solve(int index, int currSum, int[] nums, int target, int[][] dp){
        if(index >= nums.length){
            return (currSum == target) ? 1 : 0;
        }
        if(dp[index][currSum+sum] != -1){
            return dp[index][currSum+sum];
        }
        int takeAdd = solve(index+1, currSum+nums[index], nums, target, dp);
        int takeSubtract = solve(index+1, currSum-nums[index], nums, target, dp);
        return dp[index][currSum+sum] = (takeAdd+takeSubtract);
    }
    public int findTargetSumWays(int[] nums, int target) {
        sum = 0;
        for(int num : nums){
            sum += num;
        }
        int[][] dp = new int[nums.length+1][2*sum+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, 0, nums, target, dp);

        // dpMap = new HashMap<>();
        // return solve(0, 0, target, nums);
    }
}
