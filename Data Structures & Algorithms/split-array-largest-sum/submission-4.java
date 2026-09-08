class Solution {
    public int[] getRange(int[] nums){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums){
            max = Math.max(max, num);
            sum += num;
        }
        return new int[]{max, sum};
    }
    public boolean isPossible(int maxSumPossible, int[] nums, int k){
        int splitCount = 1;
        int currSum = 0;
        for(int num : nums){
            if(currSum+num > maxSumPossible){
                splitCount++;
                currSum = num; 
            }
            else currSum += num;
        }
        return splitCount <= k;
    }
    
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int[] range = getRange(nums);

        int left=range[0], right=range[1];
        int result = -1;
        while(left <= right){
            int mid = left + (right-left) / 2;
            if(isPossible(mid, nums, k)){
                result = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return result;


        // for(int i=left ; i<=right ; i++){
        //     if(isPossible(i, nums, k)){
        //         return i;
        //     }
        // }
        // return -1;
    }
}