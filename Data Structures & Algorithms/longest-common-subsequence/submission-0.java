class Solution {
    public int solve(int i, String s1, int j, String s2, int[][] dp){
        if(i>=s1.length() || j>=s2.length()) return 0;
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return 1 + solve(i+1, s1, j+1, s2, dp);
        }
        else{
            int skipFirst = solve(i+1, s1, j, s2, dp);
            int skipSecond = solve(i, s1, j+1, s2, dp);
            return dp[i][j] = Math.max(skipFirst, skipSecond);
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, text1, 0, text2, dp);
    }
}
