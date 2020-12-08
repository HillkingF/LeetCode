package Tree;

public class Medium_98_isValidBST {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        Boolean rightsub = isValidBST(root.right);
        Boolean leftsub = isValidBST(root.left);
        if(rightsub == false || leftsub == false) return false;
        else{
            if(root.right != null){
                TreeNode righttree = root.right;
                while(righttree.left != null){
                    righttree = righttree.left;
                }
                if(righttree.val <= root.val) return false;
            }
            if(root.left != null){
                TreeNode lefttree = root.left;
                while(lefttree.right != null){
                    lefttree = lefttree.right;
                }
                if(lefttree.val >= root.val) return false;
            }
            return true;

        }

    }

}
