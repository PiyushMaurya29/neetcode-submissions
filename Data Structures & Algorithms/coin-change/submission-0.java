class Solution {
    public int solve(int index, int[] coins, int target){
        if(target < 0) return Integer.MAX_VALUE;
        if(index >= coins.length){
            if(target == 0) return 0;
            return Integer.MAX_VALUE;
        }
        int take = Integer.MAX_VALUE;
        if(coins[index] <= target){
            int result = solve(index, coins, target-coins[index]);
            if(result != Integer.MAX_VALUE){
                take = 1 + result;
            }
        }
        int notTake = solve(index+1, coins, target);
        return Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int result = solve(0, coins, amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
