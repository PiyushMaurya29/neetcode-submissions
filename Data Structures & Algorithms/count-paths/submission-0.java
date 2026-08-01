class Solution {
    public int solve(int r, int c, int m, int n){
        if(r==m-1 && c==n-1) return 1;
        if(r>=m || c>=n) return 0;
        int moveDown = solve(r+1, c, m, n);
        int moveRight = solve(r, c+1, m, n);
        return moveDown + moveRight;
    }
    public int uniquePaths(int m, int n) {
        return solve(0, 0, m, n);
    }
}
