package DP.Ti;

import java.util.ArrayList;
import java.util.List;

public class Medium_120_minimumTotal {
    public static void main(String[] args){
        List<Integer> i1 = new ArrayList<>();
        i1.add(2);
        List<Integer> i2 = new ArrayList<>();
        i2.add(3);
        i2.add(4);
        List<Integer> i3 = new ArrayList<>();
        i3.add(6);
        i3.add(5);
        i3.add(7);
        List<Integer> i4 = new ArrayList<>();
        i4.add(4);
        i4.add(1);
        i4.add(8);
        i4.add(3);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(i1);
        triangle.add(i2);
        triangle.add(i3);
        triangle.add(i4);
        int x = minimumTotal(triangle);
        System.out.print(x);


    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        /*
        思路：
        从第一层开始计算每一层的路径和，
        直到最后一层，取结果的最小值

        由于题目中给定的是三角形状的列表，所以后一层总比前一层多一个数值
        */
        if(triangle.size() == 1) return triangle.get(0).get(0);
        List<Integer> pri = new ArrayList<>();
        pri.add(triangle.get(0).get(0));
        int min = Integer.MAX_VALUE;
        for(int ceng = 1; ceng < triangle.size(); ceng++){// 遍历三角形中的每一层, 直接从第一层开始
            List<Integer> inner = triangle.get(ceng);
            pri = compute(pri, triangle.get(ceng));
            if(ceng == triangle.size()-1)
                min = pri.stream().min((i1, i2) -> i1.compareTo(i2)).get();// 获取列表中的最小数值
        }
        return min;
    }
    public static List<Integer> compute(List<Integer> pri, List<Integer> inner){
        List<Integer> later = new ArrayList<>();
        int tmp;
        for(int eachnum = 0; eachnum < inner.size(); eachnum++) { // 遍历一层中的每一个
            if (eachnum == 0) tmp = pri.get(eachnum);
            else if (eachnum == inner.size() - 1)tmp = pri.get(eachnum - 1);
            else tmp = pri.get(eachnum) < pri.get(eachnum - 1) ? pri.get(eachnum) : pri.get(eachnum - 1);
            later.add(tmp + inner.get(eachnum));
        }
        return later;
    }
}
