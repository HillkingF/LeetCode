package Tree;

import java.util.List;
import java.util.Queue;

public class Simple_108_sortedArrayToBST {
    /**
     * 【题目】
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     * 本题中一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     */
    public static void main(String[] args){
        int[] nums = {-10, -3, 0, 5, 9}; //, 0
        TreeNode tree = sortedArrayToBST(nums);
        Simple_107_levelOrderBottom c = new Simple_107_levelOrderBottom();
        List<List<Integer>> x = c.levelOrderBottom(tree);
        for(List<Integer> list: x){
            System.out.println(list);
        }

    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        int len = nums.length;

        int mid = (nums.length-1)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root = binaryT(nums, 0, mid-1, mid, root);
        root = binaryT(nums, mid+1, nums.length-1,mid, root);
        return root;



    }
    // start 和 finish 都是坐标索引，不是长度
    public static TreeNode binaryT(int[] nums, int start, int finish, int mid,TreeNode root){
        


    }
}
