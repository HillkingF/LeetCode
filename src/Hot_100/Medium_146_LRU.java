package Hot_100;

import java.util.ArrayDeque;
import java.util.Queue;


//下面的时间复杂度和空间复杂度不满足，如何改进：试试双向链表？
public class Medium_146_LRU {
    private int capacity;
    private int[] keyarr;
    private int[] valuearr;
    Queue<Integer> queue = new ArrayDeque<>();
    private int lindex;
    int cache = -1;

    public Medium_146_LRU(int capacity) {
        this.capacity = capacity;
        keyarr = new int[capacity];
        valuearr = new int[capacity];
        for(int i = 0; i < capacity; i++){
            keyarr[i] = -1;
            valuearr[i] = -1;
        }
    }
    public int get(int key) {
        int index = 0;  // 修改队列排序
        int value = 0;  // 返回值
        int size = queue.size();
        int i = 0;
        for(i = 0; i < keyarr.length; i++){
            if(keyarr[i] == key){
                index = i;
                lindex = i;
                value = valuearr[i];
                break;
            }
        }
        if(i == keyarr.length){
            return -1;
        }

        // 修改队列的排序
        for(int j = 0; j < size; j++){
            int x = queue.poll();
            if(x == index){
            }else{
                queue.add(x);
            }
        }
        queue.add(index);
        return value;
    }

    public void put(int key, int value) {
        int x = get(key);
        if(x != -1){ /// 说明cunzai
            valuearr[lindex] = value;
        }else{
            int size = queue.size();
            if(size == capacity){  //说明满了
                int loc = queue.poll();
                keyarr[loc] = key;
                valuearr[loc] = value;
                queue.add(loc);
            }else{
                cache ++;
                keyarr[cache] = key;
                valuearr[cache] = value;
                queue.add(cache);
            }
        }

    }


}

