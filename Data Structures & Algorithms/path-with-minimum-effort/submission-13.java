class Solution {
    int r, c;
    int[][] directions = {{-1,0}, {0,-1}, {0,1}, {1,0}};
    public int getRange(int[][] heights){
        // int maxDiff = Integer.MIN_VALUE;
        // for(int i=0 ; i<r ; i++){
        //     for(int j=0 ; j<c ; j++){
        //         if(i-1>=0) maxDiff = Math.max(maxDiff, Math.abs(heights[i][j]-heights[i-1][j]));
        //         if(j-1>=0) maxDiff = Math.max(maxDiff, Math.abs(heights[i][j]-heights[i][j-1]));
        //     }
        // }
        // return maxDiff;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int[] row : heights){
            for(int ele : row){
                min = Math.min(min, ele);
                max = Math.max(max, ele);
            }
        }
        return max-min;
    }
    public boolean isPossibleDFS(int i, int j, int mid, int[][] heights, boolean[][] visited){
        if(i==r-1 && j==c-1) return true;
        visited[i][j] = true;
        for(int[] d : directions){
            int adjRow = i + d[0];
            int adjCol = j + d[1];
            if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && !visited[adjRow][adjCol] && Math.abs(heights[i][j]-heights[adjRow][adjCol])<=mid){
                if(isPossibleDFS(adjRow, adjCol, mid, heights, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isPossibleBFS(int mid, int[][] heights){
        boolean[][] visited = new boolean[r][c];
        // Queue<int[]> queue = new LinkedList<>();
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            if(curr[0]==r-1 && curr[1]==c-1){
                return true;
            }
            for(int[] d : directions){
                int adjRow = curr[0] + d[0];
                int adjCol = curr[1] + d[1];
                if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && !visited[adjRow][adjCol] && Math.abs(heights[curr[0]][curr[1]]-heights[adjRow][adjCol])<=mid){
                    visited[adjRow][adjCol] = true;
                    queue.offer(new int[]{adjRow, adjCol});
                }
            }
        }
        return false;

    }
    public int minimumEffortPath(int[][] heights) {
        r = heights.length;
        c = heights[0].length;

        int left=0, right=getRange(heights);

        int result = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            // boolean[][] visited = new boolean[r][c];
            // if(isPossibleDFS(0, 0, mid, heights, visited)){
            //     result = mid;
            //     right = mid - 1;
            // }
            if(isPossibleBFS(mid, heights)){
                result = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return result;
    }
}