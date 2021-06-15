package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class offer_06 {
    public int[] reversePrint(ListNode head) {
        // 思路:栈来存储链表节点的值
        Stack<Integer> resarr = new Stack<>();
        int N = 0;
        while(head != null){
            resarr.push(head.val);
            head = head.next;
            N ++;
        }
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = resarr.pop();
        }
        return res;
    }
}

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}