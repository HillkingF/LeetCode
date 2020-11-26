package Tree;

import java.util.Stack;

public class Simple_104_maxDepth {
    public static void main(String[] args){
        /**
         * 题目：返回二叉树的最大深度
         * 思路：
         * 1、深度优先搜索 设置一个maxlen ，当每次往深处遍历的时候与其比较更新
         * 当回退的时候：
         */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int res = maxDepth(root);
        System.out.print(res);
    }
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int maxlen = 1; //只代表最大深度
        int len = 1;  //动态更新的指针,当前深度
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int sign = 1;// 表示还在根上，没有开始左右走

        TreeNode tmp = root;


        while(!stack.isEmpty()){
            while(tmp != null){ // 左子树一直存在就一直左走
                tmp = stack.peek().left;
                len ++;
                if(tmp != null){
                    stack.push(tmp);
                }else{
                    len --;
                    tmp = stack.peek().right;
                    len ++;
                    if(tmp != null){
                        stack.push(tmp);
                    }else{
                        len--;
                    }
                }
                if(len > maxlen) maxlen = len;
            }
            TreeNode x = stack.pop();
            if(!stack.isEmpty()){
                if(stack.peek().right == x) break;
                len --;
                tmp = stack.peek().right;
                len ++;
                if(tmp != null){
                    stack.push(tmp);
                }else{
                    len--;
                }
            }

        }
        return maxlen;


    }
}
