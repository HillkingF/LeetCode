package DP.Ti;

public class Medium_63uniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /**
         * 【提示】
         * 这道题和62类似，多了一个障碍物的条件，
         * 对应位置有障碍物用1表示，没有障碍物用0表示
         * 【思路】
         * 跟62类似，还是一样设置f[m][n],
         * 判断obstacleGrid的值，
         * 若位置上值为1，则f对应位置值为0，表示不能到达
         *
         * 【明天优化一下】
         */
        int width = obstacleGrid.length;
        int height = obstacleGrid[0].length;
        if(width == 1 && height == 1){
            if(obstacleGrid[width-1][height-1] == 1) return 0;
            else return 1;
        }
        int[][] f = new int[width][height];

        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                if(obstacleGrid[i][j] == 1) f[i][j] = 0; // 这个位置有障碍物直接为0
                else{
                    if(i == 0 || j == 0){
                        if(i == 0 && j == 0){
                            f[0][0] = 1;
                        }else if(i == 0){
                            if(f[0][j-1] == 0) f[0][j] = 0;
                            else f[0][j] = 1;
                        }else{
                            if(f[i-1][0] == 0)f[i][0] = 0;
                            else f[i][0] = 1;
                        }
                    }
                    else{
                        f[i][j] = f[i-1][j] + f[i][j-1];
                    }
                }
            }
        }
        return f[width-1][height-1];


    }
}
