class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        for(var str : strs){
            minLength = Math.min(minLength, str.length());
        }

        StringBuilder result = new StringBuilder();
        for(int i=0 ; i<minLength ; i++){
            char c = strs[0].charAt(i);
            boolean check = true;
            for(int j=1 ; j<strs.length ; j++){
                if(strs[j].charAt(i) != c){
                    check = false;
                    break;
                }
            }
            if(!check) break;
            result.append(c);
        }
        return result.toString();
    }
}