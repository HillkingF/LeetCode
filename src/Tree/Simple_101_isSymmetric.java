package Tree;

import java.util.*;

public class Simple_101_isSymmetric {
    public static void main(String[] args){
        //[1,2,2,null,3,null,3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        boolean res = isSymmetric(root);
        System.out.print(res);

    }

    // 递归的写法，初始化时令p，q分别为root，之后作为两个子树同步比较，p的左子树只能和q的右子树比较；p的右子树只能和q的左子树比较
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        TreeNode p = root;
        TreeNode q = root;
        return compare2tree(p, q);
    }

    public static boolean compare2tree(TreeNode a, TreeNode b){
        if(a == null && b == null) return true;
        if(a!= null && b != null){
            boolean res = false;
            if(a.val != b.val) return res;
            if(compare2tree(a.left, b.right) == true && compare2tree(a.right, b.left) == true){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    // 迭代的写法怎么写呢？？
    
}
