class Solution {
    public int atMost(int k, int[] nums){
        int n = nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();

        int count = 0; // Count subarray having less than or equal to k distinct elements
        int i=0, j=0;
        while(j < n){
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
            while(map.size() > k){
                map.put(nums[i], map.get(nums[i])-1);
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }
            count += (j-i+1);
            j++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(k, nums) - atMost(k-1, nums);

        // int n = nums.length;
        // int result = 0;
        // for(int i=0 ; i<n ; i++){
        //     Set<Integer> set = new HashSet<>();
        //     for(int j=i ; j<n ; j++){
        //         set.add(nums[j]);
        //         if(set.size() == k) result++;
        //         else if(set.size() > k) break;
        //     }
        // }
        // return result;
    }
}