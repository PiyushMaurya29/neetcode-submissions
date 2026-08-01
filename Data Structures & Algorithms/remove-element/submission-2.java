class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int num : nums){
            // if(num == val) continue;
            // nums[index++] = num;

            if(num != val){
                nums[index++] = num;
            }
        }
        return index;


        // int[] freq = new int[51];
        // for(int num : nums){
        //     freq[num]++;
        // }

        // int index = 0;
        // for(int i=0 ; i<=50 ; i++){
        //     if(i == val) continue;
        //     while(freq[i] > 0){
        //         nums[index++] = i;
        //         freq[i]--;
        //     }
        // }
        // return index;
    }
}