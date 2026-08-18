class Solution {
    public List<Integer> majorityElement(int[] nums) {

        // int n = nums.length;
        // Map<Integer, Integer> map = new HashMap<>();
        // for(int num : nums){
        //     map.put(num, map.getOrDefault(num, 0)+1);
        // }

        // List<Integer> result = new ArrayList<>();
        // for(int key : map.keySet()){
        //     int freq = map.get(key);
        //     if(freq > n/3){
        //         result.add(key);
        //     }
        // }
        // return result;

        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        int freq = 1;
        for(int i=1 ; i<n ; i++){
            if(nums[i] == nums[i-1]){
                freq++;
            }
            else{
                if(freq > n/3) result.add(nums[i-1]);
                freq = 1;
            }
        }
        if(freq > n/3){
            result.add(nums[n-1]);
        }
        return result;

    }
}