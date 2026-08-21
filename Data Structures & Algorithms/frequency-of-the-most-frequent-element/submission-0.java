class Solution {
    public int getFreq(int index, int[] nums, int k){
        int leftIndex = index;
        for(int i=index ; i>=0 ; i--){
            int diff = nums[index]-nums[i];
            if(k >= diff){
                leftIndex = i;
                k -= diff;
            }
        }
        return index-leftIndex+1;
    }
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int result = 0;
        for(int i=0 ; i<n ; i++){
            int freq = getFreq(i, nums, k);
            result = Math.max(result, freq);
        }
        return result;
    }
}