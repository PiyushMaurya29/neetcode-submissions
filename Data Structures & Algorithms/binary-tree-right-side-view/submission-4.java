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
    int maxLevel;
    public void solveDFS(TreeNode root, int level, Map<Integer, Integer> map){
        if(root == null) return;

        maxLevel = Math.max(maxLevel, level);
        map.put(level, root.val);

        solveDFS(root.left, level+1, map);
        solveDFS(root.right, level+1, map);
    }
    public List<Integer> rightSideView(TreeNode root) {
        // List<Integer> result = new ArrayList<>();
        // if(root == null) return result;
        // Deque<TreeNode> deque = new ArrayDeque<>();
        // deque.offerLast(root);
        // while(!deque.isEmpty()){
        //     result.add(deque.peekLast().val);

        //     int levelSize = deque.size();
        //     for(int i=1 ; i<=levelSize ; i++){
        //         TreeNode curr = deque.pollFirst();
        //         if(curr.left != null){
        //             deque.offerLast(curr.left);
        //         }
        //         if(curr.right != null){
        //             deque.offerLast(curr.right);
        //         }
        //     }
        // }
        // return result;


        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        maxLevel = 0;
        Map<Integer, Integer> map = new HashMap<>();
        solveDFS(root, 0, map);
        for(int i=0 ; i<=maxLevel ; i++){
            result.add(map.get(i));
        }
        return result;
    }
}
