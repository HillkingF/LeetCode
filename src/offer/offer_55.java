package offer;

import java.util.LinkedList;
import java.util.Queue;

public class offer_55 {
    public int maxDepth(TreeNode root) {
        // 使用层次遍历
        int len = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                size --;
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            len ++;
        }
        return len;
    }
}
