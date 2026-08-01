class Solution {
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
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        for(int i=0 ; i<n ; i++){
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
        List<int[]> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            for(int j=i+1 ; j<n ; j++){
                int distance = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                list.add(new int[]{distance, i, j});
            }
        }
        Collections.sort(list, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int resultValue = 0;
        
        for(int[] l : list){
            int w = l[0];
            int u = l[1];
            int v = l[2];
            if(find(u) != find(v)){
                resultValue += w;
                // unionByRank(u, v);
                unionBySize(u, v);
                result.add(new int[]{u, v});
            }
        }
        return resultValue;
    }
}
