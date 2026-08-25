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
    public void solveInorder(TreeNode node, List<Integer> list, int key){
        if(node == null) return;
        solveInorder(node.left, list, key);
        if(node.val != key){
            list.add(node.val);
        }
        solveInorder(node.right, list, key);
    }
    public TreeNode solveBST(int left, int right, List<Integer> list){
        if(left > right) return null;
        int mid = left + (right-left) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = solveBST(left, mid-1, list);
        root.right = solveBST(mid+1, right, list);
        return root;
    }


    public void solveInorder2(TreeNode node, List<TreeNode> list, int key){
        if(node == null) return;
        solveInorder2(node.left, list, key);
        if(node.val != key){
            list.add(node);
        }
        solveInorder2(node.right, list, key);
    }
    public TreeNode solveBST2(int left, int right, List<TreeNode> list){
        if(left > right) return null;
        int mid = left + (right-left) / 2;
        TreeNode root = list.get(mid);
        root.left = solveBST2(left, mid-1, list);
        root.right = solveBST2(mid+1, right, list);
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        List<TreeNode> inorderList = new ArrayList<>();
        solveInorder2(root, inorderList, key);
        return solveBST2(0, inorderList.size()-1, inorderList);


        // List<Integer> inorderList = new ArrayList<>();
        // solveInorder(root, inorderList, key);
        // return solveBST(0, inorderList.size()-1, inorderList);
    }
}