class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int result = 0;
        int sum = 0;
        for(int num : nums){
            sum += num;
            if(map.containsKey(sum-k)){
                result += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return result;


        // int n = nums.length;
        // int result = 0;
        // for(int i=0 ; i<n ; i++){
        //     int sum = 0;
        //     for(int j=i ; j<n ; j++){
        //         sum += nums[j];
        //         if(sum == k){
        //             result++;
        //         }
        //     }
        // }
        // return result;
    }
}