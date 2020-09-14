package Linked_List;

/**
 * 理解深拷贝和浅拷贝的区别
 * 浅拷贝：改了新的链表地址，旧的链表也改变
 * 深拷贝：新建一个链表，只复制值，不对旧的链表造成影响
 */
public class Medium_138_copyRandomList {
    public Node copyRandomList(Node head) {

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