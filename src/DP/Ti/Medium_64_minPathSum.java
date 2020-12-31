package DP.Ti;

public class Medium_64_minPathSum {
    public int minPathSum(int[][] grid) {
        /**
         * 跟62,63题有点类似
         * 1、最后一步：到右下角时的路径数字和最小
         * 2、子问题：到右下角的前一步时路径和最小
         * 3、状态：设 f[m][n]为到（m,n）位置时的最小路径和
         * 4、转移方程：f[m][n] = min(f[m-1][n],f[m][n-1]) + grid[m][n]
         * 5、初始化：f[0][0] = gird[0][0]
         * 6、边界条件：第一行直接依次相加 ， 第一列直接依次相加
         * 7、计算顺序：从第一行开始计算，
         * 8、返回值： f[m][n]
         *
         */

        int row = grid.length;
        int col = grid[0].length;
        if(row == 1 && col == 1) return grid[0][0];
        int[][] f = new int[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i == 0 && j == 0) f[0][0] = grid[0][0];
                else if(i == 0) f[0][j] = f[0][j-1] + grid[0][j];
                else if(j == 0) f[i][0] = f[i-1][0] + grid[i][0];
                else f[i][j] = Math.min(f[i-1][j], f[i][j-1]) + grid[i][j];
            }
        }
        return f[row-1][col-1];

    }
}
