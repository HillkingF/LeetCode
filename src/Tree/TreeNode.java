package Tree;

import java.util.Stack;

public class TreeNode {  // 定义一棵二叉树
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

class pre_definetree{
//    public static void main(String[] args){
//        int[] nums = {1, 2, 3};
//        TreeNode t = def(nums);
//    }
    // 前序初始化一棵树
    public  TreeNode def(int[] nums){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode T = new TreeNode();
        TreeNode root = T;
        if(nums.length == 0) {
            return T;
        }

        for(int i=0; i< nums.length; i++){
            if(i == 0){
                T.val = nums[0];
                T.right = null;
                T.left = null;
                stack.push(T);
            }else{
                int num = nums[i];
                if(num > -1 && nums[i-1] != -1) {
                    TreeNode treeNode = new TreeNode();
                    treeNode.val = num;
                    treeNode.left = null;
                    treeNode.right = null;
                    T.left = treeNode;
                    T = T.left;
                    stack.push(treeNode);
                }else if(num > -1 && nums[i-1] == -1) {
                    TreeNode treeNode = new TreeNode();
                    treeNode.val = num;
                    treeNode.left = null;
                    treeNode.right = null;
                    T.right = treeNode;
                    T = T.right;
                    stack.push(treeNode);
                } else {
                    T = stack.pop();
                }
            }
        }
        return root;
    }
}
