package Graph;

import java.util.*;

public class Medium_332_findItinerary {

}

class solve332{
    private List<String> resmap;

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

        // 先对map中的value进行排序
        for(String start: map.keySet()){
            Collections.sort(map.get(start));
        }
        for(String str: map.keySet()){
            System.out.println(str);
            System.out.println(map.get(str));
        }

        // 下面将第一个出发地 JFK传入遍历
        List<String> res = DFS("","JFK", map);
        Collections.reverse(res);
        return res;


    }

    public List<String> DFS(String lastStart, String start, HashMap<String, List<String>> orimap){
        HashMap<String, List<String>> map = new HashMap<>();
        map.putAll(orimap);  // 深拷贝
        if(lastStart.equals("")){

        }else{
            map.get(lastStart).remove(start);
            if(map.get(lastStart).isEmpty()){      // 此时如果start没有邻接节点,则从图中删除
                map.remove(lastStart);
            }
        }



        List<String> res = new ArrayList<>();

        if(!map.containsKey(start)){  // 说明是最后一个目的地了:需要判断
            if(map.isEmpty()){
                res.add(start);
            }
            return res;

        }

        // start还有邻接节点: 选择其中最小的那个
        Collections.sort(map.get(start));  // 对start的邻接列表排序
        for(int i = 0; i < map.get(start).size(); i++){
            String nextstart = map.get(start).get(i);  // 获取邻接列表最小的那个
            List<String> nextres = DFS(start, nextstart, map);
            if(nextres.isEmpty()){
            }else{
                nextres.add(start);
                res = nextres;
                break;
            }
        }

        return res;




    }

}
