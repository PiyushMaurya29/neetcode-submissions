class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if(digits[n-1] != 9){
            digits[n-1]++;
            return digits;
        }
        List<Integer> list = new ArrayList<>();
        int carry = 1; // Lets assume we are adding one at last by taking carry = 1;
        for(int i=n-1 ; i>=0 ; i--){
            int sum = carry + digits[i];
            list.add(sum%10);
            carry = sum/10;
        }
        if(carry != 0){
            list.add(carry);
        }
        Collections.reverse(list);
        int[] result = new int[list.size()];
        for(int i=0 ; i<list.size() ; i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
