package Linked_List;

public class Simple_141_HasCycle {
    public boolean hasCycle(ListNode head) {
        int count = 0;
        int loc = -1;
        ListNode r = head;
        ListNode p = r;
        while(r != null){
            while(p.next != null){
                if(p.next == r){ //说明出现环了
                    return true;
                }else{
                    p = p.next;
                }
            }
            r = r.next;
            p = r;
            count += 1;
        }
        return false;

    }
}
