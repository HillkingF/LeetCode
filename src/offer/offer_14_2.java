package offer;

public class offer_14_2 {
    // offer_14_1的进阶版
    public int cuttingRope(int n) {
        // 这道题的动态规划思路没有看懂.
        // 使用数学推导:
        // (a1 + a2 + a3 + ... + an)/n > a更号(a1a2a3a4...an). 当an都相等时,乘积有最大值
        // n=ax,即长度n分成了a段长x的子段.此时乘积为x的a次方
        // 令乘积y = x的a次方 = x的(n/x)次方 = (x的(1/x)次方) 的 n次方
        // 令t = (x的(1/x)次方) 时 y有最大值
        // 上式可以转化为 lnt = lnx/x
        // 对t进行求导: t'/t = 1-lnx/ x^2
        // 则t' = (1-lnx)*(x^(1/x)) / x^2
        // 令t' = 0 时的x为极值点.则 x = e
        // 也就是说当x=e时乘积最大.由于规定乘数为整数.所以x在3附近最大
        long res = 1;
        if(n == 2) return 1;
        else if (n == 3)return 2;
        else{
            while(n > 4){
                res = res * 3;
                res = res % (1000000007);
                n = n -3;
            }
            res =  (res * n)  % (1000000007);
            return (int) res;
        }
    }

}
