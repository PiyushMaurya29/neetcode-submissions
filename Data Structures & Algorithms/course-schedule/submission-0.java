class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0 ; i<numCourses ; i++){
            adjList.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for(int[] prerequisite : prerequisites){
            adjList.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }
        List<Integer> result = new ArrayList<>(); // TopoSort
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ; i<numCourses ; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int curr = queue.poll();
            result.add(curr);
            for(int adjNode : adjList.get(curr)){
                inDegree[adjNode]--;
                if(inDegree[adjNode] == 0){
                    queue.offer(adjNode);
                }
            }
        }
        return result.size() == numCourses;
    }
}
