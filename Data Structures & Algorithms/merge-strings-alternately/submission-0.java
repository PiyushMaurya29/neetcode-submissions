class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        StringBuilder result = new StringBuilder();

        int i=0, j=0;
        boolean takeFirst = true;
        while(i<m && j<n){
            if(takeFirst){
                result.append(word1.charAt(i++));
            }
            else{
                result.append(word2.charAt(j++));
            }
            takeFirst = !takeFirst;
        }
        while(i < m){
            result.append(word1.charAt(i++));
        }
        while(j < n){
            result.append(word2.charAt(j++));
        }
        return result.toString();
    }
}