package Linked_List;

public class Simple_141_HasCycle {
    public boolean hasCycle(ListNode head) {
        /**
         * 【方法一：快慢指针】
         * 慢指针每次走一步，快指针每次走两步
         * 当快指针先到null，说明没有环，
         * 当快指针和慢指针相遇，说明有环
         */
        ListNode man = head, kuai = head;
        if(head == null)return false;
        while(kuai.next != null && kuai.next.next != null){
            kuai = kuai.next.next;
            if(kuai != man){
                man = man.next;
            }else{
                return true;
            }

        }
        return false;


    }
}
