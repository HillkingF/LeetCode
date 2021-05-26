package offer;

public class offer_29 {
    // 即:顺时针打印二维数组
    // 把这个矩阵当成图来遍历
    // 遍历一圈的顺序是:右/下/左/上
    // 遍历过的地方设置为一个单独的数字,表示已经遍历过了

    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null)return null;
        if(matrix.length == 0) return new int[0];

        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;
        // cyc是矩阵的最大遍历圈数
        int col = Math.min(matrix.length, matrix[0].length) % 2;
        int row = Math.min(matrix.length, matrix[0].length)/2;
        int cyc = col == 1? row + 1 : row;
        // i是每一圈的起始遍历点坐标  = 00 11 22
        for (int i = 0; i < cyc; i++) {
            row = i;
            col = i;

            // 1.判断(从ii位置开始)能否向右行走,能行走就一直行走.
            while(col < matrix[0].length && matrix[row][col] != Integer.MIN_VALUE){
                res[index ++] = matrix[row][col];
                matrix[row][col] = Integer.MIN_VALUE;
                col ++;
            }
            if(col != row) col --;

            // 2.判断(从row + 1, col位置开始)能否向下行走,能行走就一直行走.
            row ++;
            while(row < matrix.length && matrix[row][col] != Integer.MIN_VALUE){
                res[index ++] = matrix[row][col];
                matrix[row][col] = Integer.MIN_VALUE;
                row ++;
            }
            row--;
            col--;

            // 3.判断(从row,col-1位置开始)能否向左行走,能行走就一直行走.
            while(col >= 0 && matrix[row][col] != Integer.MIN_VALUE){
                res[index ++] = matrix[row][col];
                matrix[row][col] = Integer.MIN_VALUE;
                col --;
            }
            row--;
            col++;
            // 4.判断(从row--,col位置开始)能否向上行走,能行走就一直行走.
            while(row >= 0 && matrix[row][col] != Integer.MIN_VALUE){
                res[index ++] = matrix[row][col];
                matrix[row][col] = Integer.MIN_VALUE;
                row --;
            }
        }
        return res;

    }
}
