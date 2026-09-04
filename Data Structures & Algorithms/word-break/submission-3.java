class Solution {
    public boolean solve(int index, String s, Set<String> wordSet, Boolean[] dp){
        if(index >= s.length()){
            return true;
        }
        if(dp[index] != null){
            return dp[index];
        }
        for(int i=index ; i<s.length() ; i++){
            String str = s.substring(index, i+1);
            if(wordSet.contains(str) && solve(i+1, s, wordSet, dp)){
                return dp[index] = true;
            }
        }
        return dp[index] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for(var w : wordDict){
            wordSet.add(w);
        }
        Boolean[] dp = new Boolean[s.length()+1];
        return solve(0, s, wordSet, dp);
    }
}
