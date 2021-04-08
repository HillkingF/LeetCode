package Graph;

import java.util.*;

public class Medium_310_findMinHeightTrees {
    public static void main(String[] args) {
        int n = 2;
        int[][] edges = {{1,0}};
        List<Integer> x = findMinHeightTrees(n, edges);
        System.out.println(x);

    }


    // 第一种方法:  用下面深度优先搜索的方法可以得出答案,但是leetcode上超出了时间限制
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 首先还是根据边构造图节点的邻接表
        // 表中每一个索引表示一个节点的编号
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> zu = new ArrayList<>();
            graph.add(zu);
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }


        // 确定了根节点,就确定了树的形状.因此只要记录每一棵树的深度就可以了.并最终选择深度最小的树组
        // 找到树根,就相当于找到了一个初始遍历的图节点,之后使用bfs或者dfs遍历即可
        // 难点:如何实时更新树的深度.回溯,BFS
        int len = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();    // 树高是key, 树根是value
        int mintree = Integer.MAX_VALUE;


        for (int i = 0; i < n; i++) {
            System.out.println(graph);

            List<Integer> visit = new ArrayList<>();
            len = DFS(i, graph, 0, visit);
            // System.out.println(len);
            // System.out.println(visit);
            if (len <= mintree) {
                mintree = len;
                if (map.containsKey(len)) {
                    map.get(len).add(i);
                } else {
                    ArrayList<Integer> roots = new ArrayList<>();
                    roots.add(i);
                    map.put(len, roots);
                }
            }
        }
        return map.get(mintree);

    }

    public static int DFS(Integer root, List<List<Integer>> graph, int deep, List<Integer> visit) {  // deep初始=0,高度看边数,不看点数

        visit.add(root);  // 0
        int maxedges = deep;
        for (int node : graph.get(root)) {
            if (visit.contains(node)) continue;
            int pathedges = DFS(node, graph, deep + 1, visit);
            if (pathedges >= maxedges) {
                maxedges = pathedges;
            }
        }

        return maxedges;   // 返回最大的边数

    }


    // 第二中方法:  因此用下面广度优先搜索的方法来,也会超出时间限制
    public static List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        // 创建图{图节点的邻接表}
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> zu = new ArrayList<>();
            graph.add(zu);
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        HashMap<Integer, List<Integer>> res = new HashMap<>();
        int minlen = Integer.MAX_VALUE;
        // 对每一个根节点
        for (int i = 0; i < n; i++) {
            List<List<Integer>> graph1 = new ArrayList<>();
            graph1.addAll(graph);

            int len = 0;
            // 创建一个队列用于之后访问
            Queue<Integer> queue = new LinkedList<>();
            // 创建一个已经访问的列表
            List<Integer> visit = new ArrayList<>();
            // 初始化:将根节点放入队列
            queue.add(i);
            // 如果队列不为空
            while (!queue.isEmpty()) {
                // 首先记录即将要访问的层的节点个数
                int size = queue.size();
                while (size > 0) {  // 每一轮循环出队一层的全部节点
                    int node = queue.poll();
                    visit.add(node);
                    // 将出队的节点的邻接点(未访问的)全部入队
                    for (int subnode : graph.get(node)) {
                        if (visit.contains(subnode)) continue;
                        else {
                            queue.add(subnode);
                        }
                    }



                    size = size - 1;
                }
                len = len + 1;
            }

            // 判断root树的深度是不是最小的
            if(len <= minlen){
                if(res.containsKey(len)){
                    res.get(len).add(i);
                }else{
                    List<Integer> lst = new ArrayList<>();
                    lst.add(i);
                    res.put(len, lst);
                }
                minlen = len;
            }
        }
        return res.get(minlen);


    }


    // 第三种方法: 结合最小高度树的性质和BFS来解决
    public List<Integer> findMinHeightTrees3(int n, int[][] edges) {
        // 只有一个点时,这个点肯定是最小高度树的根节点
        if(n == 1) {
            List<Integer> ress = new ArrayList<>();
            ress.add(0);
            return ress;
        }
        // 首先定义图的邻接表和 图节点的出度表
        List<List<Integer>> graph = new ArrayList<>();
        int[] outdu = new int[n];
        // 初始化两个表
        for(int i= 0; i < n; i++){
            graph.add(new ArrayList<>());
            outdu[i] = 0;
        }
        // 创建图
        for(int[] edge: edges){
            // 两个点的出度都加1
            outdu[edge[0]]++;
            outdu[edge[1]]++;
            //邻接表
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // 创建每一轮删除的点集
        List<Integer> res = new ArrayList<>();
        // 创建一个队列用于存放出度为1的节点
        Queue<Integer> queue = new LinkedList<>();
        // 初始化队列,将所有出度为1的叶子节点先加入队列
        for(int i = 0; i < n; i++){
            if(outdu[i] == 1){
                queue.add(i);
            }
        }
        // 循环遍历队列,每次从队列中取出一圈叶子节点,加入结果点集,最后一圈出队的就是最终结果
        while(!queue.isEmpty()){
            // 初始化结果点集,队列大小(每一轮队列的大小就是剩余图中叶子节点的个数)
            res = new ArrayList<>();
            int size = queue.size();
            while(size > 0){
                // 逐个删除队列中本层的叶子节点
                size--;
                int node = queue.poll();
                // 将删除的节点加入结果点集
                res.add(node);
                // 删除相邻节点的出度, 并且将更新后的出度为1的相邻节点加入队列
                for(int subnode: graph.get(node)){
                    outdu[subnode]--;
                    if(outdu[subnode] == 1){
                        queue.add(subnode);
                    }
                }
            }
        }
        return res;


    }
}