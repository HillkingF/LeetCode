package Linked_List;

public class Simple_203_removeElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode p = head, q = head;
        int sign = 0;
        while (q != null) {
            q = q.next;
            if(p.val == val)sign = 1;
            if(q != null){
                if(q.val != val){
                    p.next = q;
                    p = q;
                }
            }else p.next = q;
        }
        if(sign == 1)head = head.next;
        return head;
    }
}
