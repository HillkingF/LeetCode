package Linked_List;

class ListNode {
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(int x, ListNode nextnode) {
        val = x;
        next = nextnode;
    }
}
