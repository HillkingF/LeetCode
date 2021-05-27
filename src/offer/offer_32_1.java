package offer;

import java.util.*;

public class offer_32_1 {
    public int[] levelOrder(TreeNode root) {
        // 二叉树层次遍历 使用队列
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int size = 0;
        if(root == null) return new int[0];
        TreeNode tmp;
        queue.add(root);
        while(!queue.isEmpty()){
            size = queue.size();
            while(size > 0){
                tmp = queue.poll();
                arrayList.add(tmp.val);
                if(tmp.left != null) queue.add(tmp.left);
                if(tmp.right != null) queue.add(tmp.right);
            }
        }
        size = arrayList.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = arrayList.get(i);
        }
        return res;
    }
}
