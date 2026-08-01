class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] lastIndex = new int[26];
        for(int i=0 ; i<n ; i++){
            lastIndex[s.charAt(i)-'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int prevIndex = 0;
        int maxIndex = 0;
        for(int i=0 ; i<n ; i++){
            maxIndex = Math.max(maxIndex, lastIndex[s.charAt(i)-'a']);
            if(maxIndex == i){
                result.add(i-prevIndex+1);
                prevIndex = i+1;
                maxIndex = i+1;
            }
        }
        return result;


        // int n = s.length();
        // int[] lastIndex = new int[26];
        // for(int i=0 ; i<n ; i++){
        //     lastIndex[s.charAt(i)-'a'] = i;
        // }

        // List<Integer> result = new ArrayList<>();
        // int prevIndex = 0;
        // int maxIndex = 0;
        // for(int i=0 ; i<n ; i++){
        //     maxIndex = Math.max(maxIndex, lastIndex[s.charAt(i)-'a']);
        //     if(maxIndex == i){
        //         result.add(i-prevIndex+1);
        //         prevIndex = i+1;
        //     }
        // }
        // return result;
    }
}
