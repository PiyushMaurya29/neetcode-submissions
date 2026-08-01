class Solution {
    public int getBitCount(int n){
        int count = 0;
        while(n > 0){
            count += n%2;
            n /= 2;
        }
        return count;
    }
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for(int i=0 ; i<=n ; i++){
            result[i] = getBitCount(i);
        }
        return result;
    }
}
