class Solution {
    public void dfs(int node, boolean[] visited, List<List<Integer>> adjList){
        visited[node] = true;
        for(int adjNode : adjList.get(node)){
            if(!visited[adjNode]){
                dfs(adjNode, visited, adjList);
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            adjList.add(new ArrayList<>());
        }
        int index = -1;
        for(int i=0 ; i<n ; i++){
            int u = edges[i][0]-1;
            int v = edges[i][1]-1;

            boolean[] visited = new boolean[n];
            dfs(u, visited, adjList);
            if(visited[v]) index = i;

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return edges[index];
    }
}
