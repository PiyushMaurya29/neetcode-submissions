class Solution {
    public boolean isPossible(int i, int j, String s, Map<Character, Integer> tMap){
        Map<Character, Integer> sMap = new HashMap<>();
        for(int k=i ; k<=j ; k++){
            sMap.put(s.charAt(k), sMap.getOrDefault(s.charAt(k), 0)+1);
        }
        for(char c : tMap.keySet()){
            int tFreq = tMap.get(c);
            int sFreq = sMap.getOrDefault(c, 0);
            if(sFreq < tFreq) return false;
        }
        return true;
    }
    public boolean isPossible(Map<Character, Integer> map){
        for(var f : map.values()){
            if(f > 0) return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int n = s.length();
        int length = Integer.MAX_VALUE;
        int startIndex = -1;
        int i=0, j=0;
        while(j < n){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)-1);
            while(isPossible(map)){
                if(j-i+1 < length){
                    length = j-i+1;
                    startIndex = i;
                }
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
                i++;
            }
            j++;
        }
        
        return startIndex==-1 ? "" : s.substring(startIndex, startIndex+length);


        // Map<Character, Integer> tMap = new HashMap<>();
        // for(char c : t.toCharArray()){
        //     tMap.put(c, tMap.getOrDefault(c, 0)+1);
        // }
        // int n = s.length();
        // int startIndex = -1;
        // int length = Integer.MAX_VALUE;
        // for(int i=0 ; i<n ; i++){
        //     for(int j=i ; j<n ; j++){
        //         if(j-i+1<length && isPossible(i, j, s, tMap)){
        //             length = j-i+1;
        //             startIndex = i;
        //         }
        //     }
        // }
        // if(startIndex == -1) return "";
        // return s.substring(startIndex, startIndex+length);
    }
}
