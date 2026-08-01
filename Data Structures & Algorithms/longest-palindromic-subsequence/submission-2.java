class Solution {
    public int solve(int left, int right, String s, int[][] dp){
        if(left > right) return 0;
        if(left == right) return 1;
        if(dp[left][right] != -1){
            return dp[left][right];
        }
        if(s.charAt(left) == s.charAt(right)){
            return dp[left][right] = 2 + solve(left+1, right-1, s, dp);
        }
        else{
            int skipFirst = solve(left+1, right, s, dp);
            int skipLast = solve(left, right-1, s, dp);
            return dp[left][right] = Math.max(skipFirst, skipLast);
        }
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, n-1, s, dp);
    }
}