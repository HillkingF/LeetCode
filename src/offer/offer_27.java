package offer;

public class offer_27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return root;
        TreeNode newroot = subTree(root);
        return newroot;
    }
    public TreeNode subTree(TreeNode root){
        if(root == null) return root;
        TreeNode left = subTree(root.right);
        TreeNode right = subTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }
}
