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
    public void solveDFS(TreeNode root, int level, TreeMap<Integer, List<Integer>> map){
        if(root == null) return;
        if(!map.containsKey(level)){
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(root.val);
        solveDFS(root.left, level+1, map);
        solveDFS(root.right, level+1, map);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=1 ; i<=levelSize ; i++){
                TreeNode curr = queue.poll();
                list.add(curr.val);
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            result.add(list);            
        }
        return result;


        // TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        // solveDFS(root, 0, map);
        // List<List<Integer>> result = new ArrayList<>();
        // for(var l : map.values()){
        //     result.add(l);
        // }
        // return result;

        
    }
}
