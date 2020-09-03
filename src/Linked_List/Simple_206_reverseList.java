package Linked_List;

import java.util.List;

public class Simple_206_reverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode l =  new ListNode();
        ListNode temp = new ListNode();
        ListNode lh = head;

        // 初始化
        temp.val = lh.val;
        temp.next = null;
        l.val = 0;
        l.next = temp;
        while(lh.next != null){
            lh = lh.next;
            temp.next = null;
            temp.val = lh.val;
            temp.next = l.next;
            l.next = null;
            l.next = temp;
        }
        return l;


    }
}
