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
    public boolean isSorted(List<Integer> list){
        for(int i=1 ; i<list.size() ; i++){
            if(list.get(i) <= list.get(i-1)){
                return false;
            }
        }
        return true;
    }
    public void getInorder(TreeNode root, List<Integer> list){
        if(root == null) return;
        getInorder(root.left, list);
        list.add(root.val);
        getInorder(root.right, list);
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        getInorder(root, inorderList);
        return isSorted(inorderList);
    }
}
