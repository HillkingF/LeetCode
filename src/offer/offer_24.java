package offer;

public class offer_24 {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode newhead = new ListNode(0);
        //ListNode next = newhead;
        ListNode out = head;
        while(head != null){
            // 先断开原来链表中的节点
            out = head;
            head = head.next;
            out.next = null;

            // 将out节点插入新的链表中
            out.next = newhead.next;
            newhead.next = out;
        }
        return newhead.next;

    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */