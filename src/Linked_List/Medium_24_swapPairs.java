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

    public ListNode swapPairs1(ListNode head) {   //优化
        int count = 0;

        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode last = newhead;

        ListNode temp = new ListNode();
        ListNode after = new ListNode();
        while(head != null){
            if(count == 0){
                count = 1;
                temp = head;
                head = head.next;
            }else{
                count = 0;
                after = head.next;
                temp.next = after;
                head.next = temp;
                last.next = head;

                last = temp;
                head = after;
            }
        }
        return newhead.next;
    }
}
