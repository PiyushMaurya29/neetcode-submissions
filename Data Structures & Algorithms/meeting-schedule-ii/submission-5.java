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
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(Interval i : intervals){
            // if(minHeap.isEmpty()){ // No room allocated till now
            //     minHeap.offer(i.end);
            // }
            // else if(minHeap.peek() <= i.start){
            //     // Old room can be used because it's meeting has been over
            //     minHeap.poll();
            //     minHeap.offer(i.end);
            // }
            // else{
            //     // Create a new room for the meeting
            //     minHeap.offer(i.end);
            // }


            // If earliest ending meeting ends before current starts, reuse that room
            if (!minHeap.isEmpty() && i.start >= minHeap.peek()) {
                minHeap.poll();
            }

            // Allocate room (new or reused)
            minHeap.offer(i.end);
        }
        return minHeap.size();



        // intervals.sort((a, b) -> a.start - b.start);
        // PriorityQueue<int[]> minHeapEndTime = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        // for(int i=0 ; i<intervals.size() ; i++){
        //     int startTime = intervals.get(i).start;
        //     int endTime = intervals.get(i).end;
        //     if(minHeapEndTime.isEmpty()){
        //         minHeapEndTime.offer(new int[]{startTime, endTime});
        //     }
        //     else{
        //         int[] prevMeet = minHeapEndTime.poll();
        //         if(prevMeet[1] <= startTime){
        //             minHeapEndTime.offer(new int[]{startTime, endTime});
        //         }
        //         else{
        //             minHeapEndTime.offer(prevMeet);
        //             minHeapEndTime.offer(new int[]{startTime, endTime});
        //         }
        //     }
        // }
        // return minHeapEndTime.size();
    }
}
