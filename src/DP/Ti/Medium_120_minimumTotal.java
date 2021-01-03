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

        List<Integer> tmplist1 = new ArrayList<>();
        List<Integer> tmplist2 = new ArrayList<>();

        int sign = 1; // 1 的时候，用tmplist1来记录前一层的输出，-1的时候用tmplist2记录输出
        tmplist1.add(triangle.get(0).get(0));  // 初始化直接放入三角形第一层中的第一个元素
        int tmpsum = 0;

        for(int ceng = 1; ceng < triangle.size(); ceng++){// 遍历三角形中的每一层, 直接从第一层开始
            List<Integer> inner = triangle.get(ceng);

            // 置空用来存储的列表
            if(sign == 1)tmplist2.clear(); // 初始：第0层、tmplist1存储、sign=1，该用tmplist2存储了
            else tmplist1.clear();
            for(int a: tmplist1){
                System.out.println(a);
            }

            // 遍历层中每一个，并计算 每一个数字 对应的上一层的最小路径
            for(int eachnum = 0; eachnum < inner.size(); eachnum++){ // 遍历一层中的每一个
                if(sign == 1){ // 使用tmplist2存储, 从tmplist1获取
                    if(eachnum == 0){
                        tmplist2.add(tmplist1.get(eachnum) + inner.get(eachnum));
                    }else if(eachnum == inner.size()-1){
                        tmplist2.add(tmplist1.get(eachnum - 1) + inner.get(eachnum));
                    }else{
                        tmpsum = tmplist1.get(eachnum) < tmplist1.get(eachnum - 1) ?
                                tmplist1.get(eachnum): tmplist1.get(eachnum - 1);
                        tmpsum += inner.get(eachnum);
                        tmplist2.add(tmpsum);
                    }
                }else{// 使用tmplist1存储, 从tmplist2获取
                    if(eachnum == 0){
                        tmplist1.add(tmplist2.get(0) + inner.get(0));
                    }else if(eachnum == inner.size()-1){
                        tmplist1.add(tmplist2.get(eachnum - 1) + inner.get(eachnum));
                    }else{
                        tmpsum = tmplist2.get(eachnum) < tmplist2.get(eachnum - 1) ?
                                tmplist2.get(eachnum): tmplist2.get(eachnum - 1);
                        tmpsum += inner.get(eachnum);
                        tmplist1.add(tmpsum);
                    }
                }
            }
            sign = sign * (-1);
        }

        int min = Integer.MAX_VALUE;
        if(sign == -1){
            for(int x: tmplist2){
                if(x < min) min = x;
            }
        }
        else{
            for(int t: tmplist1){
                if(t < min)min = t;
            }
        }
        return min;
    }
}
