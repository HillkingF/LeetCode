package Hot_100;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;

public class Mzedium_200_numIslands {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(grid));

    }
    public static int numIslands(char[][] grid) {
        // 本题还是关于无向图的遍历
        // 网格类问题不用构建链接表，由于网格类的无向图有坐标，并且一般会指定上下左右中的某几个前进方向，
        // 因此使用DFS或BFS遍历时，只需要将遍历过的网格进行标记或者修改即可

        // 判断网格的样式
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        // i,j ==1，进入DFS（所有的改变1为0的操作在DFS中完成）
        int icount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    icount += 1;
                    DFS(grid, i, j);
                }
            }
        }
        return icount;
    }

    public static void DFS(char[][] grid, int row, int col){
        // 参数说明：表示此时从[row,col]坐标的位置开始向四个方向进行DFS遍历

        // 1. 首先对row，col位置的元素进行判断
        if(grid[row][col] == '1'){
            // 2. 先将遍历到的这个点改成“0”，表示已经遍历过了
            grid[row][col] = '0';
            // 3.对四个方向是否进行DFS进行判断
            if(row > 0) DFS(grid, row-1,col);
            if(col < grid[0].length-1) DFS(grid, row, col + 1);
            if(row < grid.length-1) DFS(grid, row + 1, col);
            if(col > 0) DFS(grid, row, col - 1);

        }
        return ;
    }
}
