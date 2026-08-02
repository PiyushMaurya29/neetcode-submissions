class Solution {
    public int hammingWeight(int n) {
        int resultCount = 0;
        while(n > 0){
            int rem = n%2;
            resultCount += rem;
            n /= 2;
        }
        return resultCount;
    }
}
