package Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Medium_207_canFinish {
    /*
    分析:
    判断有向图是否有环
     */

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 首先定义一个hashmap用来描述图(节点及邻接表)
        // 定义一个数组来记录节点的入度(节点从0-n唯一,所以可以用数组)
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] indu = new int[numCourses];

        // 初始化map和入度表
        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
            indu[i] = 0;
        }
        // 构建图的邻接表和入度表
        for(int[] zu: prerequisites){  // zu[后,前]
           map.get(zu[1]).add(zu[0]);
           indu[zu[1]] = indu[zu[1]] + 1;
        }


        // 使用BFS和DFS删除入度
        // BFS使用队列 , DFS 递归
        // 依次遍历点:如果

    }
    public void DFS( HashMap<Integer, ArrayList<Integer>> map, int[] indu){  // 深度优先
        

    }
}
