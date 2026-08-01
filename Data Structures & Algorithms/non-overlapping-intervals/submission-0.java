class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort based on the end of the interval
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));

        int prevEnd = Integer.MIN_VALUE;
        int count = 0;
        for(int[] i : intervals){
            int start = i[0];
            int end = i[1];
            if(prevEnd > start){
                count++;
            }
            else prevEnd = end;
        }
        return count;
    }
}
