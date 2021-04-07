package Graph;

import java.util.*;

public class Medium_133_cloneGraph {

    public static void main(String[]  args){
        Node node = new Node(1);
        Node x = cloneGraph(node);

    }


    public static Node cloneGraph(Node node) {
        if(node == null) return null;
        // 定义一个全局的哈希表,用于存放每一个新创造的节点;节点根据唯一不重复的值
        HashMap<Integer, Node> map = new HashMap<>();

        // 传入原始节点和 状态表,返回 深copy节点
        Node x = DFS(node, map);
        return x;
    }


    public static Node DFS(Node node,HashMap<Integer, Node> map){
        /**
         * 如果传入的节点 无邻接点,则copy值创建对象并返回单节点
         * 如果这个节点在状态表中已经存在: 从map状态表中获取此节点并返回
         * 如果这是一个未被扫描的原节点:
         * - 首先创建一个新节点并 初始化值
         * - 在状态map中存放这个新节点
         * - 创建一个用于存放邻接节点的list. 然后遍历原节点的邻接节点:
         * ===== 邻接节点已经在map中存在,则直接从map邻接节点加入新的list
         * ===== 邻接节点不存在map中,则对这个邻接节点使用BFS进行深拷贝.BFS返回值是这个邻接节点深拷贝后的新节点
         *       将这个新节点也加入新list
         * ===== 原节点的所有邻接节点值都深拷贝并加入 新list后,完成这个原节点的拷贝
         * - 最后返回原节点
         */
        if(node.neighbors == null) return new Node(node.val);

        if(map.containsKey(node.val)){
            return map.get(node.val);
        }else{
            // 创建新节点
            Node newNode = new Node(node.val);
            // 存放到map状态表
            map.put(node.val, newNode);
            // 创建新的邻接表
            List<Node> newneb = new LinkedList<>();

            // 下面的操作是往新的邻接表更新copy后的邻接点
            for(Node n: node.neighbors){
                if(map.containsKey(n.val)){
                    newneb.add(map.get(n.val));
                }else{
                    Node x = DFS(n, map);
                    newneb.add(x);
                }
            }
            // 更新copy后节点的邻接表
            map.get(node.val).neighbors = newneb;
            // 返回copy后的新节点
            return newNode;
        }

    }
}



// 定义节点
class Node {
    public int val;  // 这个节点的值
    public List<Node> neighbors;  //这个节点邻居节点的序号列表
    public Node() {   // 没有值默认为0
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {  // 传递值时创建一个空的邻接列表
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
