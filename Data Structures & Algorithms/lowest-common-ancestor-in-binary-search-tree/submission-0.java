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
    public TreeNode solveDFS(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || root.val==p.val || root.val==q.val){
            return root;
        }
        TreeNode leftCheck = solveDFS(root.left, p, q);
        TreeNode rightCheck = solveDFS(root.right, p, q);
        if(leftCheck!=null && rightCheck!=null){
            return root;
        }
        if(leftCheck != null) return leftCheck;
        return rightCheck;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solveDFS(root, p, q);
    }
}
