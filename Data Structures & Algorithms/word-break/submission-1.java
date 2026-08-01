class Solution {
    public boolean solve(int index, String s, Set<String> set, Boolean[] dp){
        if(index >= s.length()){
            return dp[index] = true;
        }
        if(dp[index] != null){
            return dp[index];
        }
        for(int i=index+1 ; i<=s.length() ; i++){
            String str = s.substring(index, i);
            if(set.contains(str)){
                if(solve(i, s, set, dp)){
                    return dp[index] = true;
                }
            }
        }
        return dp[index] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(var w : wordDict){
            set.add(w);
        }
        Boolean[] dp = new Boolean[s.length()+1];
        return solve(0, s, set, dp);
    }
}
