package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Simple_104_maxDepth {
    public static void main(String[] args){
        /**
         * 题目：返回二叉树的最大深度
         * 思路：
         * 1、深度优先搜索 设置一个maxlen ，当每次往深处遍历的时候与其比较更新
         * 当回退的时候：
         */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(0);
        root.right = new TreeNode(-4);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(-6);
        root.right.left = new TreeNode(-9);
        root.left.left.left = new TreeNode(7);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(3);

        root.left.right.right = new TreeNode(3);
        root.left.right.right = new TreeNode(3);

        int res = maxDepth(root);
        System.out.print(res);
    }

    /**
     *方法1：
     * 使用递归的方法
     */
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftlen = maxDepth(root.left);
        int rightlen = maxDepth(root.right);
        int m = leftlen >= rightlen ? leftlen:rightlen;
        return m + 1;
    }

    /**
     * 方法2：
     * 迭代
     * 创建一个队列，并首先将树根入队
     * 下面开始循环：
     * 在没有将节点入队时，计算队列中的节点数总和sum，这个值就是每一层的节点数
     * 每一轮出队一次，sum--。减到0就说明一层的节点都出队了。同时每一个出队节点的左右子节点都入队
     */
    public static int maxDepth1(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int sum = 0;
        int len = 0;
        while(!queue.isEmpty()){
            sum = queue.size();
            while(sum > 0){  // sum大于0，说明这一层还有节点在队列中，需要出队，并将子节点入队
                TreeNode tmp = queue.poll();
                if(tmp.left != null) queue.add(tmp.left);
                if(tmp.right != null) queue.add(tmp.right);
                sum --;
            }
            len ++;
        }
        return len;
    }
}
