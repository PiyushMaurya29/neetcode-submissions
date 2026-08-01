class Solution {
    public int solve(int prev, int index, int[][] pair, int[][] dp){
        if(index >= pair.length) return 0;
        if(dp[prev+1][index] != -1){
            return dp[prev+1][index];
        }
        
        int take = 0;
        if(prev==-1 || pair[index][0]>=pair[prev][1]){
            take = pair[index][2] + solve(index, index+1, pair, dp);
        }
        int notTake = solve(prev, index+1, pair, dp);
        return dp[prev+1][index] = Math.max(take, notTake);
    }
    public int findNextValidIndex(int left, int right, int endTime, int[][] pair){
        int result = pair.length;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(pair[mid][0] >= endTime){
                result = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return result;
    }
    public int solve(int index, int[][] pair, int[] dp){
        if(index >= pair.length) return 0;

        int nextValidIndex = findNextValidIndex(index+1, pair.length-1, pair[index][1], pair);
        int take = pair[index][2] + solve(nextValidIndex, pair, dp);
        int notTake = solve(index+1, pair, dp);
        return Math.max(take, notTake);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        int[][] pair = new int[n][3];
        for(int i=0 ; i<n ; i++){
            pair[i][0] = startTime[i];
            pair[i][1] = endTime[i];
            pair[i][2] = profit[i];
        }
        Arrays.sort(pair, (a,b) -> Integer.compare(a[0], b[0]));

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, pair, dp);


        // int n = startTime.length;
        
        // int[][] pair = new int[n][3];
        // for(int i=0 ; i<n ; i++){
        //     pair[i][0] = startTime[i];
        //     pair[i][1] = endTime[i];
        //     pair[i][2] = profit[i];
        // }

        // Arrays.sort(pair, (a,b) -> Integer.compare(a[0], b[0]));

        // int[][] dp = new int[n+1][n];
        // for(int[] row : dp){
        //     Arrays.fill(row, -1);
        // }
        // return solve(-1, 0, pair, dp);
    }
}