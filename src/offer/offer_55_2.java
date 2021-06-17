package offer;

public class offer_55_2 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int res = treedepth(root);
        if(res == -1) return false;
        else return true;

    }
    public int treedepth(TreeNode root){
        if(root == null) return 0;
        int ldepth = treedepth(root.left);
        int rdepth = treedepth(root.right);
        if(ldepth == -1 || rdepth == -1) return -1;
        if(-1 <= ldepth - rdepth && ldepth - rdepth <= 1){
            return Math.max(ldepth, rdepth) + 1;
        }else{
            return -1;
        }
    }
}
