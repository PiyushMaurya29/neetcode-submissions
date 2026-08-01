class Solution {
    public int binarySearch(int[] nums, int target, boolean checkLeft){
        int left=0, right=nums.length-1;
        int result = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                result = mid;
                if(checkLeft) right = mid - 1;
                else left = mid + 1;
            }
            else if(nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return result;
    }
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = binarySearch(nums, target, true);
        int rightIndex = binarySearch(nums, target, false);
        return new int[]{leftIndex, rightIndex};
    }
}