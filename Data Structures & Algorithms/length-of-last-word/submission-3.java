class Solution {
    public int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        int n = str.length;
        return str[n-1].length();
        

        // s = s.trim();
        // int n = s.length();
        // if(n == 1) return 1;
        // int i = n-1;
        // while(s.charAt(i) != ' '){
        //     i--;
        // }
        // return n-i-1;
    }
}