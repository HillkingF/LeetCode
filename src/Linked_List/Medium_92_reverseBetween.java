package Linked_List;

public class Medium_92_reverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) return head;
        ListNode ln = new ListNode(0);
        ln.next = head;
        head = ln;
        ln = ln.next;

        ListNode prelast = head;

        ListNode kidlist = new ListNode();
        ListNode kidlast = new ListNode();

        int count = 0;
        while(ln != null){
            count += 1;
            if(count < m) prelast = prelast.next;
            else if(count == m){
                kidlist.val = ln.val;
                kidlist.next = null;
                kidlast = kidlist;
            }else if(count > m && count <= n){
                ListNode temp = new ListNode(ln.val);
                temp.next = kidlist;
                kidlist = temp;
                if(count == n){ //拼接
                    kidlast.next = ln.next;
                    prelast.next = kidlist;
                    break;
                }
            }
            ln = ln.next;
        }
        return head.next;

    }
}
