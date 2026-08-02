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
        StringBuilder result = new StringBuilder();

        // Queue<TreeNode> queue = new LinkedList<>();
        // Deque<TreeNode> queue = new ArrayDeque<>();  // ArrayDeque doesn't allow null values
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr == null){
                result.append("N").append(" ");
                continue;
            }
            result.append(curr.val).append(" ");

            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;

        String[] arr = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        // Queue<TreeNode> queue = new LinkedList<>();
        // Deque<TreeNode> queue = new ArrayDeque<>(); // ArrayDeque doesn't allow null values
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for(int i=1 ; i<arr.length ; i++){
            TreeNode curr = queue.poll();
            if(!arr[i].equals("N")){
                TreeNode leftNode = new TreeNode(Integer.parseInt(arr[i]));
                curr.left = leftNode;
                queue.offer(leftNode);
            }
            if(!arr[++i].equals("N")){
                TreeNode rightNode = new TreeNode(Integer.parseInt(arr[i]));
                curr.right = rightNode;
                queue.offer(rightNode);
            }
        }
        return root;
    }
}
