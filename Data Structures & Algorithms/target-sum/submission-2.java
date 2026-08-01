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
    public int findTargetSumWays(int[] nums, int target) {
        dpMap = new HashMap<>();
        return solve(0, 0, target, nums);
    }
}
