package Tree;

import java.util.*;

public class Simple_107_levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        /**
         * 思路，类似于104题的迭代法，使用sum 来记录队列中每一层的节点个数
         */
        List<List<Integer>> outer = new ArrayList<>();
        if(root == null)return outer;

        Queue<TreeNode> queue =  new LinkedList<>(); // 用来存放每一个节点
        Stack<List<Integer>> stack = new Stack<>();  // 从根到叶子，存放每一层的节点值
        queue.add(root);  // 此时根一定不为null，先入队，进行初始化
        while(!queue.isEmpty()){
            int sum = queue.size(); //每一轮开始时，sum都是一层节点数总和
            List<Integer> in = new ArrayList<>();  //用于存放那个每一层的节点数值
            while(sum > 0){   //当这一层节点没有全部出队时进入内部循环
                TreeNode tmp = queue.poll();  //依次出队本层的某个节点，同时，如果出队的节点有子节点直接入队
                if(tmp.left != null) queue.add(tmp.left);
                if(tmp.right != null) queue.add(tmp.right);
                in.add(tmp.val);   //将出队节点的数值放入内部列表
                sum --;
            }
            stack.push(in);   // 一层遍历结束，将内部列表入栈
        }
        while (!stack.isEmpty()){  //当队列为空且栈不为空时，依次出栈，顺序就是从叶子到根节点
            outer.add(stack.pop());
        }
        return outer;



    }
}
