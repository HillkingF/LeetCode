package Hot_100;

import java.util.Stack;

public class Medium_236_lowestCommonAncestor {
    // 二叉树中，找到两个节点的最近公共祖先

    /* 两个节点p和q的最近公共祖先：
    采用二叉树的前序遍历 递归方法：
    - 先判断根节点是否为p/q：如果为其中一个，则根一定是两个点的祖先。如果不是，则待定
    - 左子树是否有p或者q，如果有，返回第一个遇到的节点
    - 右子树是否有p或者q，如果有，返回第一个遇到的节点

    下面判断几种情况：
    1. root为p/q，直接返回root，说明其中一个点必定是root的子孙. 若root== null，也返回root，因为其没有左右子树
    2. 左子树没有遇到p/q，递归返回结果为null，则两个点必定在root的右子树中
    3. 右子树没有遇到p/q，递归返回结果为null，则两个点必定在root的左子树中
    4. 左子树递归返回值和右子树递归返回值都不是null，则说明root的左右子树中各有一个点，则root为共同祖先
    5. 左和右都没有，说明这一刻树中都没有p和q，则直接返回null
    * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode ltree = lowestCommonAncestor(root.left, p, q);
        TreeNode rtree = lowestCommonAncestor(root.right, p, q);
        if(ltree== null && rtree == null) return null;
        if(ltree == null) return rtree;
        if(rtree == null) return ltree;
        return root;

    }
}


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x){this.val = val;}
}