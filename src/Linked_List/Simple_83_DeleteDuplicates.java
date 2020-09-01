package Linked_List;

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}
public class Simple_83_DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        //需要优化的地方是：清除无用的指针
        ListNode p = head;
        while(p != null && p.next != null){
            System.out.println(p.val);
            if(p.val == p.next.val){
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }
        return head;


    }
}
