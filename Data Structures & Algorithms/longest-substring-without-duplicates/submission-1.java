class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int result = 0;
        Set<Character> set = new HashSet<>();
        int i=0, j=0;

        while(j < n){
            char c = s.charAt(j);
            while(set.contains(c)){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(c);
            result = Math.max(result, j-i+1);
            j++;
        }
        return result;

        // int n = s.length();
        // int result = 0;
        // for(int i=0 ; i<n ; i++){
        //     Set<Character> set = new HashSet<>();
        //     for(int j=i ; j<n ; j++){
        //         char c = s.charAt(j);
        //         if(set.contains(c)){
        //             break;
        //         }
        //         result = Math.max(result, j-i+1);
        //         set.add(c);
        //     }
        // }
        // return result;
    }
}
