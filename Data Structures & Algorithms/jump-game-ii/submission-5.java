class Solution {
    Integer[] dp;
    public int solve(int index, int[] nums){
        if(index >= nums.length-1) return 0;
        if(nums[index]==0){
            return Integer.MAX_VALUE;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int minJumps = Integer.MAX_VALUE;
        for(int i=index+1 ; i<=Math.min(index+nums[index], nums.length-1) ; i++){
            int jumps = solve(i, nums);
            if(jumps != Integer.MAX_VALUE){
                minJumps = Math.min(minJumps, 1+jumps);
            }
        }
        return dp[index] = minJumps;
    }
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // If we reached the end of current jump range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;


        // dp = new Integer[nums.length+1];
        // Arrays.fill(dp, -1);
        // return solve(0, nums);
    }
}
