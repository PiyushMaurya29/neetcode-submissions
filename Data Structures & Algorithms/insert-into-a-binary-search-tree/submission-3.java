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
    public void solve(TreeNode root, TreeNode node){
        if(root == null) return;
        if(root.val>node.val && root.left==null){
            root.left = node;
            return;
        }
        if(root.val<node.val && root.right==null){
            root.right = node;
            return;
        }
        if(root.val > node.val){
            solve(root.left, node);
        }
        else solve(root.right, node);
    }
    public TreeNode solve(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }
        if(root.val > val){
            root.left = solve(root.left, val);
        }
        else{
            root.right = solve(root.right, val);
        }
        return root;
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return solve(root, val);

        // TreeNode node = new TreeNode(val);
        // if(root == null) return node;
        // solve(root, node);
        // return root;
    }
}