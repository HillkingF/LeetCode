package offer;

import javax.swing.*;

public class offer_33 {
    /**
     * 二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）
     * 左子树值 <= 根 <= 右子树值
     * 所以数组的最后一个元素一定是这棵树的根,
     * 从左侧开始一定有一段范围内元素是小于根元素的大小,而剩余的元素一定大于根元素的大小
     * 默认左子树要么为空,要么一定有节点
     * 而剩余元素理论上应该大于根,如果出现小于根,
     * 则这棵树不是二叉搜索树
     * 找到左右子树后,递归遍历判断左右子树是不是二叉搜索树即可
     */

    public boolean verifyPostorder(int[] postorder) {
        if(postorder == null || postorder.length < 2) return true;
        return verify(postorder, 0, postorder.length - 1);
    }


    public boolean verify(int[] postorder, int start, int end) {
        if( start == end) return true;
        // 1.确定这棵树根节点的位置: 一定是这一组数的最后一个
        int root = postorder[end];
        boolean left = true;
        boolean right = true;
        // 2. 找到左子树 和 右子树,并判断左子树是否小于树根,递归判断这一课树是不是小于树根
        int lend;
        for (lend = start; lend < end; lend++) {
            if(postorder[lend] < root){
            }else{
                break;
            }
        }
        if(lend == start) {
            left = true;
        }else{
            left = verify(postorder, start, lend-1);
        }
        // 3.判断右子树是否存在,并递归遍历右子树
        int rend;
        for (rend = lend; rend < end; rend++) {
            if(postorder[rend] > root){
            }else{  // 如果在右子树的位置中有小于树根的,那么一定不是二叉搜索树的后续排序
                return false;
            }
        }
        if(rend == lend){
            right = true;
        }else{
            right = verify(postorder, lend, rend-1);
        }
        // 4. 联合判断左右子树是否也是二叉搜索树
        return left && right;
    }
}
