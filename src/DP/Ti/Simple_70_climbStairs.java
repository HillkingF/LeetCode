package DP.Ti;

public class Simple_70_climbStairs {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for(int i = 2; i <= n; i++){
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];

    }
}