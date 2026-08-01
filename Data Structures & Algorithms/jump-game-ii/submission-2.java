class Solution {
    public int solve(int index, int[] nums){
        if(index >= nums.length-1) return 0;
        if(nums[index]==0){
            return Integer.MAX_VALUE;
        }
        int minJumps = Integer.MAX_VALUE;
        for(int i=index+1 ; i<=Math.min(index+nums[index], nums.length-1) ; i++){
            if(nums[index]==0) continue;
            int jumps = solve(i, nums);
            if(jumps != Integer.MAX_VALUE){
                minJumps = Math.min(minJumps, 1+jumps);
            }
        }
        return minJumps;
    }
    public int jump(int[] nums) {
        return solve(0, nums);
    }
}
