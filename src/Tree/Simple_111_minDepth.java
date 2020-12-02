package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Simple_111_minDepth {
    public static void main(String[] args){
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);
        int res = minDepth(t);
        System.out.println(res);
    }

    /**
     *思路类似于104题
     * 使用一个变量记录存入队列中的每一层的节点个数，按照个数递减出队列。
     * 出队列的节点都无左右子树的时候直接返回当前深度，否则将左右子节点入队。
     */
    public static int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int nums = queue.size();
            depth ++;
            while(nums > 0){
                TreeNode tmp = queue.poll();
                if(tmp.left == null && tmp.right==null) return depth;
                if(tmp.left != null) queue.add(tmp.left);
                if(tmp.right != null) queue.add(tmp.right);
                nums--;
            }
        }
        return depth;

    }
}
