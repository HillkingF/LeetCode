package offer;

import java.util.*;

public class offer_32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        int size;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode tmp ;
        int sign = 0; // 0表示从左往右,1表示从右向左
        queue.add(root);
        while (!queue.isEmpty()){
            size = queue.size();
            List<Integer> list =  new ArrayList<>();
            while(size > 0){
                size --;
                tmp = queue.poll();
                if(tmp.left != null) queue.add(tmp.left);
                if(tmp.right != null) queue.add(tmp.right);
                list.add(tmp.val);
            }
            if(sign == 0) {
                sign = 1;
                res.add(list);
            } else{
                sign = 0;
                List<Integer> rightlist = new ArrayList<>();
                for (int i = list.size()-1; i >=0 ; i--) {
                    rightlist.add(list.get(i));
                }
                res.add(rightlist);
            }
        }
        return res;
    }
}
