class Solution {
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
            size[pu]++;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        parent = new int[n];
        size = new int[n];
        rank = new int[n];

        for(int i=0 ; i<n ; i++){
            parent[i] = i;
            size[i] = 1;
            rank[i] = 0;
        }

        Map<String, Integer> map1 = new HashMap<>(); // Map Emails with the group
        for(int i=0 ; i<n ; i++){
            List<String> list = accounts.get(i);
            for(int j=1 ; j<list.size() ; j++){
                String email = list.get(j);
                if(!map1.containsKey(email)){
                    map1.put(email, i);
                }
                else{
                    int oldParent = map1.get(email);
                    unionBySize(oldParent, i);
                }
            }
        }

        Map<Integer, List<String>> map2 = new HashMap<>(); // Group and allEmails Map
        for(var e : map1.keySet()){
            int g = map1.get(e);
            int p = find(g);
            
            if(!map2.containsKey(p)){
                map2.put(p, new ArrayList<>());
            }
            map2.get(p).add(e);
        }

        List<List<String>> result = new ArrayList<>();
        for(int g : map2.keySet()){
            List<String> ans = new ArrayList<>();
            String name = accounts.get(g).get(0);
            ans.add(name);

            List<String> list = map2.get(g);
            Collections.sort(list);
            for(var e : list){
                ans.add(e);
            }
            result.add(ans);
        }
        return result;
    }
}