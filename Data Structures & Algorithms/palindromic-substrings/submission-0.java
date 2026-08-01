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
    public int countSubstrings(String s) {
        int n = s.length();
        int result = 0;
        for(int i=0 ; i<n ; i++){
            for(int j=i ; j<n ; j++){
                if(isPalindrome(i, j, s)){
                    result++;
                }
            }
        }
        return result;
    }
}
