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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null || left==right){
            return head;
        }
        if(left == 1){
            // 2-parts [startList, lastList]
            ListNode firstTail = head;
            for(int i=1 ; i<=right-1 ; i++){
                firstTail = firstTail.next;
            }
            ListNode secondHead = firstTail.next;

            ListNode reverseTail = head;
            firstTail.next = null;
            ListNode reverseHead = reverseLL(head);
            reverseTail.next = secondHead;
            return reverseHead;
        }
        // if(left == 1){
        //     // 2-parts [startList, lastList]
        //     ListNode firstTail = head;
        //     for(int i=1 ; i<=right-1 ; i++){
        //         firstTail = firstTail.next;
        //     }
        //     ListNode lastHead = firstTail.next;
        //     firstTail.next = null;

        //     ListNode reverseFirst = reverseLL(head);
        //     ListNode result = reverseFirst;
        //     while(reverseFirst.next != null){
        //         reverseFirst = reverseFirst.next;
        //     }
        //     reverseFirst.next = lastHead;
        //     return result;
        // }


        // 3-parts [startList, middleList, lastList]

        ListNode firstTail = head;
        for(int i=1 ; i<left-1 ; i++){
            firstTail = firstTail.next;
        }
        ListNode middleTail = head;
        for(int i=1 ; i<=right-1 ; i++){
            middleTail = middleTail.next;
        }

        ListNode lastHead = middleTail.next;
        middleTail.next = null;
        ListNode middleHead = firstTail.next;
        firstTail.next = null;

        ListNode reverseMiddle = reverseLL(middleHead);
        firstTail.next = reverseMiddle;

        // while(reverseMiddle.next != null){
        //     reverseMiddle = reverseMiddle.next;
        // }
        // reverseMiddle.next = lastHead;

        middleHead.next = lastHead;

        return head;
        


        // if(head==null || head.next==null || left==right){
        //     return head;
        // }
        // List<Integer> list = new ArrayList<>();
        // ListNode temp = head;
        // while(temp != null){
        //     list.add(temp.val);
        //     temp = temp.next;
        // }

        // reverseLL(left-1, right-1, list);
        // temp = head;

        // for(int i=0 ; i<list.size() ; i++){
        //     temp.val = list.get(i);
        //     temp = temp.next;
        // }
        // return head;
    }
}