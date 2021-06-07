package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class offer_34 {

    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recurrent(root, target, new ArrayList<>());
        return res;
    }
    public void recurrent(TreeNode root, int locsum, List<Integer> list){
        if(root == null) return;
        List<Integer> newlist = new ArrayList<>(list);
        newlist.add(root.val);
        locsum = locsum - root.val;
        if(root.left == null && root.right == null){
            // 这个节点是叶子节点,判单局部和
            if(locsum == 0){ res.add(newlist); }
        }else{
            // 这个节点不是叶子节点,继续加和递归
            recurrent(root.left, locsum, newlist);
            recurrent(root.right, locsum, newlist);
        }
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */