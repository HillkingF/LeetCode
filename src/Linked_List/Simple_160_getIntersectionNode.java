package Linked_List;

import java.util.HashMap;

public class Simple_160_getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         * 我的第一种方法：设置hashmap存储headA
         * 然后遍历headB,看散列中有没有headB中的节点
         */
        if(headA == null || headB == null) return null;
        HashMap<ListNode, Integer> hashmap = new HashMap<>();
        ListNode la = headA;

        while(la != null){
            hashmap.put(la, 1);
            la = la.next;
        }

        while(headB != null){
            if(hashmap.containsKey(headB)){
                return headB;
            }else{
                headB = headB.next;
            }
        }
        return null;


    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        /**
         * 看题解中的双指针法，很有道理
         */
        return null;
    }
}
