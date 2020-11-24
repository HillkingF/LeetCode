package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Simple_101_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    List<Integer> list = new ArrayList<>();
    TreeNode tmp = new TreeNode();

    while(!queue.isEmpty()){
        tmp = queue.poll();


    }


    }
}
