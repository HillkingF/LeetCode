package offer;

public class offer_13 {
    /*[题目格式化]
    网格: m*n, 坐标从(0,0)到(m-1,n-1)
    机器人:可以上下左右移动
    约束条件: 坐标i,j每一个数的每一位的和< k
    问题:一共能走多少个格子
     [思路]
     创建一个二维数组f,如果已经遍历过了就设置为1,默认为0
     定义一个全局个数,count.入如果有满足条件的就+1;
     递归求解:先求本位是否满足,如果满足则上下左右递归
     */
    private int[][] f;
    private int count = 0;

    public static void main(String[] args) {
        int i = 35;
        int sum = i%10 + (i/10)%10 + (i/100)%10 ;
        System.out.println(sum);
    }

    public int movingCount(int m, int n, int k) {
        f = new int[m][n];  //这里f不用初始化,默认为0.只用在下面判断是否为1,因为遍历过的格子一定赋值为1了
        move(m, n, 0, 0, k);
        return count;

    }
    public void move(int m, int n , int i, int j, int k){
        // 默认从上面传来的i,j满足边界要求

        // 1.判断这一位是否已经访问过
        if(f[i][j] == 1){
            return ;
        }else{
            // 2.表示这一位即将判断是否<=k
            f[i][j] = 1;
            // 3.判断i,j的位置是否<=k.不满足直接返回null.满足则进一步遍历
            int sum = i%10 + (i/10)%10 + (i/100)%10  + j%10 + (j/10)%10 + (j/100)%10;
            if(sum <= k){
                // 4.说明这一格的 和 <= k并且还没有访问过,count ++
                count ++;
                // 5.判断i,j的边界,然后递归遍历
                if(i>0 && i<m) move(m, n, i-1,j, k);
                if(i>=0 && i<m-1) move(m, n, i+1,j, k);
                if(j>0 && j<n) move(m, n, i,j-1, k);
                if(j>=0 && j<n-1) move(m, n, i,j+1, k);
            }else{
                return ;
            }
        }
    }
}
