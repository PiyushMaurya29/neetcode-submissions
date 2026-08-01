class Solution {
    public int solve(int i, String word1, int j, String word2){
        if(i>=word1.length() && j>=word2.length()){
            return 0;
        }
        if(i >= word1.length()){
            return word2.length()-j;
        }
        if(j >= word2.length()){
            return word1.length()-i;
        }
        if(word1.charAt(i) == word2.charAt(j)){
            return solve(i+1, word1, j+1, word2);
        }
        else{
            int insert = 1 + solve(i, word1, j+1, word2);
            int delete = 1 + solve(i+1, word1, j, word2);
            int replace = 1 + solve(i+1, word1, j+1, word2);
            return Math.min(insert, Math.min(delete, replace));
        }
    }
    public int minDistance(String word1, String word2) {
        return solve(0, word1, 0, word2);
    }
}
