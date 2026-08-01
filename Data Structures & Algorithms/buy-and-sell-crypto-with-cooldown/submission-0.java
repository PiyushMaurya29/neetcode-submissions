class Solution {
    public int solve(int index, int canBuy, int[] prices){
        if(index >= prices.length) return 0;
        if(canBuy == 1){
            int buy = -prices[index] + solve(index+1, 0, prices);
            int notBuy = solve(index+1, 1, prices);
            return Math.max(buy, notBuy);
        }
        else{
            int sell = prices[index] + solve(index+2, 1, prices);
            int notSell = solve(index+1, 0, prices);
            return Math.max(sell, notSell);
        }
    }
    public int maxProfit(int[] prices) {
        return solve(0, 1, prices);
    }
}
