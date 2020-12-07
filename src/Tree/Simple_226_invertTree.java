package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Simple_226_invertTree {
    public TreeNode invertTree(TreeNode root) {
        // 使用递归的方法来做
        if(root != null){
            TreeNode left = root.right;
            TreeNode right = root.left;
            root.left = left;
            root.right = right;
            root.left = invertTree(root.left);
            root.right = invertTree(root.right);
        }
        return root;

    }
}
