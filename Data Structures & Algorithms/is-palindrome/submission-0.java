class Solution {
    public boolean isValid(char ch){
        return (ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>='0' && ch<='9');
    }
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int n = s.length();
        int left=0, right=n-1;

        while(left < right){
            while(left<right && !isValid(s.charAt(left))) left++;
            while(left<right && !isValid(s.charAt(right))) right--;

            if(left == right) return true;
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
