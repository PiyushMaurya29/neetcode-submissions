class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        int i=0, j=0;
        int sum = 0;
        while(j < n){
            sum += nums[j];
            while(sum >= target){
                result = Math.min(result, j-i+1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return result==Integer.MAX_VALUE ? 0 : result;


        // int n = nums.length;
        // int result = Integer.MAX_VALUE;
        // for(int i=0 ; i<n ; i++){
        //     int sum = 0;
        //     for(int j=i ; j<n ; j++){
        //         sum += nums[j];
        //         if(sum >= target){
        //             result = Math.min(result, j-i+1);
        //             break;
        //         }
        //     }
        // }
        // return result==Integer.MAX_VALUE ? 0 : result;
    }
}