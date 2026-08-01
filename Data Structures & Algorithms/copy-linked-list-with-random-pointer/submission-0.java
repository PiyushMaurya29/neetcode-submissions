/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>(); // OldNode to NewNode mapping
        Node temp = head;
        while(temp != null){
            // map.put(head, new Node(head.val));
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            temp = temp.next;
        }
        for(var node : map.keySet()){
            Node curr = map.get(node);
            curr.next = map.get(node.next);
            curr.random = map.get(node.random);
        }
        return map.get(head);
    }
}
