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
    public int solve(TreeNode root){
        if(root == null) return 0;
        int leftHeight = solve(root.left);
        int rightHeight = solve(root.right);
        if(Math.abs(leftHeight-rightHeight) > 1){
            return -1;
        } 
        if(leftHeight==-1 || rightHeight==-1){
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
    public boolean isBalanced(TreeNode root) {
        int result = solve(root);
        return result == -1 ? false : true;
    }
}
