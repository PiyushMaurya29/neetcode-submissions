class Solution {
    public boolean isSorted(int start, int[] nums){
        int n = nums.length;
        for(int i=start ; i<start+n-1 ; i++){
            int currIndex = i%n;
            int nextIndex = (i+1)%n;
            if(nums[currIndex] > nums[nextIndex]){
                return false;
            }
        }
        return true;
    }
    public boolean check(int[] nums) {
        int n = nums.length;
        for(int i=0 ; i<n ; i++){
            if(isSorted(i, nums)){
                return true;
            }
        }
        return false;
    }
}