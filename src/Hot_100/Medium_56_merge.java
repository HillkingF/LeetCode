package Hot_100;


import java.util.ArrayList;
import java.util.List;

public class Medium_56_merge {
    public static void main(String[] args){
        int[][] a = new int[4][];
        int[] b = {1,3};
        int[] c = {2,6};
        int[] d = {8,10};
        int[] e = {15,18};
        a[0] = b;
        a[1] = d;
        a[2] = c;
        a[3] = e;
        int[][] res = merge(a);
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 2; j++){
                System.out.println(res[i][j]);
            }

        }

    }

    /**
     * 先对每一组第一个数字按从小到大排序，
     * 然后再合并区间。
     * 比较慢，想想别的优化方法
     */
    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if(intervals.length == 0 || intervals.length == 1) return intervals;
        // 按照第一位排序
        for(int i = 0; i < intervals.length; i++){
            int minloc = i;
            for(int j = i + 1; j < intervals.length; j++){
                if(intervals[j][0] < intervals[minloc][0]) minloc = j;
            }
            int[] tmp = intervals[i];
            intervals[i] = intervals[minloc];
            intervals[minloc] = tmp;
        }
        List<int[]> list = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++){
            for(int j = 0; j < i; j++){
                if(intervals[j][0] != -1){
                    if(intervals[j][0] <= intervals[i][0] && intervals[i][0] <= intervals[j][1] && intervals[j][1] <= intervals[i][1]){
                        intervals[j][1] = intervals[i][1];
                        intervals[i][0] = -1;
                        intervals[i][1] = -1;
                        len --;
                    }else if(intervals[j][0] <= intervals[i][0] && intervals[i][1] <= intervals[j][1]){
                        intervals[i][0] = -1;
                        intervals[i][1] = -1;
                        len --;
                    }
                }
            }

        }
        int[][] res = new int[len][2];
        int index = 0;
        for(int i = 0; i < intervals.length; i++){
            if(intervals[i][0] != -1){
                res[index][0] = intervals[i][0];
                res[index][1] = intervals[i][1];
                index ++;
            }
        }
        return res;



    }
}
