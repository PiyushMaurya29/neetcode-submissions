class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i=0 ; i<=n ; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] t : times){
            adjList.get(t[0]).add(new int[]{t[1], t[2]});
        }
        int[] timeTaken = new int[n+1];
        Arrays.fill(timeTaken, Integer.MAX_VALUE);
        timeTaken[k] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[]{0, k}); // time and node
        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int currTime = curr[0];
            int currNode = curr[1];
            for(int[] adj : adjList.get(curr[1])){
                int adjNode = adj[0];
                int adjTime = adj[1];
                int finalTime = currTime + adjTime;
                if(finalTime < timeTaken[adjNode]){
                    timeTaken[adjNode] = finalTime;
                    minHeap.offer(new int[]{finalTime, adjNode});
                }
            }
        }
        int maxTime = Integer.MIN_VALUE;
        for(int i=1 ; i<=n ; i++){
            if(timeTaken[i] == Integer.MAX_VALUE){
                return -1;
            }
            maxTime = Math.max(maxTime, timeTaken[i]);
        }
        return maxTime;
    }
}
