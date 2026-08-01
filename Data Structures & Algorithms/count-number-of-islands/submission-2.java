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
    int[] parent, size, rank;
    public int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public void unionBySize(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv) return;
        if(size[pu] > size[pv]){
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        else{
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
    public void unionByRank(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv) return;
        if(rank[pu] > rank[pv]){
            parent[pv] = pu;
        }
        else if(rank[pv] > rank[pu]){
            parent[pu] = pv;
        }
        else{
            parent[pv] = pu;
            rank[pu]++;
        }
    }
    public int numIslands(char[][] grid) {
        r = grid.length;
        c = grid[0].length;
        parent = new int[r*c];
        size = new int[r*c];
        rank = new int[r*c];
        for(int i=0 ; i<r*c ; i++){
            parent[i] = i;
            size[i] = 1;
            rank[i] = 0;
        }
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(grid[i][j] == '1'){
                    for(int[] d : directions){
                        int adjRow = i + d[0];
                        int adjCol = j + d[1];
                        if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && grid[adjRow][adjCol]=='1'){
                            int parent1 = i * c + j;
                            int parent2 = adjRow * c + adjCol;

                            unionBySize(parent1, parent2);
                            // unionByRank(parent1, parent2);
                        }
                    }
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(grid[i][j] == '1'){
                    set.add(find(i*c+j));
                }
            }
        }
        return set.size();


        // r = grid.length;
        // c = grid[0].length;
        // boolean[][] visited = new boolean[r][c];
        // int result = 0;
        // for(int i=0 ; i<r ; i++){
        //     for(int j=0 ; j<c ; j++){
        //         if(grid[i][j]=='1' && !visited[i][j]){
        //             result++;
        //             // dfs(i, j, visited, grid);
        //             bfs(i, j, visited, grid);
        //         }
        //     }
        // }
        // return result;
    }
}
