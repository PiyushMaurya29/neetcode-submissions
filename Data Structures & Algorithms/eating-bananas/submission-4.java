class Solution {
    public int getMax(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int p : piles){
            max = Math.max(max, p);
        }
        return max;
    }
    public boolean isPossible(int k, int[] piles, int h){
        int time = 0;
        for(int p : piles){
            time += Math.ceil((double)p / k);
            if(time > h) return false;
        }
        // return time <= h;
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        if(piles.length > h) return -1;

        int result = -1;

        int left=1, right=getMax(piles);

        while(left <= right){
            int mid = left + (right-left)/2;
            if(isPossible(mid, piles, h)){
                result = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return result;
    }
}
