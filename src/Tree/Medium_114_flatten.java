package Tree;

public class Medium_114_flatten {
    public void flatten(TreeNode root) {
        if(root == null) return;
        else{
            root = sublink(root);
        }
    }
    // 这个方法用于分别将左右子树变成单链表
    // 规则是将链表化的右链表接在链表化的左链表之后
    public TreeNode sublink(TreeNode T){
        TreeNode llast = T.left;  // llast是原来左子树链表化后的最后一个节点
        TreeNode subleft = T.left; // subleft是原来的左子树链表化的第一个节点
        if(T.left != null){
            subleft = sublink(T.left);
            llast = subleft;
            while(llast.right != null){
                llast = llast.right;
            }
            T.left = null;  //得到链表化的左子树后，根节点的左子树位置清空
        }
        TreeNode subright = T.right;  // subright是原来右子树链表化后的第一个节点
        if(T.right != null){
            subright = sublink(T.right);
            T.right = null;   // 原来根节点的右子树链表化并返回第一个节点后，根节点的右子树位置清空
        }

        // 判断左右单链表，如果左链表不存在，T直接拼接右链表；
        // 如果左链表存在，先拼接左链表，再拼接右链表
        if(subleft != null){
            T.right = subleft;
            llast.right = subright;
        }else{
            T.right = subright;
        }
        return T;
    }

}
