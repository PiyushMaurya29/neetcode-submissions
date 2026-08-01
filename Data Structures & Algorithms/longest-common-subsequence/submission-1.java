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
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];

        for(int i=1 ; i<=n1 ; i++){
            for(int j=1 ; j<=n2 ; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];


        // int[][] dp = new int[text1.length()+1][text2.length()+1];
        // for(int[] row : dp){
        //     Arrays.fill(row, -1);
        // }
        // return solve(0, text1, 0, text2, dp);
    }
}
