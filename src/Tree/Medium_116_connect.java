package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Medium_116_connect {
    public Node connect1(Node root) {
        // 第一种方法：使用层次遍历，根据每一层的节点个数来填充
        Queue<Node> queue = new LinkedList<>();
        int size;
        if(root==null) return null;

        queue.add(root);
        while(!queue.isEmpty()){
            size = queue.size();
            while(size > 0){
                Node tmp = queue.poll();
                if(tmp.left != null){
                    queue.add(tmp.left);
                    queue.add(tmp.right);
                }
                tmp.next = size == 1 ? null : queue.peek();
                size --;
            }
        }
        return root;
    }

    public Node connect(Node root){
        //第二种方法：递归，常量级空间
        

    }

}
