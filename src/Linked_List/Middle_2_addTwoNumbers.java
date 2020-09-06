package Linked_List;

import java.util.List;

public class Middle_2_addTwoNumbers {
    public static void main(String[] args){
        int[] arr1 = {2,4,3};
        int[] arr2 = {5,6,4};


        ListNode head1 = new ListNode(arr1[0]);
        head1.next = null;
        ListNode last1 = head1;
        for(int i = 1; i< arr1.length; i++){
            ListNode temp = new ListNode(arr1[i]);
            temp.next = null;
            last1.next  = temp;
            last1 = last1.next;

        }
        ListNode head2 = new ListNode(arr2[0]);
        head2.next = null;
        ListNode last2 = head2;
        for(int i = 1; i< arr2.length; i++){
            ListNode temp = new ListNode(arr2[i]);
            temp.next = null;
            last2.next  = temp;
            last2 = last2.next;

        }

        ListNode l = addTwoNumbers(head1, head2);
        while(l!= null){
            System.out.print(l.val);
            l = l.next;
        }

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 【思路】
         * 相加存储
         */


        ListNode len1 = l1;
        ListNode len2 = l2;
        //相加存储
        ListNode res = new ListNode(0);
        res.next = null;
        ListNode reslast = res;

        int co = 0;
        int sum = 0;
        while(len1 != null && len2 != null){
            ListNode newnode = new ListNode();
            sum = len1.val + len2.val + co;
            newnode.val = sum %10;
            newnode.next = null;
            co = sum / 10;

            reslast.next = newnode;
            reslast = reslast.next;
            len1 = len1.next;
            len2 = len2.next;
        }

        if(len1 == null && len2 == null){
            if(co != 0){
                ListNode newnode = new ListNode(co);
                newnode.next = null;
                reslast.next = newnode;
            }
        }else{
            len1 = len1 == null? len2: len1;
            while(len1 != null){
                sum = len1.val + co;
                ListNode newnode = new ListNode();
                newnode.val = sum%10;
                newnode.next = null;
                co = sum/10;
                reslast.next = newnode;
                reslast = reslast.next;
                len1 = len1.next;
            }
            if(co != 0){
                ListNode newnode = new ListNode(co);
                newnode.next = null;
                reslast.next = newnode;
            }
        }
        return res.next;
    }

}
