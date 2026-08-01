class Solution {
    public void solve(int index, StringBuilder sb, String s, Set<String> set, List<String> result){
        if(index >= s.length()){
            result.add(sb.toString().trim());
            return;
        }
        for(int i=index+1 ; i<=s.length() ; i++){
            String str = s.substring(index, i);
            if(set.contains(str)){
                int length = sb.length();
                // sb.append(str).append(" ");
                sb.append(str+" ");
                solve(i, sb, s, set, result);
                sb.setLength(length);
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(var w : wordDict){
            set.add(w);
        }
        List<String> result = new ArrayList<>();
        solve(0, new StringBuilder(), s, set, result);
        return result;
    }
}