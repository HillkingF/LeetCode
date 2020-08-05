package Array;

import java.util.ArrayList;
import java.util.List;

public class Medium_54_SpiralMatrix {
    public static void main(String[] args){
        int[][] matrix = {{1, 2, 3, 4},{5, 6, 7, 8},{9,10,11,12 }};
        Solution54 s = new Solution54();
        List<Integer> list = s.spiralOrder(matrix);
        for(int num: list){
            System.out.print(Integer.toString(num) + ',');
        }

    }
}

/**
 * 【思路】
 * 类似于48题，都是从左上角开始，从外向内，顺时针一圈一圈遍历
 */
class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix == null) return list;
        int m = matrix.length;  // 行数
        int n = matrix[0].length;  //列数
        int L = (int)Math.ceil((double)Math.min(m, n)/2);  //圈数
        int l,p;
        for(l = 0; l < L; l++){
            for(p = l; p <= n-1-l; p++)list.add(matrix[l][p]);
            for(p = l + 1; p <= m-1-l; p++)list.add(matrix[p][n-1-l]);
            if(l + 1 > m/2 ||l + 1 > n/2)break;
            for(p = n-1-l-1; p >= l; p--)list.add(matrix[m-1-l][p]);
            for(p = m-1-l-1; p>=l+1; p--)list.add(matrix[p][l]);
        }
        return list;
    }
}