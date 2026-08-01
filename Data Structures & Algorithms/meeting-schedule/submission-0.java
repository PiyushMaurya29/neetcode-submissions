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
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        
        int prevMaxEnd = -1;
        for(int i=0 ; i<intervals.size() ; i++){
            int currStart = intervals.get(i).start;
            int currEnd = intervals.get(i).end;
            if(currStart < prevMaxEnd){
                return false;
            }
            prevMaxEnd = Math.max(prevMaxEnd, currEnd);
        }
        return true;
    }
}
