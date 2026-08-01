class Solution {
    public int missingNumber(int[] nums) {
        // int n = nums.length;
        // int arraySum = 0;
        // for(int num : nums){
        //     arraySum += num;
        // }
        // int totalSum = 0;
        // for(int i=1 ; i<=n ; i++){
        //     totalSum += i;
        // }
        // return totalSum - arraySum;

        int n = nums.length;
        int result = 0;
        for(int i=0 ; i<n ; i++){
            result ^= nums[i];
        }
        for(int i=0 ; i<=n ; i++){
            result ^= i;
        }
        return result;
    }
}
