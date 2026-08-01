class Solution {
    public int removeDuplicates(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int num : nums){
            set.add(num);
        }
        int index = 0;
        for(int ele : set){
            nums[index++] = ele;
        }
        return set.size();
    }
}