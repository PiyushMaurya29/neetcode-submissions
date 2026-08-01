class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] directions = {{-1,0}, {0,-1}, {0,1}, {1,0}};
        int r = grid.length;
        int c = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(grid[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0 ; i<size ; i++){
                int[] cell = queue.poll();
                for(int[] direction : directions){
                    int adjRow = cell[0] + direction[0];
                    int adjCol = cell[1] + direction[1];
                    if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && grid[adjRow][adjCol]==Integer.MAX_VALUE){
                        grid[adjRow][adjCol] = level;
                        queue.offer(new int[]{adjRow, adjCol});
                    }
                }
            }
            level++;
        }
    }
}
