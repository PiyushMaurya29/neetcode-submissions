class Solution {
    int r, c;
    int[][] directions = {{-1,0}, {0,-1}, {0,1}, {1,0}};
    public void dfs(int i, int j, boolean[][] visited, char[][] grid){
        visited[i][j] = true;
        for(int[] d : directions){
            int adjRow = i + d[0];
            int adjCol = j + d[1];
            if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && grid[adjRow][adjCol]=='1' && !visited[adjRow][adjCol]){
                dfs(adjRow, adjCol, visited, grid);
            }
        }
    }
    public void bfs(int i, int j, boolean[][] visited, char[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int[] d : directions){
                int adjRow = curr[0] + d[0];
                int adjCol = curr[1] + d[1];
                if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && !visited[adjRow][adjCol] && grid[adjRow][adjCol]=='1'){
                    visited[adjRow][adjCol] = true;
                    queue.offer(new int[]{adjRow, adjCol});
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        r = grid.length;
        c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        int result = 0;
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    result++;
                    // dfs(i, j, visited, grid);
                    bfs(i, j, visited, grid);
                }
            }
        }
        return result;
    }
}
