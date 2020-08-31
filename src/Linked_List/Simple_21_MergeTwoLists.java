package Linked_List;

public class Simple_21_MergeTwoLists {
    public static void main(String[] args){

    }

    /**
     * 【定义链表结构】
     * 其实就是定义一个链表节点类，其中规定了如何存储数据，如何记录位置
     */
    public static class ListNode {
        int val;
        ListNode next; // 指向下一个链表节点
        ListNode() {}  // 链表节点类的构造方法
        ListNode(int val) { this.val = val; }  // 链表节点类的构造方法
        ListNode(int val, ListNode next) { this.val = val; this.next = next; } // 链表节点类的构造方法
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) { //l1,l2分别是头结点
        ListNode l = null;
        ListNode p=null, q= null;
        if(l1.next == null && l2.next != null){
            l = l2;
        }else if(l2.next == null && l1.next != null){
            l = l1;
        }else if(l1.next == null && l2.next == null){

        }else{ //两个都不为空
            while(l1.next != null && l2.next != null){
                if(l1.val <= l2.val){
                    if(l == null){//说明是头结点开始
                        l.val = l1.val;
                        l.next = null;
                        p = l1.next;
                    }else{

                    }
                }else if(l1.val > l2.val){
                    if(l == null){//说明是头结点开始
                        l.val = l2.val;
                        l.next = null;
                    }
                }
            }
        }

        return l;
    }

}
