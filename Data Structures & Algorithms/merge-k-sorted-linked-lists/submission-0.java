/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> listNode = new ArrayList<>();
        for(var l : lists){
            while(l != null){
                listNode.add(l.val);
                l = l.next;
            }
        }
        Collections.sort(listNode);
        ListNode temp = new ListNode(-1);
        ListNode result = temp;
        for(int node : listNode){
            ListNode newNode = new ListNode(node);
            temp.next = newNode;
            temp = newNode;
        }
        return result.next;
    }
}
