package Tree;

import java.util.HashMap;
import java.util.List;

public class Simple_110_isBalanced {
    // 递归计算左子树的深度，右子树的深度，如果高度差大于1，则直接返回false；
    // 注释掉的这个思路 时间复杂度直接 5%，太慢了
//    public boolean isBalanced(TreeNode root) {
//        if(root == null) return true;
//        String str = depth(root);
//        if(str.split(":")[1].equals("T")){
//            return true;
//        }else{
//            return false;
//        }
//
//
//    }
//    public String depth(TreeNode root){
//        if(root == null) return "0:T";
//        String leftdep = depth(root.left);
//        String rightdep = depth(root.right);
//        int llen = Integer.valueOf(leftdep.split(":")[0]);
//        int rlen = Integer.valueOf(rightdep.split(":")[0]);
//        int len = Math.max(llen, rlen) + 1;
//
//        if(leftdep.split(":")[1].equals("F")||rightdep.split(":")[1].equals("F")){
//            return String.valueOf(len) + ":F";
//        }
//
//        if(Math.abs(llen - rlen) > 1){
//            return String.valueOf(len) + ":F";
//        }else{
//            return String.valueOf(len) + ":T";
//        }
//    }
    public boolean isBalanced(TreeNode root){
        int res = depth(root);
        if(res == -1) return false;
        else return true;
    }
    // 思路： 判断节点左右子树的深度，当左或右子树不平衡时，直接返回-1，否则深度一定是非负整数。
    // 每次返回后先判断 深度是不是-1，若是-1则直接返回-1；否则先比较左右深度，再判断是不是平衡
    // 时间一下到了 99%
    public int depth(TreeNode root){
        if(root == null) return 0;
        int leftdep = depth(root.left);
        int rightdep = depth(root.right);
        if(leftdep == -1 || rightdep == -1) return -1;

        if(Math.abs(leftdep - rightdep) > 1){
            return -1;
        }else{
            int len = Math.max(leftdep, rightdep) + 1;
            return len;
        }
    }
}
