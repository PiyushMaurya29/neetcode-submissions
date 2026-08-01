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
    public boolean isSameTree(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null || root1.val != root2.val){
            return false;
        }
        boolean checkLeft = isSameTree(root1.left, root2.left);
        boolean checkRight = isSameTree(root1.right, root2.right);
        return checkLeft && checkRight;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(isSameTree(root, subRoot)) return true;
        boolean checkLeft = isSubtree(root.left, subRoot);
        boolean checkRight = isSubtree(root.right, subRoot);
        return checkLeft || checkRight;
    }
}
