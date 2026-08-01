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
    public int getGCD(int a, int b){
        if(a == 0) return b;
        return getGCD(b%a, a);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode prev = head;
        ListNode next = head.next;
        while(next != null){
            int gcd = getGCD(prev.val, next.val);
            ListNode temp = new ListNode(gcd);
            temp.next = next;
            prev.next = temp;

            prev = next;
            next = next.next;
        }
        return head;
    }
}