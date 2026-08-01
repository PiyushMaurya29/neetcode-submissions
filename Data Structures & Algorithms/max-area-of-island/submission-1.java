class Solution {
    int r, c;
    int[][] directions = {{-1,0}, {0,-1}, {0,1}, {1,0}};
    public void dfs(int i, int j, int[] area, boolean[][] visited, int[][] grid){
        area[0]++;
        visited[i][j] = true;
        for(int[] d : directions){
            int adjRow = i + d[0];
            int adjCol = j + d[1];
            if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && !visited[adjRow][adjCol] && grid[adjRow][adjCol]==1){
                dfs(adjRow, adjCol, area, visited, grid);
            }
        }
    }
    public int bfs(int i, int j, int[][] grid){
        boolean[][] visited = new boolean[r][c];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        int area = 0;
        while(!queue.isEmpty()){
            area++;
            int[] curr = queue.poll();
            for(int[] d : directions){
                int adjRow = curr[0] + d[0];
                int adjCol = curr[1] + d[1];
                if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && !visited[adjRow][adjCol] && grid[adjRow][adjCol]==1){
                    visited[adjRow][adjCol] = true;
                    queue.offer(new int[]{adjRow, adjCol});
                }
            }
        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        int result = 0;
        
        boolean[][] visited = new boolean[r][c];
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    // int[] area = {0};
                    // dfs(i, j, area, visited, grid);
                    // result = Math.max(result, area[0]);

                    int area = bfs(i, j, grid);
                    result = Math.max(result, area);
                }
            }
        }
        return result;
    }
}
