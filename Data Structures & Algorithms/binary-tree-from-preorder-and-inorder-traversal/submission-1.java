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
    int n;
    int preorderIndex;
    
    public int getInorderIndex(int value, int[] inorder){
        for(int i=0 ; i<n ; i++){
            if(inorder[i] == value){
                return i;
            }
        }
        return -1;
    }
    public TreeNode solve(int inorderLeft, int inorderRight, int[] inorder, int[] preorder){
        if(inorderLeft > inorderRight) return null;

        int value = preorder[preorderIndex++];
        TreeNode root = new TreeNode(value);
        int inorderIndex = getInorderIndex(value, inorder);

        root.left = solve(inorderLeft, inorderIndex-1, inorder, preorder);
        root.right = solve(inorderIndex+1, inorderRight, inorder, preorder);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        n = preorder.length;
        preorderIndex = 0;
        return solve(0, n-1, inorder, preorder);
    }
}
