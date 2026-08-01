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
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
        for(var l : lists){
            minHeap.offer(l);
        }
        ListNode temp = new ListNode(-1);
        ListNode result = temp;
        while(!minHeap.isEmpty()){
            ListNode curr = minHeap.poll();
            temp.next = curr;
            temp = curr;
            if(curr.next != null){
                minHeap.offer(curr.next);
            }
        }
        return result.next;


        // List<Integer> listNode = new ArrayList<>();
        // for(var l : lists){
        //     while(l != null){
        //         listNode.add(l.val);
        //         l = l.next;
        //     }
        // }
        // Collections.sort(listNode);
        // ListNode temp = new ListNode(-1);
        // ListNode result = temp;
        // for(int node : listNode){
        //     ListNode newNode = new ListNode(node);
        //     temp.next = newNode;
        //     temp = newNode;
        // }
        // return result.next;
    }
}
