class Solution {
    public boolean solve(int index, String s, int minJump, int maxJump, Boolean[] dp){
        if(index == s.length()-1){
            return true;
        }
        if(dp[index] != null){
            return dp[index];
        }
        for(int j=index+minJump ; j<=Math.min(index+maxJump, s.length()-1) ; j++){
            if(s.charAt(j)=='0'){
                if(solve(j, s, minJump, maxJump, dp)){
                    return dp[index] = true;
                }
            }
        }
        return dp[index] = false;
    }
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            if(curr == n-1) return true;
            for(int i=curr+minJump ; i<=Math.min(curr+maxJump, n-1) ; i++){
                if(s.charAt(i)=='0' && visited[i]==false){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        return false;



        // Boolean[] dp = new Boolean[s.length()+1];
        // return solve(0, s, minJump, maxJump, dp);
    }
}