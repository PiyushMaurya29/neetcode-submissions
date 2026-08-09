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
    public void reverseLL(int left, int right, List<Integer> list){
        while(left < right){
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null || left==right){
            return head;
        }
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }

        reverseLL(left-1, right-1, list);
        temp = head;

        for(int i=0 ; i<list.size() ; i++){
            temp.val = list.get(i);
            temp = temp.next;
        }
        return head;
    }
}