class Solution {
    public boolean isValid(char ch){
        return (ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>='0' && ch<='9');
    }
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        int left=0, right=sb.length()-1;
        while(left < right){
            if(sb.charAt(left) != sb.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
        

        // s = s.toLowerCase();
        // int n = s.length();
        // int left=0, right=n-1;
        // while(left < right){
        //     while(left<right && !isValid(s.charAt(left))) left++;
        //     while(left<right && !isValid(s.charAt(right))) right--;

        //     if(left == right) return true;
        //     if(s.charAt(left) != s.charAt(right)){
        //         return false;
        //     }
        //     left++;
        //     right--;
        // }
        // return true;
    }
}
