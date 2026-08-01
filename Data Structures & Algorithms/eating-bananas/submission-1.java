class Solution {
    public int getMax(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int p : piles){
            max = Math.max(max, p);
        }
        return max;
    }
    public boolean isPossible(int speed, int[] piles, int h){
        int time = 0;
        for(int p : piles){
            // time += Math.ceil((double)p/speed);
            time += (p+speed-1)/speed;
        }
        return time <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles);

        int result = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(isPossible(mid, piles, h)){
                result = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return result;
    }
}
