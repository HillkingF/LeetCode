package offer;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;

import java.util.ArrayList;

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
class test_41{

}
