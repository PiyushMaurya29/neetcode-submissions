class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i=0, j=0;
        while(j < n){
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
            if(j-i+1 > k){
                map.put(nums[i], map.get(nums[i])-1);
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }
            if(j-i+1 == k){
                result[i] = map.lastKey();
            }
            j++;
        }
        return result;
        


        // int n = nums.length;
        // int[] result = new int[n-k+1];
        // PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        // int i=0, j=0;
        // while(j < n){
        //     maxHeap.offer(new int[]{nums[j], j});
        //     if(j-i+1 > k){
        //         i++;
        //     }
        //     if(j-i+1 == k){
        //         while(maxHeap.peek()[1] < i){
        //             maxHeap.poll();
        //         }
        //         result[i] = maxHeap.peek()[0];
        //     }
        //     j++;
        // }
        // return result;



        // int n = nums.length;
        // int[] result = new int[n-k+1];
        // for(int i=0 ; i<=n-k ; i++){
        //     int max = Integer.MIN_VALUE;
        //     for(int j=i ; j<i+k ; j++){
        //         max = Math.max(max, nums[j]);
        //     }
        //     result[i] = max;
        // }
        // return result;
    }
}
