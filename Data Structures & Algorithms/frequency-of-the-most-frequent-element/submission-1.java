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
    public int getFreqBinarySearch(int index, int[] nums, int[] prefixSum, int k){
        int left=0, right=index;
        int leftMostIndex = index;

        while(left <= right){
            int mid = left + (right-left) / 2;
            
            int windowSize = index-mid+1;
            int maxWindowSum = windowSize * nums[index];
            int currWindowSum = prefixSum[index] - (mid>0 ? prefixSum[mid-1] : 0);

            int difference = maxWindowSum - currWindowSum;
            if(difference <= k){
                leftMostIndex = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return index-leftMostIndex+1;
    }
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i=1 ; i<n ; i++){
            prefixSum[i] = nums[i] + prefixSum[i-1];
        }
        int result = 0;
        for(int i=0 ; i<n ; i++){
            // int freq = getFreq(i, nums, k);
            int freq = getFreqBinarySearch(i, nums, prefixSum, k);
            result = Math.max(result, freq);
        }
        return result;
    }
}