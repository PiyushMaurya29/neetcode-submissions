class NumArray {
    int[] temp;
    public NumArray(int[] nums) {
        int n = nums.length;
        temp = new int[n];
        for(int i=0 ; i<n ; i++){
            temp[i] = nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i=left ; i<=right ; i++){
            sum += temp[i];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */