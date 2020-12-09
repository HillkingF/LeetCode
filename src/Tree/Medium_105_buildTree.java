package Tree;

import java.util.Arrays;

/**思路：
 * 前序序列中每一个数字都是某个子树的根节点，
 * 所以前序数组中第一个一定是整个树的根节点
 * 从第一个根节点就可以找到中序的左子树和右子树，然后分别对左右子树继续寻找根及根的左右子树
 */
public class Medium_105_buildTree {
    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7,8,9};
        int[] b = Arrays.copyOfRange(a, 2,4);
        for (int num : b){
            System.out.print(num);
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        root = subtree(root, preorder, inorder);
        return root;
    }
    public TreeNode subtree(TreeNode root,int[] preorder, int[] inorder){
        int subleftlen = 0;
        int[] subleft_inorder;
        int[] subleft_preorder;

        int subrightlen = 0;
        int[] subright_inorder;
        int[] subright_preorder;

        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == root.val){  //去找中序数组中的根节点
                // 找到中序中的根节点，左边的就是左子树的节点
                subleftlen = i;
                if(subleftlen == 0) root.left = null;
                else{
                    subleft_inorder = Arrays.copyOfRange(inorder,  0 ,  i );
                    subleft_preorder = Arrays.copyOfRange(preorder,1, 1+subleftlen);
                    TreeNode subleftroot = new TreeNode(subleft_preorder[0]);
                    subleftroot = subtree(subleftroot,subleft_preorder, subleft_inorder );
                    root.left = subleftroot;
                }

                // 找到中序中的根节点，右边的就是右子树的节点
                subrightlen = inorder.length-1 - i;
                if(subrightlen == 0) root.right = null;
                else{
                    subright_inorder = Arrays.copyOfRange(inorder,  i+1 ,  inorder.length );
                    subright_preorder = Arrays.copyOfRange(preorder, 1+subleftlen, preorder.length);
                    TreeNode subrightroot = new TreeNode(subright_preorder[0]);
                    subrightroot = subtree(subrightroot, subright_preorder, subright_inorder);
                    root.right = subrightroot;
                }
                break;  //找到后结束遍历
            }
        }
        return root;
    }
}
