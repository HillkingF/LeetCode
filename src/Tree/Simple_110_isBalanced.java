package Tree;

import java.util.HashMap;
import java.util.List;

public class Simple_110_isBalanced {

    // 递归计算左子树的深度，右子树的深度，如果高度差大于1，则直接返回false；
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        String str = depth(root);
        if(str.split(":")[1].equals("T")){
            return true;
        }else{
            return false;
        }


    }
    public String depth(TreeNode root){
        if(root == null) return "0:T";
        String leftdep = depth(root.left);
        String rightdep = depth(root.right);
        int llen = Integer.valueOf(leftdep.split(":")[0]);
        int rlen = Integer.valueOf(rightdep.split(":")[0]);
        int len = Math.max(llen, rlen) + 1;

        if(leftdep.split(":")[1].equals("F")||rightdep.split(":")[1].equals("F")){
            return String.valueOf(len) + ":F";
        }
        
        if(Math.abs(llen - rlen) > 1){
            return String.valueOf(len) + ":F";
        }else{
            return String.valueOf(len) + ":T";
        }
    }
}
