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
    int postIndex;
    Map<Integer, Integer> inorderMap;
    public TreeNode solve(int leftInorderIndex, int rightInorderIndex, int[] inorder, int[] postorder){
        if(leftInorderIndex > rightInorderIndex){
            return null;
        }
        int value = postorder[postIndex--];
        int inorderIndex = inorderMap.get(value);

        TreeNode root = new TreeNode(value);
        root.right = solve(inorderIndex+1, rightInorderIndex, inorder, postorder);
        root.left = solve(leftInorderIndex, inorderIndex-1, inorder, postorder);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        n = inorder.length;
        postIndex = n-1;
        inorderMap = new HashMap<>();
        for(int i=0 ; i<n ; i++){
            inorderMap.put(inorder[i], i);
        }
        return solve(0, n-1, inorder, postorder);
    }
}