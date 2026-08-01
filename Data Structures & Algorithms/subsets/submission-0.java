class Solution {
    List<List<Integer>> result;
    public void solve(int index, int[] nums, List<Integer> list){
        if(index >= nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        solve(index+1, nums, list);
        list.remove(list.size()-1);
        solve(index+1, nums, list);
    }
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        solve(0, nums, new ArrayList<>());
        return result;
    }
}
