class Solution {
    int r, c;
    int[][] directions = {{-1,0}, {0,-1}, {0,1}, {1,0}};
    public void dfs(int i, int j, boolean[] check, int[][] heights, boolean[][] visited){
        if(i==0 || j==0) check[0] = true;
        if(i==r-1 || j==c-1) check[1] = true; 
        visited[i][j] = true;
        for(int[] d : directions){
            int adjRow = i + d[0];
            int adjCol = j + d[1];
            if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && !visited[adjRow][adjCol] && heights[adjRow][adjCol]<=heights[i][j]){
                dfs(adjRow, adjCol, check, heights, visited);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        r = heights.length;
        c = heights[0].length;

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                boolean[][] visited = new boolean[r][c];
                boolean[] check = {false, false};
                dfs(i, j, check, heights, visited);
                if(check[0] && check[1]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }
        }

        return result;
        
    }
}
