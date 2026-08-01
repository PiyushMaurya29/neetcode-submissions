class Solution {
    Set<List<Integer>> set = new HashSet<>();
    public void solve(int index, int[] nums, List<Integer> list, List<List<Integer>> result){
        if(index >= nums.length){
            if(set.contains(list)) return;
            set.add(new ArrayList<>(list));
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        solve(index+1, nums, list, result);
        list.remove(list.size()-1);
        solve(index+1, nums, list, result);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), result);
        return result;
    }
}
