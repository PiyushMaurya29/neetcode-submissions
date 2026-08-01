class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int result = 0;
        for(int i=0 ; i<n ; i++){
            int countZero = 0;
            for(int j=i ; j<n ; j++){
                if(nums[j] == 0) countZero++;
                if(countZero > k) break;
                result = Math.max(result, j-i+1);
            }
        }
        return result;
    }
}