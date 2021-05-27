package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class offer_32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        int size = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode tmp;
        while(!queue.isEmpty()){
            size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size > 0){
                size--;
                tmp = queue.poll();
                list.add(tmp.val);
                if(tmp.left != null) queue.add(tmp.left);
                if(tmp.right != null) queue.add(tmp.right);
            }
            res.add(list);
        }
        return res;
    }
}
