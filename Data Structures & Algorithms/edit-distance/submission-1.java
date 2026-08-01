class Solution {
    public int solve(int i, String word1, int j, String word2, int[][] dp){
        if(i>=word1.length() && j>=word2.length()){
            return 0;
        }
        if(i >= word1.length()){
            return word2.length()-j;
        }
        if(j >= word2.length()){
            return word1.length()-i;
        }
        if(word1.charAt(i) == word2.charAt(j)){
            return dp[i][j] = solve(i+1, word1, j+1, word2, dp);
        }
        else{
            int insert = 1 + solve(i, word1, j+1, word2, dp);
            int delete = 1 + solve(i+1, word1, j, word2, dp);
            int replace = 1 + solve(i+1, word1, j+1, word2, dp);
            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
    }
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, word1, 0, word2, dp);
    }
}
