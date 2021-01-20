package Linked_List;

import java.util.HashMap;

public class Medium_142_detectCycle {
    public ListNode detectCycle(ListNode head) {
        /**
         * 环形链表中：
         * 函数的参数是一个随机的节点，
         * 以这个节点作为索引为0的节点开始遍历
         * 不知道这链表中不重复的节点一共有几个，也不知道环中有几个节点
         * 不知道没入环的有几个节点
         */

        //想到了寄一个办法：hashmap 保存 节点和次数
        /**
         * 当 头结点为null 直接返回null；
         * 循环遍历（若当前节点不为null）{
         *         如果hashmap中有这个节点，则直接返回true
         *         如果当前节点不在hashmap中{
         *               将这个节点放入map，
         *               指针指向当前节点的下一个节点；
         *         }
         *   }
         *   当不满足循环条件，就说明当前节点是null，则一定不循环，直接返回null；
         */
        HashMap<ListNode, Integer> map = new HashMap<>();
        if(head == null) return null;

        while(head != null){
            if(map.containsKey(head)){
                return head;
            }else{
                map.put(head, 1);
                head = head.next;
            }
        }
        return null;

    }

    public ListNode detectCycle1(ListNode head){
        // 方法二：快慢指针
        /*
        设置一个慢指针，一次走一步；一个快指针，一次走2步；
        环外的距离设为，开始入环到快慢相遇点的距离设置为b，剩下的快指针多走的一段设置为c；
        设慢指针走到a点时快指针已经走完了n圈，而慢指针走完了m圈
        且无论慢指针走到哪，快指针的距离都是慢指针的两倍；
        因此：
        a + n(b + c) + b  = 2[a + m(b+c) + b]
        => 推出：(n-1-2m)(b+c) + c = a
        其中，上式左边第一个加数表示 n-1-2m 圈， 因为 b+c是一圈
        所以c = a

        当快慢指针相遇时，设置一个额外的指针从开始处，与慢指针同时移动；再次相遇为初始点
         */
        return null;
    }
}
