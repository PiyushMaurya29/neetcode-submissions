class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int index = 0;
        for(int i=1 ; i<n ; i++){
            if(nums[i] != nums[i-1]){
                nums[index++] = nums[i-1];
            }
        }
        nums[index++] = nums[n-1];
        return index;


        // TreeSet<Integer> set = new TreeSet<>();
        // for(int num : nums){
        //     set.add(num);
        // }
        // int index = 0;
        // for(int ele : set){
        //     nums[index++] = ele;
        // }
        // return set.size();
    }
}