class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left=0, right=n-1;
        int result = n;
        while(left <= right){
            int mid = left + (right-left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                result = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return result;



        // int n = nums.length;
        // for(int i=0 ; i<n ; i++){
        //     if(nums[i] >= target){
        //         return i;
        //     }
        // }
        // return n;
    }
}