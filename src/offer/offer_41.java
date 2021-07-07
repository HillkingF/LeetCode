package offer;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;
import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class offer_41 {
    // 创建一个数据流
    private ArrayList<Integer> datasrc;
    public offer_41() {
        datasrc = new ArrayList<>();
    }

    public void addNum(int num) {
        int i;
        for (i = 0; i < datasrc.size(); i++) {
            if(datasrc.get(i) >= num) break;
        }
        datasrc.add(i, num);
    }

    public double findMedian() {
        int size = datasrc.size();
        if(size == 0){
            return 0.0;
        }else if(size%2 == 0){
            return (datasrc.get(size/2) + datasrc.get(size/2 -1) + 0.0)/2;
        }else{
            return (datasrc.get(size/2));
        }
    }
}


// 第二遍做:使用优先队列(原理是堆)
class offer_41_method2{
    // 创建两个优先队列:
    // A存储升序数列中后半部分,是一个小根堆
    // B存储升序数列中前半部分,是一个大根堆
    // A的堆顶是后半部分中的最小数字
    // B的堆顶是前半部分中的最大数字
    // 所以中位数就是两个堆顶的相关值
    // 注意:必须保持A的个数始终 >=B的个数
    private PriorityQueue<Integer> A;
    private PriorityQueue<Integer> B;

    /** initialize your data structure here. */
    public offer_41_method2() {
        A = new PriorityQueue<>();
        B = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        // 根据A和B中的元素个数,判断新元素应该放到哪一个堆中
        int sizeA = A.size();
        int sizeB = B.size();

        if(sizeA <= sizeB){// 若 A中的元素个数小于B中的元素个数: 那么最终的元素个数应该进入A队列
            // 首先将新元素加入B,然后将B的新堆顶(B中的最大)放入A
            // 此时A和B中的堆顶可能是此时的中位数
            B.add(num);
            A.add(B.poll());

        }else{ // 若A中的元素个数大于B中的元素个数, 那么新元素应该最终进入B队列
            // 首先将新元素加入A,然后将A的新堆顶(A中的最小)放入B
            // 此时A和B中的堆顶可能是此时的中位数
            A.add(num);
            B.add(A.poll());
        }
    }

    public double findMedian() {
        int sizeA = A.size();
        int sizeB = B.size();
        int count = sizeA + sizeB;

        if(count == 0) return 0.0;
        return count % 2 == 0? (A.peek() + B.peek())/2.0 : A.peek() + 0.0;
    }


}
