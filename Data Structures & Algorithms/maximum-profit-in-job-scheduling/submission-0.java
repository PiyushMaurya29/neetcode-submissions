class Solution {
    public int solve(int prev, int index, int[][] pair){
        if(index >= pair.length) return 0;
        
        int take = 0;
        if(prev==-1 || pair[index][0]>=pair[prev][1]){
            take = pair[index][2] + solve(index, index+1, pair);
        }
        int notTake = solve(prev, index+1, pair);
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

        return solve(-1, 0, pair);
    }
}