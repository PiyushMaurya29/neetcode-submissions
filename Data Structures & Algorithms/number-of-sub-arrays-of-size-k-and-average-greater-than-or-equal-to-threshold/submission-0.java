class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int result = 0;
        int i=0, j=0;
        double sum = 0;
        while(j < n){
            sum += arr[j];
            if(j-i+1 > k){
                sum -= arr[i];
                i++;
            }
            if(j-i+1 == k){
                if(sum/k >= threshold){
                    result++;
                }
            }
            j++;
        }
        return result;
    }
}