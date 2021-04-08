package Graph;

import java.util.*;

public class Medium_332_findItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        // 总有一个开始 JFK,总有一个结束,结束时map中再不包含任何键值对

        // 首先: 创建有向图的邻接表   key:出发地  value: 直飞可以到达的目的地. 这个图可以有环也可以无环
        HashMap<String, List<String>> map = new HashMap<>();
        // 然后:创建节点的出度和入度表
        // 每个行程只能用一次: 说明访问过的节点不能再访问了
        // 无向图的出度等于入度, 而有向图的节点出度不一定等于入度.这里先全部写出来
        HashMap<String, Integer> indu = new HashMap<>();
        HashMap<String, Integer> outdu = new HashMap<>();
        // 对邻接表/出度表/入度表进行初始化
        for(List<String> onefly: tickets){
            if(map.containsKey(onefly.get(0))){
                map.get(onefly.get(0)).add(onefly.get(1));
                outdu.put(onefly.get(0), outdu.get(onefly.get(0)) + 1);
            }else{
                List<String> lst = new ArrayList<>();
                lst.add(onefly.get(1));
                map.put(onefly.get(0), lst);
                outdu.put(onefly.get(0), 1);
            }
            if(indu.containsKey(onefly.get(1))){
                indu.put(onefly.get(1), indu.get(onefly.get(1))+1);
            }else{
                indu.put(onefly.get(1), 1);
            }
        }

        // 存放结果序列的 列表
        List<String> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        // 队列初始化
        queue.add("JFK");
        while(!queue.isEmpty()){

            // 队列不为空出队
            String next = queue.poll();
            res.add(next);


            // 队列为空:开始下一组循环或者直接结束? 看题目要求了:是不是连通
            if(queue.isEmpty()){

            }
        }

    }
}
