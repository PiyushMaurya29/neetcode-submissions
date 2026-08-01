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
    public int solve(int max, TreeNode root){
        if(root == null) return 0;
        if(root.val >= max){
            return 1 + solve(root.val, root.left) + solve(root.val, root.right);
        }
        else{
            return solve(max, root.left) + solve(max, root.right);
        }
    }
    public int goodNodes(TreeNode root) {
        return solve(Integer.MIN_VALUE, root);
    }
}
