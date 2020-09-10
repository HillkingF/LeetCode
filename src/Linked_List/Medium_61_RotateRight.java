package Linked_List;

public class Medium_61_RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        /**
         * 【思路】
         * 第一次循环：
         * 计算链表节点个数x，k%x=就是之后要从后面截取的个数
         * 第二次循环，类似于19题
         */

        //第一次循环
        if(head == null) return head;
        int x = 0;
        ListNode p = head;
        while(p != null){
            x++;
            p = p.next;
        }
        k = k%x;  // 后面截取的个数
        if(k == 0) return head;

        //第二次循环
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        p = head;
        ListNode last = newhead;
        x = 0;
        ListNode del = newhead;
        ListNode prep = newhead;

        while(p != null){
            x += 1;
            if(x < k){

            }else if(x == k){

            }else{
                del = del.next;
            }
            prep = prep.next;
            p = p.next;
        }
        ListNode after = del.next;
        del.next = null;
        prep.next = newhead.next;
        return after;


    }

    public ListNode rotateRight1(ListNode head, int k) {
        //对rotateRight的优化

        //第一次循环
        if(head == null) return head;
        int x = 0;
        ListNode p = head;
        while(p != null){
            x++;
            p = p.next;
        }
        k = k%x;
        if(k == 0) return head;

        p = new ListNode(0);
        p.next = head;
        head = p;
        p = head.next;
        x = 0;
        ListNode del = head;

        while(p != null){
            x += 1;
            if(x > k)del = del.next;
            if(p.next != null)p = p.next;
            else break;
        }
        ListNode after = del.next;
        del.next = null;
        p.next = head.next;
        return after;
    }

}
