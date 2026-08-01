class Solution {
    public int solve(int index, int[] coins, int amount, int[][] dp){
        if(amount == 0) return 1;
        if(index >= coins.length || amount<0) return 0;
        if(dp[index][amount] != -1){
            return dp[index][amount];
        }
        int take = solve(index, coins, amount-coins[index], dp);
        int notTake = solve(index+1, coins, amount, dp);
        return dp[index][amount] = (take+notTake);
    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, coins, amount, dp);
    }
}
