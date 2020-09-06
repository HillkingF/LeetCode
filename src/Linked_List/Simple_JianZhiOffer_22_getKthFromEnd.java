package Linked_List;

public class Simple_JianZhiOffer_22_getKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int listlen = 0;
        ListNode cur = head;
        while(cur!= null){
            listlen ++;  //从1开始
            cur = cur.next;
        }
        cur= head;
        listlen = listlen - k + 1;
        for(int i = 1; i < listlen; i++){
            cur = cur.next;
        }
        return cur;

    }
}
