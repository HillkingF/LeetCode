package Hot_100;


import com.sun.security.jgss.GSSUtil;

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
    public static void main(String[] args) {
        ListNode head = new ListNode(4, null);
        head.next = new ListNode(2, null);
        head.next.next = new ListNode(1, null);
        head.next.next.next = new ListNode(3, null);
        // head.next.next.next.next = new ListNode(0, null);
        ListNode res = sortList2(head);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }

    }
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


    /* 采用自底向上的归并排序实现最快，空间最少
    *  自底向上可以使用循环（反之使用递归）
    * */
    public static ListNode sortList2(ListNode head){
        // 1.首先统计链表长度
        int len = 0;
        ListNode tmp = head;
        while(tmp != null){
            len ++;
            tmp = tmp.next;
        }

        // 2.定义变量：归并区间、
        int sublen = 1; // 归并区间（一半）
        int start = 0;  // 每一轮从第0个节点开始，直到最后一个节点
        int count = 0;  // 计算每一对儿中，放到的节点个数

        ListNode newhead = new ListNode(0,null);  // 用于保存每一轮归并后的部分有序链表的头结点
        ListNode newlast = newhead; // 新链表的尾结点

        // 3.最外层循环用于控制归并的长度sublen(每轮sublen和sublen个两两归并)：每次sublen以2倍的方式增加
        for(sublen = 1; sublen < len; sublen = sublen * 2){
            newhead.next = null;
            newlast = newhead;
            ListNode head0 = new ListNode(0, head);

            // 4.第二层循环用于两对儿两对儿归并
            for(start = 0; start < len; start=start+2*sublen){ // start = 0, 2, 4 。。。, 所以第一轮比较的是0-1个节点
                // 遍历找到这一对儿节点的中间节点，分别变成A和B组，后面的始终由head指针指向
                count = start;  // 每一对儿中都从start位置开始计数
                // 每一对儿中的左右两部分A和B
                ListNode A = head0;  // head0中是比原来的head链表多出来的一个头结点。主要是为了便于记录访问结果
                ListNode Alast = A;
                ListNode B = head0;
                ListNode Blast = B;
                // 寻找并记录每一对儿无序区间中的A和B部分
                while(count < start + 2*sublen && head != null){
                    if(count <= start + sublen - 1){  // 找A
                        if(count == start){
                            A = head;
                            Alast = A;
                            head = head.next;
                        }else{
                            Alast.next = head;
                            head = head.next;
                            Alast = Alast.next;
                        }
                        Alast.next = null;
                        count ++;
                    }
                    else{
                        if(count == start + sublen){
                            B = head;
                            Blast = B;
                            head = head.next;
                        }else{
                            Blast.next = head;
                            head = head.next;
                            Blast = Blast.next;
                        }
                        Blast.next = null;
                        count ++;
                    }
                }
                // 如果最后一个区间内只有A部分，A已经是有序的，所以直接增加到新链表末位即可
                if(count <= start + sublen){ // 说明只有A，直接添加到新数组
                    newlast.next = A;
                }else{ // 否则如果A，B都存在，则将A和B两个有序数组合并成
                    while(A != null && B != null){
                        if(A.val <= B.val){
                            newlast.next = A;
                            A = A.next;
                            newlast = newlast.next;
                            newlast.next = null;
                        }else{
                            newlast.next = B;
                            B = B.next;
                            newlast = newlast.next;
                            newlast.next = null;
                        }
                    }
                    if(A==null && B == null){
                    }else if(A == null && B != null){
                        newlast.next = B;
                    }else if(A != null&& B== null){
                        newlast.next = A;
                    }
                }
                while(newlast.next != null){
                    newlast = newlast.next;
                }
            } // for
            head = newhead.next;
        }
        return head;





    }


    public static ListNode sortList(ListNode head) {
        if (head == null) {return head;}
        // 1. 统计链表的节点个数
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength=subLength * 2) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

}


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
