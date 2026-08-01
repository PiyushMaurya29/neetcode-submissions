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
    public int getCount(int i, int j, String s){
        int count = 0;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            count++;
            i--;
            j++;
        }
        return count;
    }
    public int countSubstrings(String s) {
        int n = s.length();
        int result = 0;
        for(int i=0 ; i<n ; i++){
            result += getCount(i, i, s); // For odd Center
            result += getCount(i-1, i, s); // For even Center
        }
        return result;


        // int n = s.length();
        // int result = 0;
        // for(int i=0 ; i<n ; i++){
        //     for(int j=i ; j<n ; j++){
        //         if(isPalindrome(i, j, s)){
        //             result++;
        //         }
        //     }
        // }
        // return result;
    }
}
