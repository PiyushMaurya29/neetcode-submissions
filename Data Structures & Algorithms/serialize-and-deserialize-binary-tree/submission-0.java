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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr == null){
                sb.append("#,");
                continue;
            }
            sb.append(curr.val+",");
            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] str = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for(int i=1 ; i<str.length ; i++){
            TreeNode curr = queue.poll();
            if(!str[i].equals("#")){
                TreeNode leftNode = new TreeNode(Integer.parseInt(str[i]));
                curr.left = leftNode;
                queue.offer(leftNode);
            }
            if(!str[++i].equals("#")){
                TreeNode rightNode = new TreeNode(Integer.parseInt(str[i]));
                curr.right = rightNode;
                queue.offer(rightNode);
            }
        }
        return root;
    }
}
