class Solution {
    public int solve(int r, int c, int m, int n, int[][] dp){
        if(r==m-1 && c==n-1) return 1;
        if(r>=m || c>=n) return 0;
        if(dp[r][c] != -1){
            return dp[r][c];
        }
        int moveDown = solve(r+1, c, m, n, dp);
        int moveRight = solve(r, c+1, m, n, dp);
        return dp[r][c] = moveDown + moveRight;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, 0, m, n, dp);
    }
}
