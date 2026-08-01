class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        int result = Integer.MAX_VALUE;
        for(int i=0 ; i<n ; i++){
            int sum = 0;
            for(int j=i ; j<n ; j++){
                sum += nums[j];
                if(sum >= target){
                    result = Math.min(result, j-i+1);
                    break;
                }
            }
        }
        return result==Integer.MAX_VALUE ? 0 : result;
    }
}