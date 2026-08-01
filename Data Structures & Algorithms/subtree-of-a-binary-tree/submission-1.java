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
    public boolean solve(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null || root1.val != root2.val) return false;
        boolean checkLeft = solve(root1.left, root2.left);
        boolean checkRight = solve(root1.right, root2.right);
        return checkLeft && checkRight;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(solve(curr, subRoot)){
                return true;
            }
            if(curr.left != null){
                queue.offer(curr.left);
            }
            if(curr.right != null){
                queue.offer(curr.right);
            }
        }
        return false;


        // if(root == null) return false;
        // if(isSameTree(root, subRoot)) return true;
        // boolean checkLeft = isSubtree(root.left, subRoot);
        // boolean checkRight = isSubtree(root.right, subRoot);
        // return checkLeft || checkRight;
    }
}
