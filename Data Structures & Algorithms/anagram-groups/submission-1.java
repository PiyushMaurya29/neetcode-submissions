class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(var s : strs){
            int[] hash = new int[26];
            for(char c : s.toCharArray()){
                hash[c-'a']++;
            }
            String string = Arrays.toString(hash);
            if(!map.containsKey(string)){
                map.put(string, new ArrayList<>());
            }
            map.get(string).add(s);
        }
        List<List<String>> result = new ArrayList<>();
        for(var l : map.values()){
            result.add(l);
        }
        return result;


        // Map<String, List<String>> map = new HashMap<>();
        // for(var s : strs){
        //     char[] arr = s.toCharArray();
        //     Arrays.sort(arr);
        //     String string = new String(arr);
        //     if(!map.containsKey(string)){
        //         map.put(string, new ArrayList<>());
        //     }
        //     map.get(string).add(s);
        // }
        // List<List<String>> result = new ArrayList<>();
        // for(var l : map.values()){
        //     result.add(l);
        // }
        // return result;
    }
}
