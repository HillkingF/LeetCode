package Hot_100;


/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 进阶：
 *     你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 *
 * 考察排序算法：
 * 插入排序的时间复杂度是 O(n^2)
 * 时间复杂度是 O(nlogn) 的排序算法包括：归并排序、堆排序和快速排序
 * （快速排序的最差时间复杂度是O(n^2)），
 * 其中最适合链表的排序算法是归并排序：
 * 归并排序基于分治算法。最容易想到的实现方式是自顶向下的递归实现，
 * 考虑到递归调用的栈空间，自顶向下归并排序的空间复杂度是 O(logn)。
 * 如果要达到 O(1) 的空间复杂度，则需要使用自底向上的实现方式。
 */
public class Medium_148_sortList {
    /**
     * sortList1方法：
     * 使用的是冒泡法，超出了时间限制
     */
    public ListNode sortList1(ListNode head){
        if(head == null || head.next == null) return head;
        // 当链表至少有两个节点时，执行下面的操作
        ListNode eachmin = head;
        ListNode pre = head;
        ListNode last = head.next;
        ListNode newhead = new ListNode(0, null);
        ListNode newlast = newhead;

        while(last != null){
            if(last.val < eachmin.val){
                eachmin = last;  // 说明此时last的位置是本轮最小的元素
                while(pre.next != last){
                    pre = pre.next;
                }  // pre.next == last; 停止
            }
            if(last.next == null){  // 可以移动了，开始下一轮
                System.out.println(eachmin.val);
                if(eachmin == head){  // 说明本轮最小的就是head
                    newlast.next = eachmin;
                    newlast = newlast.next;

                    head = head.next;
                    last = head.next;
                    newlast.next = null;
                    pre = head;
                    eachmin = head;
                }else{
                    newlast.next = eachmin;
                    newlast = newlast.next;
                    pre.next = pre.next.next;
                    newlast.next = null;
                    last = head.next;
                    pre = head;
                    eachmin = head;
                }
            }else{ // last继续向后移动
                last = last.next;
            }
        }
        if(head != null){
            newlast.next = head;
        }
        return newhead.next;
    }
}


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
