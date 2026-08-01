class Solution {
    public boolean check(int start, String haystack, String needle){
        for(int i=0 ; i<needle.length() ; i++){
            if(needle.charAt(i) != haystack.charAt(start+i)){
                return false;
            }
        }
        return true;
    }
    public int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle);


        int m = haystack.length();
        int n = needle.length();
        if(m < n) return -1;
        for(int i=0 ; i<=m-n ; i++){
            if(check(i, haystack, needle)){
                return i;
            }
        }
        return -1;
    }
}