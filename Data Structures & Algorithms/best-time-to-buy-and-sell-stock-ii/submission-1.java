class Solution {
    public int solve(int index, int[] prices, int canBuy, int[][] dp){
        if(index >= prices.length) return 0;
        if(dp[index][canBuy] != -1){
            return dp[index][canBuy];
        }
        if(canBuy == 1){
            int buy = -prices[index] + solve(index+1, prices, 0, dp);
            int notBuy = solve(index+1, prices, 1, dp);
            return dp[index][canBuy] = Math.max(buy, notBuy);
        }
        else{
            int sell = prices[index] + solve(index+1, prices, 1, dp);
            int notSell = solve(index+1, prices, 0, dp);
            return dp[index][canBuy] = Math.max(sell, notSell);
        }
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, prices, 1, dp);
    }
}