package offer;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class offer_28 {
    // isSymmetric() 是我第一次写的时候用的笨办法:
    // 用两个队列,分别依次保存从左开始遍历的节点和从右开始遍历的结果
    // 同时出队入队,并同时判断,一个点有左子节点时,另一个点有没有右子节点
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        Queue<TreeNode> queuel = new ArrayDeque<>();
        Queue<TreeNode> queuer = new ArrayDeque<>();
        int size;
        queuel.add(root);
        queuer.add(root);
        TreeNode tmpl;
        TreeNode tmpr;
        while (!queuel.isEmpty()) {
            size = queuel.size();
            while (size > 0) {
                size--;
                // 将两个队列出队
                tmpl = queuel.poll();
                tmpr = queuer.poll();
                // 判断出队的两个节点是不是镜像的
                if (tmpl.val == tmpr.val){
                    // 一个节点有左,镜像节点必须有右节点,不然不对称.
                    if (tmpl.left != null && tmpr.right != null) {
                        queuel.add(tmpl.left);
                        queuer.add(tmpr.right);
                    } else if(tmpl.left == null && tmpr.right == null){
                    } else return false;

                    if (tmpl.right != null && tmpr.left != null) {
                        queuel.add(tmpl.right);
                        queuer.add(tmpr.left);
                    }else if(tmpl.right == null && tmpr.left == null){
                    }else return false;
                }else{
                    return false;
                }
            }
        }
        return true;
    }


    // 下面用递归遍历的优化方法: 最左只能和最右比较
    public boolean isSymmetric1(TreeNode root){
        if(root == null) return true;
        boolean res = recurrent(root.left, root.right);
        return res;

    }
    public boolean recurrent(TreeNode L, TreeNode R){
        if(L == null && R == null) return true;
        if((L == null && R != null) || (L != null && R == null)) return false;
        if(L.val == R.val){
            return recurrent(L.left, R.right) &&  recurrent(L.right, R.left);
        }else return false;
    }
}