class Solution {
    public int solve(int index, int[] coins, int target, int[][] dp){
        if(target < 0) return Integer.MAX_VALUE;
        if(index >= coins.length){
            if(target == 0) return 0;
            return Integer.MAX_VALUE;
        }
        if(dp[index][target] != -1){
            return dp[index][target];
        }
        // int take = Integer.MAX_VALUE;
        // if(coins[index] <= target){
        //     int result = solve(index, coins, target-coins[index], dp);
        //     if(result != Integer.MAX_VALUE){
        //         take = 1 + result;
        //     }
        // }
        int result = solve(index, coins, target-coins[index], dp);
        int take = Integer.MAX_VALUE;
        if(result != Integer.MAX_VALUE){
            take = 1 + result;
        }
        int notTake = solve(index+1, coins, target, dp);
        return dp[index][target] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int result = solve(0, coins, amount, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
