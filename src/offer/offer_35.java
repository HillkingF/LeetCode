package offer;

import java.util.HashMap;

// 利用哈希表的查询特点，考虑构建 原链表节点 和 新链表对应节点 的键值对映射关系，
// 再遍历构建新链表各节点的 next 和 random 引用指向即可。
public class offer_35 {
    // 用于保存新-旧节点映射
    private HashMap<Node, Node> mapoldnew = new HashMap<>();


    public Node copyRandomList(Node head) {
        if(head == null) return null;
        // 首先构建新旧节点的map映射
        Node tmp = head;
        while(tmp != null){
            mapoldnew.put(tmp, new Node(tmp.val));
            tmp = tmp.next;
        }
        // 构建新链表的next
        tmp = head;
        while(tmp != null){
            mapoldnew.get(tmp).next = mapoldnew.get(tmp.next);
            if(tmp.random != null){
                mapoldnew.get(tmp).random = mapoldnew.get(tmp.random);
            }
            tmp = tmp.next;
        }
        // 返回最终的结果
        return mapoldnew.get(head);
    }

}
