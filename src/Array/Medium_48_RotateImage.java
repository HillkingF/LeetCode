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
        s.rotate(matrix);

    }

}

class Solution48 {
    public void rotate(int[][] matrix) {
        // 1、计算层数
        int l = (int)Math.ceil(matrix[0].length/2);
        int n = matrix[0].length;
        // 2、逐层旋转
        int i;
        int c;
        List<Integer> temp = new ArrayList<Integer>();
        for(i = 0; i <= l - 1; i++) {
            if (n % 2 == 1 && i == l) {
                break;
            } else {
                // 将上层的1-(n-1)暂存
                temp.clear();
                for(int k = n - 1 - i; k >= i; k--){
                    System.out.println(matrix[i][k]);
                    temp.add(matrix[i][k]);
                }

                int j;
                int x = 0;
                for (j = i; j < n-i; j++) {
                    matrix[i][n-1 - j] = matrix[j][i];  //left
                    matrix[j][i] = matrix[n-1-i][j]; //bottom
                    matrix[n-1-i][j] = matrix[n-1-j][n-1-i]; //right
                    System.out.println(temp.get(x));
                    matrix[n-1-j][n-1-i] = temp.get(x);
                    x++;
                }

            }
        }


    }
}