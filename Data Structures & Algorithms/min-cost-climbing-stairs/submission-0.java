class Solution {
    public int solve(int index, int[] cost){
        if(index == cost.length-1){
            return cost[index];
        }
        if(index >= cost.length) return 0;
        int oneStep = cost[index] + solve(index+1, cost);
        int twoStep = cost[index] + solve(index+2, cost);
        return Math.min(oneStep, twoStep);
    }
    public int minCostClimbingStairs(int[] cost) {
        int startAt0 = solve(0, cost);
        int startAt1 = solve(1, cost);
        return Math.min(startAt0, startAt1);
    }
}
