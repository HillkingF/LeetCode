package Linked_List;

import java.util.List;

public class Medium_143_reorderList {
    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        ListNode head = new ListNode(0, null);
        ListNode p = head;
        for(int i = 0; i < arr.length; i++){
            ListNode temp = new ListNode(arr[i], null);
            p.next = temp;
            p = p.next;
        }
        head = head.next;
        reorderList(head);

    }
    public static void reorderList(ListNode head) {

        if(head == null || head.next == null) {

        }else{
            //第一遍循环；计算节点个数
            int count = 0;
            ListNode p = head;
            while(p != null){
                count += 1;
                p = p.next;
            }
            count = count % 2 == 0 ? count/2 : count/2 + 1;

            //第二遍循环，断开后面的并翻转后半部分链表
            //第二遍中的第一步：前后断开
            p = head;
            ListNode before  = p;
            int i = 0;
            while (i < count){
                before = p;
                p = p.next;
                i += 1;
            }
            before.next = null;  //前半部分和后半部分断开
            ListNode afternode = p;  //后半部分链表是afternode, 前半部分链表是head

            //第二步中的第二步：后半部分翻转.reverseafter是翻转后的头结点
            ListNode reverseafter = null;
            while(p != null){
                afternode = p.next;
                if(reverseafter == null){
                    reverseafter = p;
                    reverseafter.next = null;
                }else{
                    p.next = reverseafter;
                    reverseafter = p;
                }
                p = afternode;
            }
            //第三遍循环，插入
            p = head;
            before = reverseafter;
            while(before != null){
                reverseafter = reverseafter.next;
                before.next = p.next;
                p.next = before;
                p = p.next.next;
                before = reverseafter;
            }
        }

        ListNode p = head;
        while(p != null){
            System.out.print(p.val);
            p = p.next;
        }


    }
}
