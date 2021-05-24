package offer;

import java.awt.font.LineMetrics;

public class offer_07 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 前序遍历:中左右 中序遍历:左中右 后序遍历:左右中
        // 这个序指的是父节点的顺序(父节点的位置是中)
        // 所以给出前序和中序, 只要找到每一棵子树的父节点,
        // 就可以确定这个子树的左右子树了.
        // 然后递归
        return findhead(preorder,inorder,0,preorder.length-1, 0,inorder.length-1);
    }
    // 初始 start = 0 = end
    public TreeNode findhead(int[] pre, int[] in, int startpre, int endpre, int startin, int endin){
        if(startpre >= pre.length || endpre < startpre) return null;
        int i = startpre, j = startin;
        while(pre[i] != in[j]) j++;

        // 新子树的根
        TreeNode newhead = new TreeNode(pre[i]);
        int len = j - startin;
        // 新子树的左子树
        if (len > 0) {
            TreeNode lefttree = findhead(pre, in, startpre + 1, startpre+j-startin, startin, j -1);
            newhead.left = lefttree;
        }
        // 新子树的右子树
        len = endin - j;
        if(len > 0){
            TreeNode righttree = findhead(pre, in, startpre+j-startin + 1, endpre, j + 1, endin);
            newhead.right = righttree;
        }
        return newhead;
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
