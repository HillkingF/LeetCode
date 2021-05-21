package Hot_100;


public class Medium_221_maximalSquare {

    public int maximalSquare(char[][] matrix) {
        // 使用动态规划
        // d[i][j] = l  表示以i，j为右下角的最大正方形的边长为l
        int[][] d = new int[matrix.length][matrix[0].length];
        int maxedge = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(i == 0 || j == 0) d[i][j] = matrix[i][j] == '1' ? 1 : 0;
                else{
                    if(matrix[i][j] == '1'){
                        d[i][j] = Math.min(Math.min(d[i-1][j] , d[i][j-1]), d[i-1][j-1]) + 1;
                    }else{
                        d[i][j] = 0;
                    }
                }
                if( d[i][j] > maxedge) maxedge =  d[i][j];
            }
        }
        return maxedge * maxedge;
    }
}
