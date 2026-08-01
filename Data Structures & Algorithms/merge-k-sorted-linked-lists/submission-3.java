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
    public ListNode mergeLists(ListNode list1, ListNode list2){
        ListNode temp = new ListNode(-1);
        ListNode result = temp;
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            }
            else{
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }
        while(list1 != null){
            temp.next = list1;
            temp = list1;
            list1 = list1.next;
        }
        while(list2 != null){
            temp.next = list2;
            temp = list2;
            list2 = list2.next;
        }
        return result.next;
    }
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

        // ListNode result = null;
        // for(var l : lists){
        //     result = mergeLists(result, l);
        // }
        // return result;


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
