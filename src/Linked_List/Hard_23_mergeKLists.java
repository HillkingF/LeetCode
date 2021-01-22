package Linked_List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hard_23_mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        int sign = 0;
        for(ListNode x : lists){
            if(x != null){
                sign = 1;
                break;
            }
        }
        if(sign == 0)return null;

        int lslen = lists.length;

        int[] nodelen = new int[lslen];
        ListNode reshead = new ListNode(0,null); // 合并后的头节点
        ListNode restail = reshead; // 合并后的下一个节点

        List<Integer> count = new ArrayList<>();
        while( count.size() < lslen){  //剩余可比较的链表个数
            ListNode minnode = new ListNode(Integer.MAX_VALUE,null);
            int loc = 0;
            for(int i = 0; i < lslen; i++){
                if(count.contains(i)) continue;  // 说明这一个索引位置的节点已经全部遍历完了
                else if(lists[i] == null) count.add(i); // 列表中加入这个分支说明这个分支也完了
                else{
                    if (lists[i].val < minnode.val) {
                        minnode = lists[i];
                        loc = i;
                    }
                }
            }
            if(count.size() != lslen){
                restail.next = minnode;
                lists[loc] = minnode.next;
                minnode.next = null;
                restail = restail.next;
            }else{
                break;
            }

        }
        return reshead.next;






    }

    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists.length == 0) return null;
        ArrayList<Integer> numlist = new ArrayList<Integer>();
        for(int i = 0; i < lists.length; i++){
            while(lists[i]!= null){
                numlist.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        if(numlist.size() == 0) return null;

        int[] arr = new int[numlist.size()];
        int count = 0;
        for(int i: numlist){
            arr[count] = i;
            count ++;
        }
        Arrays.sort(arr);
        ListNode resh = new ListNode(arr[0]);
        ListNode restail = resh;
        for (int i = 1; i < arr.length; i++) {
            ListNode tmp = new ListNode(arr[i]);
            restail.next = tmp;
            restail = restail.next;
        }
        return resh;

    }
}
