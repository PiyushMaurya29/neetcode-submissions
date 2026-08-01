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
    public boolean solve(TreeNode root, int currSum, int targetSum){
        if(root==null) return false;
        if(root.left==null && root.right==null){
            return currSum+root.val == targetSum;
        }
        boolean checkLeft = solve(root.left, currSum+root.val, targetSum);
        boolean checkRight = solve(root.right, currSum+root.val, targetSum);
        return checkLeft || checkRight;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root, 0, targetSum);
    }
}