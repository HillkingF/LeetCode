package Tree;

import java.util.*;

// 新用法：队列和栈也可以直接变成列表
// 这道题不会，直接参考的答案
// 深度优先遍历也不太会，多做一些题看看

public class Medium_113_pathSum {
    List<List<Integer>> outer = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root,sum);
        return outer;
    }
    public void dfs(TreeNode root, int sum){
        if(root == null){
            return ;
        }
        stack.push(root.val);
        sum -= root.val;
        if(root.left == null && root.right == null){
            if(sum == 0){
                outer.add(new LinkedList<Integer>(stack));
            }
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        stack.pop();
    }



}
