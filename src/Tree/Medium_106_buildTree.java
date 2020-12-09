package Tree;

/**
 * 思路，给的是中序和后序的数组，跟105题类似
 * 都是先找到根节点，然后分开左右子树，递归遍历
 * 可以使用hashmap存储节点的值和位置，这样会快一点
 *
 * 后序的最后一个数字一定是整棵树的根节点，从后序根节点可以定位中序的根节点，从而在中序数组中分开左右子树中的全部数字
 */
public class Medium_106_buildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return  null;

    }
}
