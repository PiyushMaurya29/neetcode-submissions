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
    public void getInorder(TreeNode root, List<Integer> list){
        if(root == null) return;
        getInorder(root.left, list);
        list.add(root.val);
        getInorder(root.right, list);
    }
    int index = 0;
    public void solve(TreeNode root, List<Integer> list){
        if(root == null) return;
        solve(root.left, list);
        root.val = list.get(index++);
        solve(root.right, list);
    }

    TreeNode prev=null, first=null, second=null;
    public void solve(TreeNode root){
        if(root == null) return;
        solve(root.left);
        if(prev!=null && prev.val > root.val){
            if(first == null){
                first = prev;
            }
            second = root;
        }
        prev = root;
        solve(root.right);
    }
    public void recoverTree(TreeNode root) {
        solve(root);
        if(first!=null && second!=null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
        

        // List<Integer> inorderList = new ArrayList<>();
        // getInorder(root, inorderList);

        // Collections.sort(inorderList);

        // solve(root, inorderList);
        
    }
}