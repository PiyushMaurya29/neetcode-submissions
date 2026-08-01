class Solution {
    public int removeElement(int[] nums, int val) {
        int[] freq = new int[51];
        for(int num : nums){
            freq[num]++;
        }

        int index = 0;
        for(int i=0 ; i<=50 ; i++){
            if(i == val) continue;
            while(freq[i] > 0){
                nums[index++] = i;
                freq[i]--;
            }
        }
        return index;
    }
}