class Solution {
    List<List<Integer>> result;
    public void solve(int[] nums, boolean[] visited, List<Integer> list){
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0 ; i<nums.length ; i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(nums[i]);
                solve(nums, visited, list);
                list.remove(list.size()-1); // backtrack
                visited[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        solve(nums, visited, new ArrayList<>());
        return result;
    }
}
