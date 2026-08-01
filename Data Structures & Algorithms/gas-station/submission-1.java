class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for(int i=0 ; i<n ; i++){
            if(gas[i] < cost[i]) continue;
            boolean check = true;
            int currGas = 0;
            int currCost = 0;
            for(int j=i ; j<i+n ; j++){
                int index = j%n;
                currGas += gas[index];
                currCost += cost[index];
                if(currGas < currCost){
                    check = false;
                    break;
                }
            }
            if(check) return i;
        }
        return -1; 
    }
}
