class Node{
    Node[] children = new Node[26];
    boolean isEnd = false;
}
class WordDictionary {

    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void insertIntoTrie(String word){
        Node node = root;
        for(char c : word.toCharArray()){
            int index = c-'a';
            if(node.children[index] == null){
                node.children[index] = new Node();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public void addWord(String word) {
        insertIntoTrie(word);
    }

    public boolean searchIntoTrieDFS(int index, String word, Node node){
        if(node == null) return false;
        if(index == word.length()){
            return node.isEnd;
        }

        char c = word.charAt(index);

        if(c == '.'){
            for(int i=0 ; i<26 ; i++){
                if(searchIntoTrieDFS(index+1, word, node.children[i])){
                    return true;
                }
            }
        }
        else{
            int currIndex = c-'a';
            if(searchIntoTrieDFS(index+1, word, node.children[currIndex])){
                return true;
            }
        }
        return false;        
    }
    public boolean search(String word) {
        Node node = root;
        return searchIntoTrieDFS(0, word, node);
    }
}




// class WordDictionary {
//     List<String> list;
//     public WordDictionary() {
//         list = new ArrayList<>();
//     }

//     public void addWord(String word) {
//         list.add(word);
//     }

//     public boolean isEqual(String currWord, String targetWord){
//         if(currWord.length() != targetWord.length()){
//             return false;
//         }
//         for(int i=0 ; i<currWord.length() ; i++){
//             if(targetWord.charAt(i)!='.' && currWord.charAt(i)!=targetWord.charAt(i)){
//                 return false;
//             }
//         }
//         return true;
//     }
//     public boolean search(String word) {
//         for(var w : list){
//             if(isEqual(w, word)){
//                 return true;
//             }
//         }
//         return false;
//     }
// }
