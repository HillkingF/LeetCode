package offer;

import java.util.HashMap;

public class offer_52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode a = headA;
        while(a != null){
            map.put(a, 1);
            a = a.next;
        }
        a = headB;
        while(a != null){
            if(map.containsKey(a)) return a;
            a = a.next;
        }
        return a;

    }
}
