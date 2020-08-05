package Array;

import java.util.ArrayList;
import java.util.List;

public class Medium_48_RotateImage {
    public static void main(String[] args){
        Solution48 s = new Solution48();
        int[][] matrix = {
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        };
        int[][] matrix1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        s.rotate(matrix);

    }

}

class Solution48 {
    public void rotate(int[][] matrix) {
        // 1、计算层数
        int l = (int)Math.ceil((double)matrix[0].length/2);
        int n = matrix[0].length;
        // 2、逐层旋转
        int i;
        List<Integer> temp = new ArrayList<Integer>();
        for(i = 0; i <= l - 1; i++) {
            // i表示从外到内，第i圈
            // 如果层数是单数，则最中间一个数字不用旋转。否则最内层也要旋转

            if (n % 2 == 1 && i == l-1) {
                break;
            } else {
                // 将上层的1-(n-1)暂存
                temp.clear();
                for(int k = n - 1 - i; k >= i; k--){
                    temp.add(matrix[i][k]);
                }

                // j 表示每一圈第几个旋转。j不超过每一圈上层个数-1
                int j;
                int x = 0;
                for (j = i; j < n-i-1; j++) {
                    matrix[i][n-1 - j] = matrix[j][i];  //left
                    matrix[j][i] = matrix[n-1-i][j]; //bottom
                    matrix[n-1-i][j] = matrix[n-1-j][n-1-i]; //right
                    matrix[n-1-j][n-1-i] = temp.get(x);
                    x++;
                }
            }
        }
    }
}