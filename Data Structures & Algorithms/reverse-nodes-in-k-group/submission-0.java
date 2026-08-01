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
    public ListNode reverseLL(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = new ListNode(-1);
        ListNode result = temp;
        while(head != null){
            ListNode prevNode = head;
            ListNode nextNode = head;
            for(int i=1 ; i<=k-1 ; i++){
                nextNode = nextNode.next;
                if(nextNode == null){
                    temp.next = prevNode;
                    return result.next;
                }
            }
            if(nextNode == null){
                temp.next = prevNode;
                return result.next;
            }
            ListNode nextIteration = nextNode.next;
            nextNode.next = null;
            temp.next = reverseLL(prevNode);
            while(temp.next != null){
                temp = temp.next;
            }
            head = nextIteration;
        }
        return result.next;
    }
}
