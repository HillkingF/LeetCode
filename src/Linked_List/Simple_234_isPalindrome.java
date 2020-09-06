package Linked_List;

import java.util.List;

public class Simple_234_isPalindrome {
    public static void main(String[] args){
        int[] arr = {1,0,1};

        ListNode head = new ListNode(arr[0]);
        head.next = null;
        ListNode last = head;
        for(int i = 1; i< arr.length; i++){
            ListNode temp = new ListNode(arr[i]);
            temp.next = null;
            last.next  = temp;
            last = last.next;

        }

        boolean x = isPalindrome(head);
        System.out.println(x);
    }

    public static boolean isPalindrome(ListNode head) {
        /**
         * 【方法思路】
         * 第一次循环：计算链表的节点数
         * 第二次循环：
         * *比较遍历的节点个数：
         * *到中间的节点之前，将遍历到的节点翻转：类似第206题（这里在单双数上有一些区别，具体看代码）
         * *这样就形成了两个新的部分链表：一个是前半部分，一个是后半部分
         * 第三次循环：两个新的半截链表依次比较值，有不一样的就不是回文
         *
         */
        if(head==null || head.next == null)return true;
        int listlen = 0;
        ListNode left = head;
        while(left != null){
            listlen++;
            left = left.next;
        }
        int zuolen = listlen/2 - 1;
        int youlen = listlen%2==0? listlen/2 : listlen/2 +1;


        ListNode pre = null;
        ListNode cur = head;
        int prelen = 0;
        while(prelen <= zuolen){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            prelen ++;
        }
        cur = listlen%2==0? cur: cur.next;

        //前半部分的head是pre，后半部分的head是cur
        while(pre != null){
            if(pre.val == cur.val){
                pre = pre.next;
                cur = cur.next;
            }else{
                return false;
            }
        }
        return true;

    }
    public static boolean isPalindrome1(ListNode head) {
        /**
         * 【方法思路】跟isPalindrome一样
         * 进行一些化简
         */
        if(head==null || head.next == null)return true;
        int listlen = 0;
        ListNode cur = head;
        while(cur != null){
            listlen++;
            cur = cur.next;
        }
        int zuolen = listlen/2 - 1;
        ListNode pre = null;
        cur = head;
        int prelen = 0;
        // 第一次循环
        while(prelen <= zuolen){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            prelen ++;
        }
        cur = listlen%2==0? cur: cur.next;  //如果是单数个节点，后半个链表从中间节点的下一个节点开始

        //前半部分的head是pre，后半部分的head是cur
        while(pre != null){
            if(pre.val == cur.val){
                pre = pre.next;
                cur = cur.next;
            }else return false;
        }
        return true;

    }
}
