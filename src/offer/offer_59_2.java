package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class offer_59_2 {
    public static void main(String[] args) {

    }
}



// 维持两个队列:
// 一个正常队列 + 一个双端辅助队列(使用了list实现)
// list 第0个元素始终为现有队列中的最大元素
// 当新数值 要入队列时: 首先跟list最后一个元素比较,如果小于最后一个 直接进入辅助队列;
// 如果新数值 一直大于 最后一个,则就一直删除最后一个元素;
// 直到新数值比list最后一个小或等于
// 也就是说辅助队列中始终是一个递减队列
// 当要出队时,如果正常队列中的出队值小于 辅助队列第0个元素,则pass
// 当等于时 ,两个队列一起出队
class MaxQueue {
    private Queue<Integer> queue;
    private ArrayList<Integer> help = new ArrayList<>();
    int size;

    public MaxQueue() {
        queue = new LinkedList<>();
        help = new ArrayList<>();
        size = 0;
    }

    public int max_value() {
        if(queue.isEmpty()) return -1;
        else{
            return help.get(0);
        }
    }

    public void push_back(int value) {
        // 比较最大值，然后入队列
        if(queue.isEmpty()){
            queue.add(value);
            help.add(value);

        }else{
            queue.add(value);
            while(help.size() > 0){
                size = help.size()-1;
                if(help.get(size) > value){
                    help.add(value);
                    break;
                }else if(help.get(size) == value ){
                    help.add(value);
                    break;
                }else{
                    if(help.get(size) < value){
                        help.remove(size);
                    }
                }
            }
            if(help.size() == 0){
                help.add(value);
            }
        }
    }

    public int pop_front() {
        if(queue.isEmpty()) return -1;
        else{
            int res = queue.poll();
            if(res == help.get(0)){
                help.remove(0);
            }
            return res;
        }

    }
}
