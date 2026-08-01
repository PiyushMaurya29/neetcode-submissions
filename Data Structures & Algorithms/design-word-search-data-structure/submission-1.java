class WordDictionary {
    List<String> list;
    public WordDictionary() {
        list = new ArrayList<>();
    }

    public void addWord(String word) {
        list.add(word);
    }

    public boolean isEqual(String currWord, String targetWord){
        if(currWord.length() != targetWord.length()){
            return false;
        }
        for(int i=0 ; i<currWord.length() ; i++){
            if(targetWord.charAt(i)!='.' && currWord.charAt(i)!=targetWord.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public boolean search(String word) {
        for(var w : list){
            if(isEqual(w, word)){
                return true;
            }
        }
        return false;
    }
}
