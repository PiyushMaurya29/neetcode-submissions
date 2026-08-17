class Solution {
    public boolean solve(int left, int right, String s, int count, Boolean[][][] dp){
        if(left >= right) return true;

        if(dp[left][right][count] != null){
            return dp[left][right][count];
        }

        if(s.charAt(left) == s.charAt(right)){
            return solve(left+1, right-1, s, count, dp);
        }
        else{
            if(count == 0){
                boolean ans1 = solve(left+1, right, s, count+1, dp);
                boolean ans2 = solve(left, right-1, s, count+1, dp);
                return dp[left][right][count] = ans1 || ans2;
            }
            else return dp[left][right][count] = false;
        }
    }
    public boolean isPalindrome(int left, int right, String s){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int n = s.length();
        int left=0, right=n-1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return isPalindrome(left+1, right, s) || isPalindrome(left, right-1, s);
            }
            left++;
            right--;
        }
        return true;


        // int n = s.length();
        // Boolean[][][] dp = new Boolean[n+1][n+1][2];
        // return solve(0, n-1, s, 0, dp);
    }
}