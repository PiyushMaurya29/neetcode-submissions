/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public void solve(TreeNode root, List<Integer> inorderList){
        if(root == null) return;
        solve(root.left, inorderList);
        inorderList.add(root.val);
        solve(root.right, inorderList);
    }
    public void solve(TreeNode root, int[] pair){
        if(root == null) return;
        solve(root.left, pair);
        pair[0]--;
        if(pair[0] == 0){
            pair[1] = root.val;
        }
        solve(root.right, pair);
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] pair = {k, -1};
        solve(root, pair);
        return pair[1];

        // List<Integer> inorderList = new ArrayList<>();
        // solve(root, inorderList);
        // return inorderList.get(k-1);
    }
}
