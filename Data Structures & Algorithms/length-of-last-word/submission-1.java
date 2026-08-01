class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        // int length = 0;
        int n = s.length();
        if(n == 1) return 1;
        int i = n-1;
        while(s.charAt(i) != ' '){
            i--;
        }
        return n-i-1;
    }
}