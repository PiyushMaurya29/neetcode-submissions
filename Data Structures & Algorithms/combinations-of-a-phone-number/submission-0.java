class Solution {
    public void solve(String digits, int index, StringBuilder curr, Map<Character, String> map, List<String> result){
        if(index == digits.length()){
            result.add(curr.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = map.get(digit);
        for(char c : letters.toCharArray()){
            curr.append(c);
            solve(digits, index+1, curr, map, result);
            curr.deleteCharAt(curr.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        solve(digits, 0, new StringBuilder(), map, result);
        return result;
    }
}
