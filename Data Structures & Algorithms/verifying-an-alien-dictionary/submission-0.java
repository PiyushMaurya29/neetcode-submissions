class Solution {
    public int getIndex(char c, String order){
        for(int i=0 ; i<26 ; i++){
            if(c == order.charAt(i)){
                return i;
            }
        }
        return -1;
    }
    public boolean isValid(String prev, String curr, String order, int[] indexArray){
        for(int i=0 ; i<Math.min(prev.length(), curr.length()) ; i++){
            char c1 = prev.charAt(i);
            char c2 = curr.charAt(i);
            if(c1 != c2){
                int index1 = getIndex(c1, order);
                int index2 = getIndex(c2, order);
                if(index1 > index2) return false;
                return true;
            }
        }
        if(prev.length() > curr.length()) return false;
        return true;
    }
    public boolean isAlienSorted(String[] words, String order) {
        int[] indexArray = new int[26];
        for(int i=0 ; i<26 ; i++){
            indexArray[order.charAt(i)-'a'] = i;
        }
        for(int i=1 ; i<words.length ; i++){
            if(!isValid(words[i-1], words[i], order, indexArray)){
                return false;
            }
        }
        return true;
    }
}