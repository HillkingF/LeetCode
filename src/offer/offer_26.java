package offer;

import java.util.ArrayDeque;
import java.util.Queue;

public class offer_26 {
    //public boolean isSubStructure111(TreeNode A, TreeNode B) {
    //    if(A == null || B == null) return false;
    //    // 如果使用层次遍历
    //    Queue<TreeNode> bigA = new ArrayDeque<>();
    //    Queue<TreeNode> smallA = new ArrayDeque<>();
    //    Queue<TreeNode> smallB = new ArrayDeque<>();
    //    bigA.add(A);
    //    TreeNode tmpA;  // 指向A队列出栈的节点
    //    TreeNode stmpA; // 指向smallA队列出栈的节点
    //    TreeNode stmpB; // 指向B出栈的节点
    //    int sign = 1;   // 1表示AB不满足要求,0表示AB满足要求
    //    int count = 0;
    //
    //    while(!bigA.isEmpty()){
    //        sign = 1;
    //        tmpA = bigA.poll();
    //        count += 1;
    //        if(tmpA.val == B.val){ // 说明A中的这个节点可能是B的开始
    //            System.out.println(count);
    //            smallA.clear();
    //            smallA.add(tmpA);
    //            smallB.clear();  // 先清空再入队
    //            smallB.add(B);
    //            sign = 0;
    //            while(!smallB.isEmpty()){ // 先判断B的子节点和A是否相同,再加入A中有的节点
    //                // 同时出队两个队列中每一个子树的头节点
    //                stmpA = smallA.poll();
    //                stmpB = smallB.poll();
    //                // 判断两个出队的节点是否相等
    //                if(stmpA.val == stmpB.val){
    //                    // 判断B出队节点的左子树是否存在
    //                    if(stmpB.left != null){
    //                        smallA.add(stmpA.left);
    //                        smallB.add(stmpB.left);
    //                    }
    //                    // 判断B右子树是否存在且和A右子树相等
    //                    if(stmpB.right != null){
    //                        smallA.add(stmpA.right);
    //                        smallB.add(stmpB.right);
    //                    }
    //                }else{ //两个节点不相等,说明节点值不相同
    //                    smallA.clear();
    //                    smallB.clear();  // 先清空再入队
    //                    sign = 1; // 说明不是遍历完的结束
    //                    break;
    //                }
    //            }
    //            if(sign == 0) return true;
    //        }
    //        if(A.left != null){ bigA.add(A.left); }
    //        if(A.right != null){ bigA.add(A.right); }
    //    }
    //    System.out.println(sign);
    //    if(sign == 1) return false;
    //    else return true;
    //
    //}

    public boolean isSubStructure(TreeNode A, TreeNode B) { // 不用存储,直接循环遍历
        if(A == null || B == null) return false;
        Queue<TreeNode> qa = new ArrayDeque<>();
        qa.add(A);
        TreeNode tmp ;
        boolean resleft;
        boolean resright;
        while(!qa.isEmpty()){
            tmp = qa.poll();
            if(tmp.val == B.val){
                resleft = subtree(tmp.left, B.left);
                resright = subtree(tmp.right,B.right);
                if(resleft && resright) return true;
            }
            if(tmp.left != null){ qa.add(tmp.left); }
            if(tmp.right != null){ qa.add(tmp.right); }
        }
        return false;
    }
    public boolean subtree(TreeNode A, TreeNode B){
        boolean resleft;
        boolean resright;
        if(B == null) return true;
        if(A != null && A.val == B.val){
            resleft = subtree(A.left,B.left);
            resright = subtree(A.left,B.left);
            if(resleft && resright) return true;
        }
        return false;
    }
}



 //Definition for a binary tree node.
//class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
// }

