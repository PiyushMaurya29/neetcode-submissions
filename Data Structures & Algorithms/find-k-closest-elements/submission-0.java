class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int[][] pair = new int[n][2];
        for(int i=0 ; i<n ; i++){
            pair[i][0] = Math.abs(arr[i]-x);
            pair[i][1] = arr[i];
        }

        Arrays.sort(pair, (a,b) ->{
            if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        List<Integer> result = new ArrayList<>();
        for(int i=0 ; i<k ; i++){
            result.add(pair[i][1]);
        }
        Collections.sort(result);
        return result;
    }
}