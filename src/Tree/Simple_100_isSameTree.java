package Tree;

import sun.reflect.generics.tree.Tree;

import java.sql.Statement;
import java.util.Stack;

public class Simple_100_isSameTree {
    public static void main(String[] args){
//        pre_definetree tree = new pre_definetree();
//        TreeNode p = tree.def(nums);
//        TreeNode q = tree.def(nums);
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(4);

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        boolean res = comparetree(t, p);
        System.out.print(res);


    }

    /**
     * [题目]
     * 给定两棵树，判断是否相同.
     * 注意题目中的树[1,2,3]是以广度优先的方式存储的
     * [思路]
     * 选择一个遍历顺序，如：前序
     * 依次比较两个树的每一个节点，两个节点不一样，
     * 或者一个有节点，一个无节点，则结束，否则遍历到最后，结束相同
     */
    public static boolean comparetree(TreeNode p, TreeNode q){

        if(p==null && q == null) return true;
        else if(p==null || q == null) return false;

        TreeNode root1 = p;
        TreeNode root2 = q;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(p);
        s2.push(q);

        while(!s1.isEmpty() && !s2.isEmpty()){
            while(root1 != null && root2 != null){
                if(root1.val != root2.val){
                    return false;
                }else{
                    //然后将树根向左子树移动
                    root1 = root1.left;
                    root2 = root2.left;
                    // 走到这一步说明两个子树根不为空
                    // 先将两个子树根分别存入栈中
                    if(root1 != null && root2 != null){
                        s1.push(root1);
                        s2.push(root2);
                    }
                }
            }
            if(root1 == null && root2 == null){
                // 两个都为空，说明到了叶子结点，
                // 出栈某个父节点（这个出栈的节点一定已经遍历过了）,
                // 所以令根等于其右子树根
                root1 = s1.pop().right;
                root2 = s2.pop().right;
                if(root1 != null && root2 != null){
                    s1.push(root1);
                    s2.push(root2);
                }
            }else{
                return false;
            }
        }
        return true;

    }

}
