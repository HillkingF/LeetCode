package offer;

import java.util.ArrayList;
import java.util.List;

public class offer_36 {
    // 二叉搜索树: 左子树的值 < 根节点的值 < 右子树的值

    // 递归找到每一个子树的最左/最右节点,
    // 令根的左子树指向左子树中最右边的那个节点,
    // 令根的右子树指向右子树中最左的那个节点

    public Node treeToDoublyList(Node root) {
        List<Node> res = subtree(root);
        if(res == null) return null;
        if(res.size() == 1){
            root.left = root;
            root.right = root;
            return root;
        }
        res.get(1).right = res.get(0);
        res.get(0).left = res.get(1);
        return res.get(0);
    }
    public List<Node> subtree(Node root){
        // 其中有两个元素,分别是最左和最右节点
        List<Node> res = new ArrayList<>();
        Node L, R;
        // 如果这个节点为空
        if(root == null) return null;
        // 如果这个节点为叶子节点: list中只有一个元素表示这个元素是叶子节点
        if(root.left == null && root.right == null){
            res.add(root);  // 当只有一个节点的时候,说明这个点是叶子节点
            return res;
        }
        // 如果这个点不为叶子节点: 找到这个点的左右子树中的最左和最右
        List<Node> subl = subtree(root.left);
        if(subl == null){
            // 说明root没有左子树
            L = root;
        }else{
            // 说明有左子树
            if(subl.size() == 1){
                // 说明左子树为叶子节点
                L = root.left;
                root.left.right = root;
            }else{
                // 说明返回的是左子树的最左和最右
                L = subl.get(0);
                subl.get(1).right = root;
                root.left = subl.get(1);
            }
        }
        res.add(L);

        // 右子树
        List<Node> subr = subtree(root.right);
        if(subr == null){
            // 说明没有右子树
            R = root;
        }else{
            // 说明有右子树
            if(subr.size() == 1){
                // 说明右子树是叶子节点
                R = root.right;
                root.right.left = root;
            }else{
                // 说明返回的是右子树的最左和最右
                R = subr.get(1);
                subr.get(0).left = root;
                root.right = subr.get(0);
            }
        }
        res.add(R);
        return res;
    }
}
