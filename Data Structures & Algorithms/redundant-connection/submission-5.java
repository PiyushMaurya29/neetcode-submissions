class Solution {
    public void dfs(int node, boolean[] visited, List<List<Integer>> adjList){
        visited[node] = true;
        for(int adjNode : adjList.get(node)){
            if(!visited[adjNode]){
                dfs(adjNode, visited, adjList);
            }
        }
    }
    public void bfs(int node, boolean[] visited, List<List<Integer>> adjList){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int adjNode : adjList.get(curr)){
                if(!visited[adjNode]){
                    visited[adjNode] = true;
                    queue.offer(adjNode);
                }
            }
        }
    }
    int[] parent, rank, size;
    public int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
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
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        for(int i=0 ; i<n ; i++){
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
        int index = -1;
        for(int i=0 ; i<n ; i++){
            int u = edges[i][0]-1;
            int v = edges[i][1]-1;

            int pu = find(u);
            int pv = find(v);

            if(pu == pv) index = i;
            else{
                // unionByRank(pu, pv);
                unionBySize(pu, pv);
            }
        }
        return edges[index];


        // int n = edges.length;
        // List<List<Integer>> adjList = new ArrayList<>();
        // for(int i=0 ; i<n ; i++){
        //     adjList.add(new ArrayList<>());
        // }
        // int index = -1;
        // for(int i=0 ; i<n ; i++){
        //     int u = edges[i][0]-1;
        //     int v = edges[i][1]-1;

        //     boolean[] visited = new boolean[n];
        //     // dfs(u, visited, adjList);
        //     bfs(u, visited, adjList);
        //     if(visited[v]) index = i;

        //     adjList.get(u).add(v);
        //     adjList.get(v).add(u);
        // }
        // return edges[index];
    }
}
