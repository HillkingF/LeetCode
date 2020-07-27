package Array;

import java.util.List;

class Simple_118_YangHuiTriangle {
    public static void main(String[] args){

    }
}
//class Solution {
//    public List<List<Integer>> generate(int numRows) {
//        // numRows 给出了杨辉三角形的层数，每一层最边上的左右两个数字是1，每一层其余数字是上一层两个相邻的数字之和
//        List<List<Integer>> outlist =  List<List<Integer>>[numRows];
//        List<Integer> inlist;
//        for (int i = 1; i <= numRows; i++){
//            // 初始化每一层最边上两个数
//            inlist = null;
//            inlist[0] = 1;
//            inlist[i - 1] = 1;
//
//            // 从第2层开始（第2层：i=3），内部的数字进行加和.i层有i个数，第i个数的下标是i-1，前一个数是i-2
//            if(i >= 3){
//                for(int j = 1; j <= i-2; j++){
//                    outlist[i][j] = outlist[i-1][j-1] + outlist[i-1][j];
//                }
//            }
//
//        }
//
//
//
//    }
//}
