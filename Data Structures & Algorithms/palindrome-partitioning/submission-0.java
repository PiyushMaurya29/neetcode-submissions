class Solution {
    List<List<String>> result;
    public boolean isPalindrome(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public void solve(int index, String s, List<String> list){
        if(index >= s.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=index ; i<s.length() ; i++){
            if(isPalindrome(index, i, s)){
                list.add(s.substring(index, i+1));
                solve(i+1, s, list);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        solve(0, s, new ArrayList<>());
        return result;
    }
}
