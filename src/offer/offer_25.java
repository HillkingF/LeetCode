package offer;

import java.util.List;

public class offer_25 {
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        else if(l1 == null) return l2;
        else if(l2 == null) return l1;

        ListNode newhead = new ListNode(0);
        ListNode newlast = newhead;
        ListNode out;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                // 断开l1的节点
                out = l1;
                l1 = l1.next;
                out.next = null;
                // 增加到新链表中
                newlast.next = out;
                newlast = newlast.next;
            }else{
                out = l2;
                l2 = l2.next;
                out.next = null;
                newlast.next = out;
                newlast = newlast.next;
            }
        }
        if(l1 == null && l2 == null){
        }else if(l1 == null){
            newlast.next = l2;
        }else{
            newlast.next = l1;
        }
        return newhead.next;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
