class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (a,b) -> Integer.compare(a.length(), b.length()));
        StringBuilder result = new StringBuilder();
        for(int i=0 ; i<strs[0].length() ; i++){
            boolean check = true;
            for(int j=1 ; j<strs.length ; j++){
                if(strs[0].charAt(i) != strs[j].charAt(i)){
                    check = false;
                    break;
                }
            }
            if(check) result.append(strs[0].charAt(i));
            else break;
        }
        return result.toString();



        // int minLength = Integer.MAX_VALUE;
        // for(var str : strs){
        //     minLength = Math.min(minLength, str.length());
        // }
        // StringBuilder result = new StringBuilder();
        // for(int i=0 ; i<minLength ; i++){
        //     char c = strs[0].charAt(i);
        //     boolean check = true;
        //     for(int j=1 ; j<strs.length ; j++){
        //         if(strs[j].charAt(i) != c){
        //             check = false;
        //             break;
        //         }
        //     }
        //     if(!check) break;
        //     result.append(c);
        // }
        // return result.toString();
    }
}