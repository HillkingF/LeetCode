package offer;

import java.util.LinkedList;
import java.util.Queue;

public class offer_54 {
    private Queue<TreeNode> queue = new LinkedList<>();
    public int kthLargest(TreeNode root, int k) {
        if(root == null) return 0;
        inqueue(root);
        TreeNode out = root;
        if(k > queue.size()) return 0;
        for(int i = 1; i <= k; i++){
            out = queue.poll();
        }
        return out.val;
    }
    public void inqueue(TreeNode node){
        if(node.right != null) inqueue(node.right);
        queue.add(node);
        if(node.left != null) inqueue(node.left);
    }
}
