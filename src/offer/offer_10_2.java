package offer;

public class offer_10_2 {
    private int[] f = new int[101];
    public offer_10_2(){
        for (int i = 0; i < 101; i++) {
            f[i] = -1;
        }
        f[0] = 1;
        f[1] = 1;
    }
    public int numWays(int n) {
        // 动态规划的思想
        if(f[n] != -1 || n < 2) return f[n];
        // 如果最后一步上两个台阶
        f[n-2] = (f[n-2] == -1)? (int) (numWays(n-2)%(1e9+7)) : f[n-2];
        // 如果最后一步上1个台阶
        f[n-1] = (f[n-1] == -1)? (int) (numWays(n-1)%(1e9+7)) : f[n-1];
        // 这一步有多少种方法
        f[n] = (int) ((f[n-2] + f[n-1])%(1e9+7));
        return f[n];
    }
}
