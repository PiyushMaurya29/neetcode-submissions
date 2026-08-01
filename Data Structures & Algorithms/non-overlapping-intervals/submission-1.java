class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        int result = 0;
        int maxEnd = intervals[0][1];

        for(int i=1 ; i<intervals.length ; i++){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if(currStart < maxEnd){
                result++;
            }
            else maxEnd = currEnd;
        }
        return result;


        // Sort based on the end of the interval
        // Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));

        // int prevEnd = Integer.MIN_VALUE;
        // int count = 0;
        // for(int[] i : intervals){
        //     int start = i[0];
        //     int end = i[1];
        //     if(prevEnd > start){
        //         count++;
        //     }
        //     else prevEnd = end;
        // }
        // return count;
    }
}
