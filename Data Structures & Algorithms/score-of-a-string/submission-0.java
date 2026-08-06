class Solution {
    public int scoreOfString(String s) {
        int result = 0;
        for(int i=1 ; i<s.length() ; i++){
            int diff = Math.abs(s.charAt(i)-s.charAt(i-1));
            result += diff;
        }
        return result;
    }
}