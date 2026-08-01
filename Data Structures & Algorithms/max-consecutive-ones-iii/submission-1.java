class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int result = 0;
        int countZero = 0;
        int i=0, j=0;
        while(j < n){
            if(nums[j] == 0) countZero++;
            while(countZero > k){
                if(nums[i] == 0) countZero--;
                i++;
            }
            result = Math.max(result, j-i+1);
            j++;
        }
        return result;
        

        // int n = nums.length;
        // int result = 0;
        // for(int i=0 ; i<n ; i++){
        //     int countZero = 0;
        //     for(int j=i ; j<n ; j++){
        //         if(nums[j] == 0) countZero++;
        //         if(countZero > k) break;
        //         result = Math.max(result, j-i+1);
        //     }
        // }
        // return result;
    }
}