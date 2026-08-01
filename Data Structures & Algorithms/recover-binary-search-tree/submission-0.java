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
    public void getInorder(TreeNode root, List<Integer> list){
        if(root == null) return;
        getInorder(root.left, list);
        list.add(root.val);
        getInorder(root.right, list);
    }
    int index = 0;
    public void solve(TreeNode root, List<Integer> list){
        if(root == null) return;
        solve(root.left, list);
        root.val = list.get(index++);
        solve(root.right, list);
    }
    public void recoverTree(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        getInorder(root, inorderList);

        Collections.sort(inorderList);

        solve(root, inorderList);
        
    }
}