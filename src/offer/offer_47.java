package offer;

// 与网格有关的题型有:动态规划/DFS/bfs
// 这里用动态规划:

/**
 * 给定一个起点, 只能向右或者向下走,到达一个给定的终点
 */
public class offer_47 {
    public int maxValue(int[][] grid) {
        // 设置一个二维数组保存到达每一格时 获得的价值
        int[][] w = new int[grid.length][grid[0].length];
        // 每次只能向右或者向下:说明i,j位置只能来自于前一个 或者上一行的一个数
        int upper = 0;  // 记录上一个
        int last = 0; // 记录前一个
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                w[i][j] = 0;
                // 左边前一个
                if(j == 0) last = 0;
                else last = w[i][j - 1];
                // 上一行的上一个
                if( i == 0) upper = 0;
                else upper = w[i - 1][j];
                // 比较上一个和前一个的大小,将大的加入本个位置上
                w[i][j] = (last > upper ? last : upper) + grid[i][j];
            }
        }
        return w[grid.length - 1][grid[0].length - 1];
    }
}

class test_offer_47 {
    public static void main(String[] args) {
        offer_47 test = new offer_47();
        int[][] g = {{1,3,1},{1,5,1},{4,2,1}};
        int res = test.maxValue(g);
        System.out.println(res);


    }


}
