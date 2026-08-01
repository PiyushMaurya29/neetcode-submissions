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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> list = new ArrayList<>();
        while(list1 != null){
            list.add(list1.val);
            list1 = list1.next;
        }
        while(list2 != null){
            list.add(list2.val);
            list2 = list2.next;
        }

        Collections.sort(list);
        ListNode temp = new ListNode(-1);
        ListNode result = temp;
        for(int ele : list){
            ListNode t = new ListNode(ele);
            temp.next = t;
            temp = t;
        }
        return result.next;
    }
}