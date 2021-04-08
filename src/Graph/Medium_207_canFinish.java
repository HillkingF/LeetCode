package Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Medium_207_canFinish {
    /*
    分析:
    拓扑排序
    判断有向图是否有环
     */

    /*
    [构建图]:
        使用 HashMap<Integer, ArrayList<Integer>> 来记录图节点及其邻接节点(邻接列表是x课程选择后可以选的课程)
        使用 int[] indu 来记录每一门课程对应的入度(入度:具体只上一门必须选择的课程)
    [删除入度为0的节点: 拓扑排序,就是就是广度优先遍历的思想]
        map中存放了所有的节点,indu中存放了所有节点的入度值
        当map不等于空,说明还有课程不能上.下面进行如下步骤循环
        - 1.记录初始map中的节点个数
        - 2.从map中的节点中循环找入度为0的节点:将其邻接节点的入度分别减1
        - 3.将一轮中所有入度为0的点加入 delet表.并在map一轮遍历结束后删除delet表中所有的节点
        - 4.重新统计map中的节点值:
            - 如果跟初始节点值相同:说明没有入度为0的点,图中有环,直接返回false
            - 否则开始下一轮循环:重复1-4的步骤
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
           indu[zu[0]] = indu[zu[0]] + 1;
        }

        // 循环遍历依次删除入度为0的节点,看最后map中是否有剩余节点
        while(!map.isEmpty()){
            ArrayList<Integer> delet = new ArrayList<>();
            int size = map.size();
            for(int x: map.keySet()){   // 遍历字典获取节点值 x
                if(indu[x] == 0){  // 如果某个节点的入度为0,则删除这个节点并将其邻接节点的入度都-1
                    for(Integer i : map.get(x)){
                        indu[i] = indu[i] - 1;
                    }
                    delet.add(x);
                }
            }
            for(int x : delet){
                map.remove(x);
            }
            int newsize = map.size();
            if(size == newsize){
                return false;
            }
        }
        return true;

        
    }
    public void DFS( HashMap<Integer, ArrayList<Integer>> map, int[] indu){  // 深度优先

        

    }
}
