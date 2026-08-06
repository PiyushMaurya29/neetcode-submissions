class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        result[n-1] = -1;

        int maxEle = arr[n-1];
        for(int i=n-2 ; i>=0 ; i--){
            result[i] = maxEle;
            maxEle = Math.max(maxEle, arr[i]);
        }
        return result;
    }
}