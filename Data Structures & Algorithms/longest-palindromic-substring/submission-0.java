class Solution {
    public boolean isPalindrome(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        
        int startIndex = -1;
        int maxLength = 0;
        for(int i=0 ; i<n ; i++){
            for(int j=i ; j<n ; j++){
                if(j-i+1>maxLength && isPalindrome(i, j, s)){
                    startIndex = i;
                    maxLength = j-i+1;
                }
            }
        }

        return s.substring(startIndex, startIndex+maxLength);
    }
}
