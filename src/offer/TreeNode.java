package offer;



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, offer_37.TreeNode left, offer_37.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}