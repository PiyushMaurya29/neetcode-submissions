class Solution {
    public boolean solve(int i, String s1, int j, String s2, int k, String s3, Boolean[][][] dp){
        if(k >= s3.length()){
            return dp[i][j][k] = true;
        }
        if(i >= s1.length()){
            return dp[i][j][k] = s2.substring(j).equals(s3.substring(k));
        }
        if(j >= s2.length()){
            return dp[i][j][k] = s1.substring(i).equals(s3.substring(k));
        }

        if(dp[i][j][k] != null){
            return dp[i][j][k];
        }

        boolean check1 = false;
        if(s1.charAt(i) == s3.charAt(k)){
            check1 = solve(i+1, s1, j, s2, k+1, s3, dp);
        }
        boolean check2 = false;
        if(s2.charAt(j) == s3.charAt(k)){
            check2 = solve(i, s1, j+1, s2, k+1, s3, dp);
        }
        return dp[i][j][k] = check1 || check2;
    }
    public boolean solve(int i, String s1, int j, String s2, String s3, Boolean[][] dp){
        int k = i + j;

        if(k >= s3.length()) return true;

        if(dp[i][j] != null){
            return dp[i][j];
        }

        boolean check1 = false;
        if(i<s1.length() && s1.charAt(i)==s3.charAt(k)){
            check1 = solve(i+1, s1, j, s2, s3, dp);
        }
        boolean check2 = false;
        if(j<s2.length() && s2.charAt(j)==s3.charAt(k)){
            check2 = solve(i, s1, j+1, s2, s3, dp);
        }
        return dp[i][j] = check1 || check2;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if(m+n != s3.length()) return false;
        Boolean[][] dp = new Boolean[m+1][n+1];
        return solve(0, s1, 0, s2, s3, dp);


        // if(s1.length()+s2.length() != s3.length()){
        //     return false;
        // }
        // Boolean[][][] dp = new Boolean[s1.length()+1][s2.length()+1][s3.length()+1];
        // return solve(0, s1, 0, s2, 0, s3, dp);
    }
}
