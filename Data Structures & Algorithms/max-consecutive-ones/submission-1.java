class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int result = 0;
        int sum = 0;

        for(int num : nums){
            if(num == 0) sum = 0;
            else sum++;
            result = Math.max(result, sum);
        }
        return result;


        // int n = nums.length;
        // int result = 0;
        // for(int i=0 ; i<n ; i++){
        //     int sum = 0;
        //     for(int j=i ; j<n ; j++){
        //         if(nums[j] == 0) sum = 0;
        //         else sum++;
        //         result = Math.max(result, sum);
        //     }
        // }
        // return result;
    }
}