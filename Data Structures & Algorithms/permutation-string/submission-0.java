class Solution {
    public boolean isPossible(int[] freq){
        for(int f : freq){
            if(f > 0) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        for(char c : s1.toCharArray()){
            freq[c-'a']++;
        }
        int i=0, j=0;
        while(j < s2.length()){
            freq[s2.charAt(j)-'a']--;
            while(j-i+1 > s1.length()){
                freq[s2.charAt(i)-'a']++;
                i++;
            }
            if(j-i+1 == s1.length()){
                if(isPossible(freq)){
                    return true;
                }
            }
            j++;
        }
        return false;
    }
}
