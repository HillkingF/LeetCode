package Linked_List;

public class Medium_19_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int count = 0;
        ListNode x = head, p = head;
        if(p != null){  //头节点不等于0
            while(p != null){
                count += 1;
                if(count == n && p.next == null) return head.next; //说明节点数量等于n，直接返回头结点的下一个
                if(count <= n + 1){
                    if(count == n + 1){
                        //记录x指针指向的节点位置，x的下一个就是要删除的
                    }else{
                        //x不变
                    }
                }else if(count > count + 1){
                    x = x.next;
                }
                p = p.next;
            }
            

            return null;
        }else{
            return null;
        }



    }
}
