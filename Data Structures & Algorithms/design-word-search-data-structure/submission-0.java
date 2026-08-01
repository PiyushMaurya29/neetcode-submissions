class WordDictionary {
    Set<String> set;
    public WordDictionary() {
        set = new HashSet<>();
    }

    public void addWord(String word) {
        set.add(word);
    }

    public boolean search(String word) {
        for(var s : set){
            if(s.length() != word.length()){
                continue;
            }
            int index = 0;
            for(int i=0 ; i<s.length() ; i++){
                if(word.charAt(i)=='.' || word.charAt(i)==s.charAt(i)){
                    index++;
                }
            }
            if(index == s.length()) return true;
        }
        return false;
    }
}
