class Solution {
    int m, n;
    public boolean solve(int i, String s, int j, String p){
        if(i==-1 && j==-1) return true;
        if(j==-1) return false;
        if(i==-1){
            if(p.charAt(j)=='*'){
                return solve(i, s, j-2, p);
            }
            return false;
        }
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'){
            return solve(i-1, s, j-1, p);
        }
        else if(p.charAt(j)=='*'){
            boolean skip = solve(i, s, j-2, p);
            boolean take = false;
            if(s.charAt(i)==p.charAt(j-1) || p.charAt(j-1)=='.'){
                take = solve(i-1, s, j, p);
            }
            return skip || take;
        }
        else return false;
    }
    public boolean isMatch(String s, String p) {
        m = s.length();
        n = p.length();
        return solve(m-1, s, n-1, p);
    }
}
