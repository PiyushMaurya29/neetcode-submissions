class Solution {
    public int solve(int index, int canBuy, int[] prices, int[][] dp){
        if(index >= prices.length) return 0;
        if(dp[index][canBuy] != -1){
            return dp[index][canBuy];
        }
        if(canBuy == 1){
            int buy = -prices[index] + solve(index+1, 0, prices, dp);
            int notBuy = solve(index+1, 1, prices, dp);
            return dp[index][canBuy] = Math.max(buy, notBuy);
        }
        else{
            int sell = prices[index] + solve(index+2, 1, prices, dp);
            int notSell = solve(index+1, 0, prices, dp);
            return dp[index][canBuy] = Math.max(sell, notSell);
        }
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, 1, prices, dp);
    }
}
