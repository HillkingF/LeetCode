package Graph;

import java.util.*;

public class Medium_210_findOrder {
    // 这道题的思路跟207题一样,但是需要记录每次删除课程的编号
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        /*
        [知识点]
        拓扑排序
        广度优先搜索
        hashmap或者队列
        入度表
        [解题思路]
        1.首先构建一张图和一个所有节点的入度表
        2.每次从入度表中找到入度为0的点进行删除,并将其邻接点的入度减1
         */

        // 构建邻接表和入度表
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int[] indu = new int[numCourses];
        for(int i = 0; i < numCourses; i++){  // 初始化
            map.put(i, new ArrayList<>());
            indu[i] = 0;
        }
        // 构建删除路径数组
        int i = 0;
        int[] seq = new int[numCourses];
        // 构建图
        for(int[] dui: prerequisites){
            map.get(dui[1]).add(dui[0]);
            indu[dui[0]] = indu[dui[0]] + 1;
        }

        // 初始化:将入度为0的点放到队列中
        Queue<Integer> queue = new LinkedList<>();
        for(int x: map.keySet()){
            if(indu[x] == 0){
                queue.add(x);
            }
        }
        // 如果初始化的时候,就没有一个节点的入度为0,说明已经存在环了,直接返回空数组
        if(queue.isEmpty()) return new int[0];

        // 否则队列中全是入度为0的点;每次出队一个入度=0的点.将这个点加入结果数组
        // 将出队的这个点的邻接点中所有 入度为0的点继续入队列,并循环.
        // 当队列中没有入度为0的点时,判断入度表中,是否全部为0.如果不为0则返回空数组
        while(!queue.isEmpty()){
            int x = queue.poll();
            seq[i] = x;
            i = i + 1;
            for(int lin: map.get(x)){
                indu[lin] = indu[lin] - 1;
                if(indu[lin]==0){
                    queue.add(lin);
                }
            }
        }
        for(int index = 0; index < numCourses; index++){
            if(indu[index] != 0){
                return new int[0];
            }
        }
        return seq;


    }
}
