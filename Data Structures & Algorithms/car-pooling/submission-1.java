class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] mark = new int[10001];

        for(int[] t : trips){
            int passengers = t[0];
            if(passengers > capacity){
                return false;
            }
            int from = t[1];
            int to = t[2];

            mark[from] += passengers;
            mark[to] -= passengers;
        }

        int currCapacity = 0;
        for(int i=1 ; i<=10000 ; i++){
            currCapacity += mark[i-1];
            if(currCapacity > capacity){
                return false;
            }
        }
        return true;

    }
}