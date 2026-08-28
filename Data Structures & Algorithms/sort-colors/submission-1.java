class Solution {
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        for(int i=0 ; i<n ; i++){
            int minIndex = i;
            for(int j=i+1 ; j<n ; j++){
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            swap(i, minIndex, nums);
        }
        


        // int n = nums.length;
        // for(int i=0 ; i<n ; i++){
        //     for(int j=i+1 ; j<n ; j++){
        //         if(nums[j] < nums[i]){
        //             swap(i, j, nums);
        //         }
        //     }
        // }
    }
}