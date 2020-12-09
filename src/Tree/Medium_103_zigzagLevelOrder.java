package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Medium_103_zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> outer = new LinkedList<>();
        if(root == null) return outer;

        // 初始化
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.add(root);
        int len = 1;
        while(!queue.isEmpty()){
            List<Integer> inner = new LinkedList<>();
            int size = queue.size();
            if(len%2==0){  // 说明这一层需要逆向
                while(size > 0){
                    TreeNode tmp = queue.poll();
                    if(tmp.left != null) queue.add(tmp.left);
                    if(tmp.right != null) queue.add(tmp.right);
                    inner.add(stack.pop().val);
                    size--;
                }
                outer.add(inner);
            }else{  // 说明这一层需要正向读取
                while(size > 0){
                    TreeNode tmp = queue.poll();
                    inner.add(tmp.val);
                    size--;
                    if(tmp.left != null){
                        queue.add(tmp.left);
                        stack.push(tmp.left);
                    }
                    if(tmp.right != null){
                        queue.add(tmp.right);
                        stack.push(tmp.right);
                    }
                }
                outer.add(inner);
            }
            len++;
        }

        return outer;
    }
}
