class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] result = new int[n];

        int left=0, right=n-1;
        for(int i=0 ; i<n ; i++){
            if(i%2 == 0){
                result[i] = nums[left++];
            }
            else{
                result[i] = nums[right--];
            }
        }
        for(int i=0 ; i<n ; i++){
            nums[i] = result[i];
        }


        // Arrays.sort(nums);
        // int n = nums.length;
        // int[] result = new int[n];

        // int index = n-1;
        // for(int i=1 ; i<n ; i+=2){
        //     result[i] = nums[index--];
        // }
        // index = 0;
        // for(int i=0 ; i<n ; i+=2){
        //     result[i] = nums[index++];
        // }
        // for(int i=0 ; i<n ; i++){
        //     nums[i] = result[i];
        // }
    }
}
