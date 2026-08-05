class Solution {
    public boolean solve(int i, String s, int j, String t){
        if(i == s.length()) return true;
        if(j == t.length()) return false;

        if(s.charAt(i) == t.charAt(j)){
            return solve(i+1, s, j+1, t);
        }
        else{
            return solve(i, s, j+1, t);
        }
    }
    public boolean isSubsequence(String s, String t) {
        if(t.length() < s.length()) return false;

        return solve(0, s, 0, t);
    }
}