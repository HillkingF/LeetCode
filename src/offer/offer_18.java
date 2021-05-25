package offer;

public class offer_18 {
    public ListNode deleteNode(ListNode head, int val) {  // Listnode 已经定义过了,就是下面的形式
        ListNode start = head;
        ListNode del = head;
        if(start.val != val){
            while(start.next != null){
                if(start.next.val == val){
                    del = start.next;
                    start.next = del.next;
                    del.next = null;
                    return head;
                }else{
                    start = start.next;
                }
            }
            return head;

        }else{
            return head.next;
        }
    }
}



//  Definition for singly-linked list.
//class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
// }


