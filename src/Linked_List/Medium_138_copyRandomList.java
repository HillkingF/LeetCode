package Linked_List;

/**
 * 理解深拷贝和浅拷贝的区别
 * 浅拷贝：改了新的链表地址，旧的链表也改变
 * 深拷贝：新建一个链表，只复制值，不对旧的链表造成影响
 */
public class Medium_138_copyRandomList {
    public static void main(String[] args){

    }
    /**
     * 【使用新旧节点交替的方法，也就是官方方法三】
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        //1、为原始链表每一个节点都创建一个新的一模一样的节点，并放置在每个节点的后面
        Node p = head;
        while(p != null){
            Node copynode = new Node(p.val);
            copynode.next = p.next;
            p.next = copynode;
            p = copynode.next;
        }
        //2、从头开始遍历，更新random域
        p = head;
        while(p != null && p.next!=null){
            p.next.random = (p.random != null) ? p.random.next : null;
            p = p.next.next;
        }
        //3、拆分新旧链表
        p = head;
        Node newhead = p.next;
        Node q = newhead;
        Node after = q.next;
        while(p != null){
            after = q.next;
            if(after !=  null){
                p.next = after;
                p = p.next;
                q.next = after.next;
                q = q.next;
            }else{
                q.next = null;
                p.next = null;
                break;
            }
        }
        return newhead;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}