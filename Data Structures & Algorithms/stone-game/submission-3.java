class Solution {
    int totalCount;
    public boolean solve(int left, int right, int[] piles, boolean aliceTurn, int aliceCount, Boolean[][] dp){
        if(left > right){
            int bobCount = totalCount - aliceCount;
            return aliceCount > bobCount;
        }
        if(dp[left][right] != null){
            return dp[left][right];
        }
        if(aliceTurn){
            boolean takeFirst = solve(left+1, right, piles, !aliceTurn, aliceCount+piles[left], dp);
            boolean takeLast = solve(left, right-1, piles, !aliceTurn, aliceCount+piles[right], dp);
            return dp[left][right] = takeFirst || takeLast;
        }
        else{
            boolean takeFirst = solve(left+1, right, piles, !aliceTurn, aliceCount, dp);
            boolean takeLast = solve(left, right-1, piles, !aliceTurn, aliceCount, dp);
            return dp[left][right] = takeFirst || takeLast;
        }
    }
    public boolean stoneGame(int[] piles) {
        // return true;
        totalCount = 0;
        for(int p : piles){
            totalCount += p;
        }
        int n = piles.length;
        Boolean[][] dp = new Boolean[n+1][n+1];
        return solve(0, n-1, piles, true, 0, dp);
    }
}