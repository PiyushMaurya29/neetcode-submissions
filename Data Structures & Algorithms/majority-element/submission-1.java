class Solution {
    public int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 1;
        for(int i=1 ; i<nums.length ; i++){
            if(nums[i] == result){
                count++;
            }
            else{
                count--;
                if(count == 0){
                    result = nums[i];
                    count = 1;
                }
            }
        }
        return result;


        // Map<Integer, Integer> map = new HashMap<>();
        // for(int num : nums){
        //     map.put(num, map.getOrDefault(num, 0)+1);
        //     if(map.get(num) > nums.length/2){
        //         return num;
        //     }
        // }
        // return -1;


    }
}