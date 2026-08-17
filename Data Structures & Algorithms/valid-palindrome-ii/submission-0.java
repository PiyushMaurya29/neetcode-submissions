class Solution {
    public boolean solve(int left, int right, String s, int count){
        if(left >= right) return true;
        if(s.charAt(left) == s.charAt(right)){
            return solve(left+1, right-1, s, count);
        }
        else{
            if(count == 0){
                boolean ans1 = solve(left+1, right, s, count+1);
                boolean ans2 = solve(left, right-1, s, count+1);
                return ans1 || ans2;
            }
            else return false;
        }
    }
    public boolean validPalindrome(String s) {
        return solve(0, s.length()-1, s, 0);
    }
}