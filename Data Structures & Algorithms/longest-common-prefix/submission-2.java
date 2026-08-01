class Node{
    Node[] children = new Node[26];
    int countPrefix = 0;
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        Node root = new Node();
        for(var str : strs){
            Node node = root;
            for(char c : str.toCharArray()){
                int index = c-'a';
                if(node.children[index] == null){
                    node.children[index] = new Node();
                }
                node = node.children[index];
                node.countPrefix++;
            }
        }

        StringBuilder result = new StringBuilder();
        Node node = root;
        for(char c : strs[0].toCharArray()){
            int index = c-'a';
            if(node.children[index] == null){
                break;
            }
            node = node.children[index];
            if(node.countPrefix < n) break;
            result.append(c);
        }
        return result.toString();


        // Arrays.sort(strs, (a,b) -> Integer.compare(a.length(), b.length()));
        // StringBuilder result = new StringBuilder();
        // for(int i=0 ; i<strs[0].length() ; i++){
        //     boolean check = true;
        //     for(int j=1 ; j<strs.length ; j++){
        //         if(strs[0].charAt(i) != strs[j].charAt(i)){
        //             check = false;
        //             break;
        //         }
        //     }
        //     if(check) result.append(strs[0].charAt(i));
        //     else break;
        // }
        // return result.toString();



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