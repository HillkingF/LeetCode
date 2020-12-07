package Tree;

import java.time.temporal.Temporal;
import java.util.*;

/**
 * 题目，返回中序遍历列表:左 中 右
 */
public class Medium_94_inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        return digui94(root, list);
    }

    // 方法1：递归
    public List<Integer> digui94(TreeNode root, List<Integer> list){
        if(root != null){
            list = digui94(root.left, list);
            list.add(root.val);
            list  = digui94(root.right, list);
        }
        return list;
    }

    //方法2: 迭代,没看懂
//    public List<Integer> inorderTraversal_diedai(TreeNode root){
//
//    }

}
