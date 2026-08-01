class Solution {
    public boolean solve(int index, int[] nums){
        if(index >= nums.length-1) return true;
        boolean result = false;
        for(int i=index+1 ; i<=index+nums[index] ; i++){
            if(solve(i, nums)){
                return true;
            }
        }
        return false;
    }
    public boolean canJump(int[] nums) {
        return solve(0, nums);
    }
}
