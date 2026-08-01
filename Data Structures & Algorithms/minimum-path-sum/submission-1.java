class Solution {
    int row, col;
    public int solve(int i, int j, int[][] grid, int[][] dp){
        if(i==row-1 && j==col-1){
            return grid[i][j];
        }
        if(i>=row || j>=col){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int down = solve(i+1, j, grid, dp);
        int right = solve(i, j+1, grid, dp);
        return dp[i][j] = grid[i][j] + Math.min(down, right);
    }
    public int minPathSum(int[][] grid) {
        row = grid.length;
        col = grid[0].length;

        int[][] dp = new int[row][col];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, 0, grid, dp);
    }
}