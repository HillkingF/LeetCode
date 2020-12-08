package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Medium_102_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> outer = new LinkedList<>();
        if(root == null) return outer;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 0;
        while(!queue.isEmpty()){
            size = queue.size();
            List<Integer> inner = new LinkedList<>();
            while(size > 0){
                TreeNode tmp = queue.poll();
                inner.add(tmp.val);
                if(tmp.left != null){
                    queue.add(tmp.left);
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                }
                size--;

            }
            if(size == 0) outer.add(inner);

        }
        return outer;

    }
}
