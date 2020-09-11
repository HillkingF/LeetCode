package Linked_List;

import java.util.HashMap;

public class Medium_82_deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        /**
         * 【思路】
         * 两遍扫描，第一遍计数
         * 第二遍删除
         */
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ListNode ln = head;
        while(ln != null){
            if(hashMap.containsKey(ln.val)){
                hashMap.put(ln.val, hashMap.get(ln.val) + 1);
            }else{
                hashMap.put(ln.val, 1);
            }
            ln = ln.next;
        }
        ln = new ListNode(0);
        ln.next = head;
        ListNode last = ln;

        ListNode after = new ListNode();
        while(head != null){
            if(hashMap.get(head.val) != 1){
                after = head.next;
                last.next = after;
                head = after;
            }else{
                head = head.next;
                last = last.next;
            }
        }
        return ln.next;
    }
}
