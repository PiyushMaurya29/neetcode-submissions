class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int result = 0;
        for(int i=0 ; i<n ; i++){
            Set<Character> set = new HashSet<>();
            for(int j=i ; j<n ; j++){
                char c = s.charAt(j);
                if(set.contains(c)){
                    break;
                }
                result = Math.max(result, j-i+1);
                set.add(c);
            }
        }
        return result;
    }
}
