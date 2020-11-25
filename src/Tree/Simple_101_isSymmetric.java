package Tree;

import java.util.*;

public class Simple_101_isSymmetric {
    public static void main(String[] args){
        //[1,2,2,null,3,null,3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        boolean res = isSymmetric(root);
        System.out.print(res);

    }

    // 递归的写法，初始化时令p，q分别为root，之后作为两个子树同步比较，p的左子树只能和q的右子树比较；p的右子树只能和q的左子树比较
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        TreeNode p = root;
        TreeNode q = root;
        return compare2tree(p, q);
    }

    public static boolean compare2tree(TreeNode a, TreeNode b){
        if(a == null && b == null) return true;
        if(a!= null && b != null){
            boolean res = false;
            if(a.val != b.val) return res;
            if(compare2tree(a.left, b.right) == true && compare2tree(a.right, b.left) == true){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    /**
     *迭代的写法:（迭代就是一次次循环，递归是调用方法自己）
     * 创建一个队列是从递归变成迭代的常用手段
     * 思路：
     * 首先将根节点两次入队。下面开始循环：
     * 每一轮出队两次，先出队的给p，后出队的给q；
     * p的左子树和p的右子树比较；p的右子树和q的左子树比较：
     * 先比较p和q两个点的值，不相同直接返回false；相同继续下面的步骤：
     * 当p和q左右分别有子树的时候同时入队；当p和q只有其中一个有子树则返回false；当两个都分别没有左右子树则返回while的下一轮；
     * 直到最后队列空，说明都对称，返回true
     */
    public static boolean iter(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return true;
        queue.add(root);
        queue.add(root);
        TreeNode p = new TreeNode();
        TreeNode q = new TreeNode();

        while(!queue.isEmpty()){
            p = queue.poll();
            q = queue.poll();
            if(p.val != q.val){
                return false;
            }

            if(p.left != null && q.right != null){
                queue.add(p.left);
                queue.add(q.right);
            }
            if(p.right != null && q.left != null){
                queue.add(p.right);
                queue.add(q.left);
            }
            if((p.left!=null&&q.right==null)|| (p.left==null && q.right!= null)){
                return false;
            }
        }
        return true;
    }

}
