package Linked_List;

public class Medium_24_swapPairs {
    public ListNode swapPairs(ListNode head) {
        int count = 0;
        ListNode last = new ListNode(0);
        last.next = head;

        ListNode last1 = last;
        ListNode p = last.next;
        ListNode temp = new ListNode(0);
        temp.next = null;
        ListNode after = new ListNode(0);
        after.next = null;
        while(p != null){
            if(count == 0){
                count = 1;
                temp = p;
                p = p.next;
                if(p == null) return last1.next;
            }else{
                count = 0;
                //交换位置
                after = p.next;
                temp.next = after;
                p.next = temp;
                last.next = p;

                //滑动
                last = temp;
                p = after;
            }
        }
        return last1;
    }
}
