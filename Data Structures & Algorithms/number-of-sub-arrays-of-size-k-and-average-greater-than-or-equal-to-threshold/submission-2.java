class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        double sum = 0;
        for(int i=0 ; i<k ; i++){
            sum += arr[i];
        }
        int result = (sum/k >= threshold) ? 1 : 0;
        for(int i=k ; i<n ; i++){
            sum = sum + arr[i] - arr[i-k];
            if(sum/k >= threshold) result++;
        }
        return result;
        

        // int n = arr.length;
        // int result = 0;
        // int i=0, j=0;
        // double sum = 0;
        // while(j < n){
        //     sum += arr[j];
        //     if(j-i+1 > k){
        //         sum -= arr[i];
        //         i++;
        //     }
        //     if((j-i+1 == k) && (sum/k>=threshold)){
        //         result++;
        //         // if(sum/k >= threshold){
        //         //     result++;
        //         // }
        //     }
        //     j++;
        // }
        // return result;
    }
}