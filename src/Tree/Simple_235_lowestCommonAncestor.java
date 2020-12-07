package Tree;

public class Simple_235_lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int l = p.val > q.val ? p.val : q.val;
        int s = p.val > q.val ? q.val : p.val;
        TreeNode res = root;

        if(s <= root.val && root.val <= l) res = root;
        else if(l < root.val) res = lowestCommonAncestor(root.left, p, q);
        else if(s > root.val) res = lowestCommonAncestor(root.right, p, q);
        return res;

    }
}
