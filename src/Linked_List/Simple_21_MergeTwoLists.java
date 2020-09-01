package Linked_List;

public class Simple_21_MergeTwoLists {
    public static void main(String[] args){
        ListNode l1 = null, l1last = null, l2 = null;

        ListNode temp = new ListNode();
        temp.val = 1;
        temp.next = null;

        // 创建l1;
        l1 = temp;
        l1last = l1;

        temp.val = 2;
        temp.next = null;
        l1last.next = temp;

        temp.val = 4;
        temp.next = null;
        l1last.next = temp;

//        // 创建l2
//        temp.val = 1;
//        temp.next = null;
//        l2 = temp;
//        temp.val = 3;
//        temp.next = null;
//        l2.next = temp;
//        temp.val = 4;
//        temp.next = null;
//        l2.next.next = temp;

        temp.val = l1.val;
        temp.next = l1.next;
        while(temp != null){
            System.out.print(temp.val);
            temp = temp.next;
        }


    }

    /**
     * 【定义链表结构】
     * 其实就是定义一个链表节点类，其中规定了如何存储数据，如何记录位置
     */

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) { //l1,l2分别是头结点
        ListNode l = new ListNode(-1);  // 头节点
        ListNode prev = l;   //尾结点
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;  //=null
        }
        prev.next = l1 == null ? l2 : l1;  // prev.val 和 prev.next只表示prev指针上的单元名字，next不表示下一个位置
        return l.next;
    }

}
