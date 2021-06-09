package offer;

import java.io.CharArrayReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

////// 我这里的题解:前提是输出所有的位置的元素,即每一层输出的个数都是全的
// 而例题是:叶子节点只用输出子节点为null,不用每一层输出的结果都是完全的
public class offer_37{

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 使用层次遍历,每一层的个数都是确定的,
        // 因此,null也加入队列
        // 直到最后一层所有的节点都是-1,停止
        String res = "";
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<TreeNode> cengqueue = new ArrayDeque<>();
        // 当root == null
        if(root == null) return res;
        // 当root != null
        queue.add(root);
        TreeNode tmp;
        while(!queue.isEmpty()){
            int size = queue.size();
            int sign = 0; // 默认表示这一层全是null
            while(size > 0){
                tmp = queue.poll();
                if(tmp.val != Integer.MIN_VALUE) sign = 1; // 表示这一层至少有一个节点不是null
                cengqueue.add(tmp);
                size --;
            }
            if(sign == 0){  // 说明这一层没有非null节点了
            }else{
                while(!cengqueue.isEmpty()){
                    tmp = cengqueue.poll();
                    if(tmp.val == Integer.MIN_VALUE){
                        res = res + "null,";
                    }else{
                        res = res + String.valueOf(tmp.val) + ",";
                    }

                    if(tmp.left == null){
                        queue.add(new TreeNode(Integer.MIN_VALUE));
                    }else {
                        queue.add(tmp.left);
                    }
                    if(tmp.right == null){
                        queue.add(new TreeNode(Integer.MIN_VALUE));
                    }else{
                        queue.add(tmp.right);
                    }
                }
            }
        }
        System.out.println("[" + res.substring(0, res.length()-1) + "]");
        return "[" + res.substring(0, res.length()-1) + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 说明这是一颗空树,直接返回null
        if(data.equals("") || data.equals("[]")) return null;
        data = data.substring(1, data.length()-1);
        String[] str = data.split(",");

        TreeNode root = new TreeNode(Integer.valueOf(str[0]));
        subtree(str, 0, root);
        return root;
    }
    public void subtree(String[] s, int i, TreeNode root){
        int lindex = (i + 1) * 2 - 1;
        int rindex = (i + 1) * 2;
        if(lindex < s.length){
            if(s[lindex].equals("null")){
            }else{
                TreeNode leftNode = new TreeNode(Integer.valueOf(s[lindex]));
                root.left = leftNode;
                subtree(s, lindex, root.left);
            }
        }
        if(rindex < s.length){
            if (s[rindex].equals("null")) {
            }else{
                TreeNode rightNode = new TreeNode(Integer.valueOf(s[rindex]));
                root.right= rightNode;
                subtree(s, rindex, root.right);
            }
        }
    }
}


class o_37{
    //public String serialize(TreeNode root) {
    //
    //}
    //
    //// Decodes your encoded data to tree.
    //public TreeNode deserialize(String data) {
    //
    //}
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */