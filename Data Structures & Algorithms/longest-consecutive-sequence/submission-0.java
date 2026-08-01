class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int maxLength = 0;
        for(int num : nums){
            int length = 1;
            int curr = num;
            while(set.contains(curr+1)){
                length++;
                curr++;
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}
