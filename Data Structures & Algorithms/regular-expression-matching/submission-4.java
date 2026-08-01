class Solution {
    int m, n;
    public boolean solve(int i, String s, int j, String p, Boolean[][] dp){
        if(i==-1 && j==-1) return true;
        if(j==-1) return false;
        if(i==-1){
            if(p.charAt(j)=='*'){
                return solve(i, s, j-2, p, dp);
            }
            return false;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'){
            return dp[i][j] = solve(i-1, s, j-1, p, dp);
        }
        else if(p.charAt(j)=='*'){
            boolean skip = solve(i, s, j-2, p, dp);
            boolean take = false;
            if(s.charAt(i)==p.charAt(j-1) || p.charAt(j-1)=='.'){
                take = solve(i-1, s, j, p, dp);
            }
            return dp[i][j] = skip || take;
        }
        else return dp[i][j] = false;
    }
    public boolean isMatch(String s, String p) {
        m = s.length();
        n = p.length();
        Boolean[][] dp = new Boolean[m+1][n+1];
        return solve(m-1, s, n-1, p, dp);
    }
}
