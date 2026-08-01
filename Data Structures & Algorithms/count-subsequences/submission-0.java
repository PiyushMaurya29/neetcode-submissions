class Solution {
    int result;
    public void solve(int index, StringBuilder sb, String s, String t){
        if(index >= s.length()){
            if(sb.toString().equals(t)){
                result++;
            }
            return;
        }
        sb.append(s.charAt(index));
        solve(index+1, sb, s, t);
        sb.deleteCharAt(sb.length()-1);
        solve(index+1, sb, s, t);
    }
    public int numDistinct(String s, String t) {
        result = 0;
        solve(0, new StringBuilder(), s, t);
        return result;
    }
}
