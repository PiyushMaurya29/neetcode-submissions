class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for(int[] i : intervals){
            list.add(i);
        }
        list.add(newInterval);

        Collections.sort(list, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> list2 = new ArrayList<>();
        for(int[] l : list){
            if(list2.isEmpty()){
                list2.add(l);
            }
            else{
                int n = list2.size();
                if(list2.get(n-1)[1] >= l[0]){
                    list2.get(n-1)[1] = Math.max(list2.get(n-1)[1], l[1]);
                }
                else{
                    list2.add(l);
                }
            }
        }
        int n = list2.size();
        int[][] result = new int[n][2];
        for(int i=0 ; i<n ; i++){
            result[i][0] = list2.get(i)[0];
            result[i][1] = list2.get(i)[1];
        }
        return result;
    }
}
