package offer;
import java.util.ArrayList;

public class offer_57_2 {
    public int[][] findContinuousSequence(int target) {
        // 双指针滑动窗口
        int i = 1;
        int j = 2;
        int locsum = 1 + 2;
        ArrayList<int[]> list = new ArrayList<>();

        while( i < j && j <= target){
            if(locsum == target){
                // 先保存
                int[] tmp = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    tmp[k - i] = k;
                }
                list.add(tmp);
                // 更新j
                locsum += (++j);
            }else if(locsum > target){
                if(i + 1 < j){
                    locsum = locsum - i;
                    i = i + 1;
                }else break;
            }else{ // locsum < target
                locsum += (++j);
            }
        }

        int[][] res = new int[list.size()][];
        for(int m = 0; m < list.size(); m ++){
            res[m] = list.get(m);
        }
        return res;
    }
}

class test_57_2{
    public static void main(String[] args) {
        int target = 9;
        offer_57_2 test = new offer_57_2();
        int[][] res = test.findContinuousSequence(target);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.println(res[i][j]);
            }
            System.out.println();
        }
    }
}
