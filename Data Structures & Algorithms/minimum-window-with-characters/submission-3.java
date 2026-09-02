class Solution {
    public boolean isPossible(Map<Character, Integer> sMap, Map<Character, Integer> tMap){
        for(char c : tMap.keySet()){
            int freqS = sMap.getOrDefault(c, 0);
            int freqT = tMap.getOrDefault(c, 0);
            if(freqS < freqT){
                return false;
            }
        }
        return true;
    }
    public boolean isPossible(Map<Character, Integer> freqMap){
        for(int f : freqMap.values()){
            if(f > 0) return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char c : t.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
        }
        int startIndex = -1;
        int minLength = Integer.MAX_VALUE;

        int left=0, right=0;
        while(right < s.length()){
            char c = s.charAt(right);
            freqMap.put(c, freqMap.getOrDefault(c, 0)-1);
            while(isPossible(freqMap)){
                if(right-left+1 < minLength){
                    minLength = right-left+1;
                    startIndex = left;
                }
                char ch = s.charAt(left);
                freqMap.put(ch, freqMap.get(ch)+1);
                left++;
            }
            right++;
        }
        if(startIndex == -1) return "";
        return s.substring(startIndex, startIndex+minLength);





        // Map<Character, Integer> tMap = new HashMap<>();
        // for(int i=0 ; i<t.length() ; i++){
        //     char c = t.charAt(i);
        //     tMap.put(c, tMap.getOrDefault(c, 0)+1);
        // }

        // int n = s.length();
        // int startIndex = -1;
        // int minLength = Integer.MAX_VALUE;
        // for(int i=0 ; i<n ; i++){
        //     Map<Character, Integer> sMap = new HashMap<>();
        //     for(int j=i ; j<n ; j++){
        //         char c = s.charAt(j);
        //         sMap.put(c, sMap.getOrDefault(c, 0)+1);
        //         if(j-i+1<minLength && isPossible(sMap, tMap)){
        //             minLength = j-i+1;
        //             startIndex = i;
        //             break;
        //         }
        //     }
        // }
        // if(startIndex == -1) return "";
        // return s.substring(startIndex, startIndex+minLength);
    }
}
