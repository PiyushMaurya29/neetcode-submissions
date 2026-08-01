class Solution {
    List<List<Integer>> result;
    public void solve(int index, int[] nums, List<Integer> list, int target){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(index >= nums.length) return;
        if(target >= nums[index]){
            list.add(nums[index]);
            solve(index, nums, list, target-nums[index]);
            list.remove(list.size()-1);
        }
        solve(index+1, nums, list, target);
    }
    public void solve2(int index, int[] nums, List<Integer> list, int target){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=index ; i<nums.length ; i++){
            if(nums[i] > target) break;
            list.add(nums[i]);
            solve2(i, nums, list, target-nums[i]);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        solve2(0, nums, new ArrayList<>(), target);
        return result;

        // result = new ArrayList<>();
        // solve(0, nums, new ArrayList<>(), target);
        // return result;
    }
}
