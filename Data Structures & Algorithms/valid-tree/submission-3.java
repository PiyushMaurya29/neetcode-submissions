class Solution {
    public boolean checkCycleDFS(int node, int parent, boolean[] visited, List<List<Integer>> adjList){
        visited[node] = true;
        for(int adjNode : adjList.get(node)){
            if(!visited[adjNode]){
                if(checkCycleDFS(adjNode, node, visited, adjList)){
                    return true;
                }
            }
            else if(adjNode != parent){
                return true;
            }
        }
        return false;
    }
    public boolean checkCycleBFS(boolean[] visited, List<List<Integer>> adjList){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, -1}); // Node and Parent
        visited[0] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int currNode = curr[0];
            int parent = curr[1];
            for(int adjNode : adjList.get(currNode)){
                if(!visited[adjNode]){
                    visited[adjNode] = true;
                    queue.offer(new int[]{adjNode, currNode});
                }
                else if(adjNode != parent){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1){ // Property of tree
            return false; 
        }
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] e : edges){
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        // if(checkCycleDFS(0, -1, visited, adjList)){
        //     return false;
        // }
        if(checkCycleBFS(visited, adjList)){
            return false;
        }
        for(int i=0 ; i<n ; i++){
            if(!visited[i]) return false;
        }
        return true;
    }
}
