class Solution {
    public boolean isPossible(int[] freq, int k){
        int totalFreq = 0;
        int maxFreq = 0;
        for(int f : freq){
            totalFreq += f;
            maxFreq = Math.max(maxFreq, f);
        }
        int remaining = totalFreq - maxFreq;
        return remaining <= k;
    }
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int result = 0;
        int i=0, j=0;
        while(j < n){
            freq[s.charAt(j)-'A']++;
            while(!isPossible(freq, k)){
                freq[s.charAt(i)-'A']--;
                i++;
            }
            result = Math.max(result, j-i+1);
            j++;
        }
        return result;
    }
}
