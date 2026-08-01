/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        // int prevMaxEnd = -1;
        // for(int i=0 ; i<intervals.size() ; i++){
        //     int currStart = intervals.get(i).start;
        //     int currEnd = intervals.get(i).end;
        //     if(currStart < prevMaxEnd){
        //         return false;
        //     }
        //     // prevMaxEnd = Math.max(prevMaxEnd, currEnd);
        //     prevMaxEnd = currEnd;
        // }
        // return true;

        int n = intervals.size();
        for(int i=0 ; i<n ; i++){
            int start1 = intervals.get(i).start;
            int end1 = intervals.get(i).end;
            for(int j=i+1 ; j<n ; j++){
                int start2 = intervals.get(j).start;
                if(start2>=start1 && start2<end1){
                    return false;
                }
            }
        }
        return true;
    }
}
