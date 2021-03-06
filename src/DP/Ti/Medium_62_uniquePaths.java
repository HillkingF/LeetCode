package DP.Ti;

public class Medium_62_uniquePaths {
    public int uniquePaths(int m, int n) {
        /**
         * 【提示】
         * 这道二维网格的题，视频笔记里面有
         * 【类型：坐标】
         * 【思路】
         * 1、最后一步：最后到finish点时一共有几种方法： =向下和向右的总和
         * 2、子问题：求最后一步的上一步一共有多少种方法
         * 3、状态：设f[m][n]表示到（m,n）位置时的路径数量
         * 4、转移方程：f[m][n] = f[m-1][n] + f[m][n-1] ; //其中两个加数依次表示下一步向下和下一步向右的路径数
         * 5、初始状态：f[0][0] = 1
         * 6、边界条件：第一行和第一列的 值都为1
         * 7、计算顺序：从第一行开始从左向右依次计算
         * 8、返回值：f[m-1][n-1]
         *
         * 9、优化： 滚动数组？ 用一个数组始终表示上一行的数据
         *
         */
        if(m == 1 || n == 1) return 1;
        int[][] f = new int[m][n];

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0) {// 边界条件
                    f[i][j] = 1;
                }else{
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        return f[m-1][n-1];


    }
}
