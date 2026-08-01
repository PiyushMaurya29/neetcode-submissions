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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = reverseLL(slow.next);
        slow.next = null;
        ListNode first = head;


        while(second != null){
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;
            
            first = firstNext;
            second = secondNext;
        }


        // if(head==null || head.next==null || head.next.next==null){
        //     return;
        // }
        // ListNode slow = head;
        // ListNode fast = head;

        // while(fast.next.next!=null && fast.next.next.next!=null){
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }

        // ListNode nextList = slow.next;
        // slow.next = null;

        // ListNode firstList = head;
        // ListNode secondList = reverseLL(nextList);

        // ListNode temp = new ListNode(-1);
        // ListNode result = temp;

        // while(firstList != null){
        //     temp.next = firstList;
        //     temp = temp.next;

        //     firstList = firstList.next;

        //     temp.next = secondList;
        //     temp = temp.next;

        //     secondList = secondList.next;
        // }

        // // This is optional
        // // if(seconList != null){
        // //     temp.next = secondList;
        // // }

        // head = result.next;
    }
}
