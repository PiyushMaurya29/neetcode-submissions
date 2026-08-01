class Solution {
    int result;
    public void solve(int index, StringBuilder sb, String s, String t){
        if(index >= s.length()){
            if(sb.toString().equals(t)){
                result++;
            }
            return;
        }
        sb.append(s.charAt(index));
        solve(index+1, sb, s, t);
        sb.deleteCharAt(sb.length()-1);
        solve(index+1, sb, s, t);
    }
    public int solve(int i, String s, int j, String t, int[][] dp){
        if(j >= t.length()) return 1;
        if(i >= s.length()) return 0;
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int take = 0;
        if(s.charAt(i) == t.charAt(j)){
            take = solve(i+1, s, j+1, t, dp);
        }
        int notTake = solve(i+1, s, j, t, dp);
        return dp[i][j] = (take + notTake);
    }
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, s, 0, t, dp);


        // result = 0;
        // solve(0, new StringBuilder(), s, t);
        // return result;
    }
}
