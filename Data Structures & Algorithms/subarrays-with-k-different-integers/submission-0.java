class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int result = 0;
        for(int i=0 ; i<n ; i++){
            Set<Integer> set = new HashSet<>();
            for(int j=i ; j<n ; j++){
                set.add(nums[j]);
                if(set.size() == k) result++;
                else if(set.size() > k) break;
            }
        }
        return result;
    }
}