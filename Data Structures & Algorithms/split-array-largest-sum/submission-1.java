class Solution {
    public int solve(int index, int maxSum, int[] nums, int k){
        if(k < 0) return Integer.MAX_VALUE;
        if(index >= nums.length){
            return k==0 ? maxSum : Integer.MAX_VALUE;
        }
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=index ; i<nums.length ; i++){
            sum += nums[i];
            int ans = solve(i+1, Math.max(sum, maxSum), nums, k-1);
            if(ans != Integer.MAX_VALUE){
                result = Math.min(result, ans);
            }
        }
        return result;
    }
    public int[] getRange(int[] nums){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums){
            max = Math.max(max, num);
            sum += num;
        }
        return new int[]{max, sum};
    }
    public boolean isPossible(int sum, int[] nums, int k){
        int splitCount = 1;
        int currSum = 0;
        for(int num : nums){
            if(num+currSum > sum){
                splitCount++;
                currSum = num;
            }
            else currSum += num;
        }
        return splitCount <= k;
    }
    public int splitArray(int[] nums, int k) {
        // return solve(0, Integer.MIN_VALUE, nums, k);

        if(nums.length < k) return -1;
        int[] range = getRange(nums);

        int left = range[0];
        int right = range[1];
        int result = -1;

        while(left <= right){
            int mid = left + (right-left)/2;
            if(isPossible(mid, nums, k)){
                result = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return result;
    }
}