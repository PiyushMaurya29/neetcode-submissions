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
    int preIndex;
    Map<Integer, Integer> inorderMap;
    public TreeNode solve(int preLeft, int preRight, int[] preorder){
        if(preLeft > preRight) return null;
        int value = preorder[preIndex++];

        TreeNode root = new TreeNode(value);

        int inorderIndex = inorderMap.get(value);
        root.left = solve(preLeft, inorderIndex-1, preorder);
        root.right = solve(inorderIndex+1, preRight, preorder);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        preIndex = 0;
        inorderMap = new HashMap<>();
        for(int i=0 ; i<n ; i++){
            inorderMap.put(inorder[i], i);
        }
        return solve(0, n-1, preorder);
    }
}
