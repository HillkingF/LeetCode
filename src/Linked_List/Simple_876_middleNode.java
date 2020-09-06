package Linked_List;

public class Simple_876_middleNode {
    public ListNode middleNode(ListNode head) {
        int listlen = 0;
        ListNode cur = head;
        while(cur != null){
            listlen ++;
            cur = cur.next;
        }
        cur = head;
        listlen = listlen/2;
        int count = 0;
        while(count < listlen){
            cur = cur.next;
            count ++;
        }
        return cur;



    }
}
