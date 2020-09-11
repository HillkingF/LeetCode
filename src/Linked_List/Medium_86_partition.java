package Linked_List;

public class Medium_86_partition {
    public ListNode partition(ListNode head, int x) {
        ListNode ln = head;

        ListNode pre = new ListNode(0);
        pre.next = null;
        ListNode prelast = pre;

        ListNode after = new ListNode(0);
        after.next = null;
        ListNode afterlast = after;

        while(ln != null){
            ListNode newnode = new ListNode(ln.val);
            newnode.next = null;

            if(ln.val < x){
                prelast.next = newnode;
                prelast = prelast.next;
            }else{
                afterlast.next = newnode;
                afterlast = afterlast.next;
            }
            ln = ln.next;

        }
        prelast.next = after.next;
        return pre.next;

    }
}
