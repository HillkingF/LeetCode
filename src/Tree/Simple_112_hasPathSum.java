package Tree;


import java.util.Stack;

public class Simple_112_hasPathSum {

    /**
     * 递归的思想简单，代码少，体会一下 或 的用法
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null)
            return root.val == sum;

        Boolean leftres = hasPathSum(root.left, sum - root.val);
        Boolean rightres = hasPathSum(root.right, sum - root.val);
        return leftres || rightres;

    }
}
