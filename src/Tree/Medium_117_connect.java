package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Medium_117_connect {
    // 这道题是116题的进阶版本，116中是完美二叉树，这道题中的二叉树可能存在空子树
    public Node connect(Node root) {
        // 第一种方法，还是使用层次遍历，不管每一层有几个节点都可以找到右侧的节点
        Queue<Node> queue = new LinkedList<>();
        int size;
        if(root==null) return null;

        queue.add(root);
        while(!queue.isEmpty()){
            size = queue.size();
            while(size > 0){
                Node tmp = queue.poll();
                if(tmp.left != null)  queue.add(tmp.left);
                if(tmp.right != null) queue.add(tmp.right);
                tmp.next = size == 1 ? null : queue.peek();
                size --;
            }
        }
        return root;
    }
}
