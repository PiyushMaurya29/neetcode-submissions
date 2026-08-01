class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                set.remove(num);
            }
            else{
                set.add(num);
            }
        }
        for(int num : set){
            return num;
        }
        return -1;
        

        // Map<Integer, Integer> map = new HashMap<>();
        // for(int num : nums){
        //     map.put(num, map.getOrDefault(num, 0)+1);
        // }
        // for(int key : map.keySet()){
        //     if(map.get(key) == 1){
        //         return key;
        //     }
        // }
        // return -1;
    }
}
