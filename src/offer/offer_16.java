package offer;

public class offer_16 {
    public static void main(String[] args) {
        double x = 8.84372;
        int n = -5;
        System.out.println(myPow(x,n));
    }
    public static double myPow(double x, int n) {
        // 判断n正负.正数直接传入,负数传入相反数
        double res = cul(x, n>0?n : -n);  // 这是一个递归函数:每一次递归将n/2.直到n=0或者n=1
        return n > 0? res : 1/res;
    }

    public static double cul(double x, int m){
        if(m == 0) return 1.0;
        else{
            double res = 0;
            if(m == 1) return x;
            else{ // n > 2
                if(m%2==0){
                    res = cul(x, m/2);
                    res = res * res;
                }else{
                    res = cul(x, m/2);
                    res = res * res * x;
                }
            }
            return res;
        }
    }
}
