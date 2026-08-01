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
        // if(a == 0) return b;
        // return getGCD(b%a, a);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode curr = head;
        while(curr.next != null){
            int gcd = getGCD(curr.val, curr.next.val);
            ListNode temp = new ListNode(gcd);


            temp.next = curr.next;
            curr.next = temp;

            curr = curr.next.next;
            // curr = temp.next;
        }
        return head;


        // ListNode prev = head;
        // ListNode next = head.next;
        // while(next != null){
        //     int gcd = getGCD(prev.val, next.val);
        //     ListNode temp = new ListNode(gcd);
        //     temp.next = next;
        //     prev.next = temp;

        //     prev = next;
        //     next = next.next;
        // }
        // return head;
    }
}