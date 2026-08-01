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
    public int solveDFS(TreeNode root){
        if(root == null) return 0;
        int leftHeight = solveDFS(root.left);
        int rightHeight = solveDFS(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    public int solveBFS(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            level++;
            int levelSize = queue.size();
            while(levelSize-- > 0){
                TreeNode curr = queue.poll();
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
        }
        return level;
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        // return solveDFS(root);

        return solveBFS(root);
    }
}
