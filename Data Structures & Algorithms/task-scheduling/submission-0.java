class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(var t : tasks){
            freq[t-'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int f : freq){
            if(f > 0){
                maxHeap.offer(f);
            }
        }
        Queue<int[]> queue = new LinkedList<>(); // Next time and the remaining tasks
        int time = 0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;
            if(!queue.isEmpty() && queue.peek()[0]==time){
                maxHeap.offer(queue.poll()[1]);
            }
            if(!maxHeap.isEmpty()){
                int curr = maxHeap.poll();
                if(curr-1 > 0){
                    queue.offer(new int[]{time+n+1, curr-1});
                }
            }
        }
        return time;
    }
}
