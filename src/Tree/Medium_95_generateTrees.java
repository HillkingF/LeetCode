package Tree;

import java.util.LinkedList;
import java.util.List;

public class Medium_95_generateTrees {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new LinkedList<>();
        return subtrees(1, n);

    }

    /**
     * 这道题的思路参考官方题解，重点理解 左右子树集合的构成、枚举以及最后的组合拼接
     */
    public List<TreeNode> subtrees(int start, int end){
        List<TreeNode> allsubtrees = new LinkedList<>();
        if(start > end){
            allsubtrees.add(null);
            return allsubtrees;
        }
        for(int i = start;i <= end; i++){

            // 以i为根节点，下面两个列表分别用来存储所有可能的左右子树
            List<TreeNode> leftlist = subtrees(start, i - 1);
            List<TreeNode> rightlist = subtrees(i + 1, end);

            for(TreeNode tl: leftlist){
                for(TreeNode tr: rightlist){
                    TreeNode t = new TreeNode(i);
                    t.left = tl;
                    t.right = tr;
                    allsubtrees.add(t);
                }
            }
        }
        return allsubtrees;
    }
}
