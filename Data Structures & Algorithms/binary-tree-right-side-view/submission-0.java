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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            result.add(deque.peekLast().val);

            int levelSize = deque.size();
            for(int i=1 ; i<=levelSize ; i++){
                TreeNode curr = deque.pollFirst();
                if(curr.left != null){
                    deque.offerLast(curr.left);
                }
                if(curr.right != null){
                    deque.offer(curr.right);
                }
            }
        }
        return result;
    }
}
