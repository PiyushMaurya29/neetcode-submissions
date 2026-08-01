class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int n = nums.length;
        int resultCount = 0;
        int left=0, right=0;
        int product = 1;
        while(right < n){
            product *= nums[right];
            while(product >= k){
                product /= nums[left];
                left++;
            }
            resultCount += (right-left+1);
            right++;
        }
        return resultCount;



        // int n = nums.length;
        // int resultCount = 0;
        // for(int i=0 ; i<n ; i++){
        //     int product = 1;
        //     for(int j=i ; j<n ; j++){
        //         product *= nums[j];
        //         if(product >= k) break;
        //         resultCount++;
        //     }
        // }
        // return resultCount;
    }
}