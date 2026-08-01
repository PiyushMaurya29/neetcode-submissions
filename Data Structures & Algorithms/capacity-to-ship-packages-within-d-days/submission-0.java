class Solution {
    public int[] getRange(int[] arr){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int ele : arr){
            max = Math.max(max, ele);
            sum += ele;
        }
        return new int[]{max, sum};
    }
    public boolean isPossible(int weightAllowed, int[] arr, int days){
        int dayCount = 1;
        int currWeight = 0;
        for(int w : arr){
            if(currWeight+w > weightAllowed){
                dayCount++;
                currWeight = w;
            }
            else currWeight += w;
        }
        return dayCount <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int[] range = getRange(weights);
        int left=range[0], right=range[1];
        int result = -1;

        while(left <= right){
            int mid = left + (right-left)/2;
            if(isPossible(mid, weights, days)){
                result = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return result;
    }
}