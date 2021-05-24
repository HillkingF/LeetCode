package offer;

public class offer_10_1 {
    private int[] allres = new int[101];
    public offer_10_1(){

    }

}


class Solution {
    private int[] res = new int[101];
    // 定义一个初始化数组,用于存储局部计算结果
    public Solution(){
        for(int i = 0; i <= 100; i++){
            res[i] = -1;
        }
        res[0] = 0;
        res[1] = 1;
    }

    public int fib(int n) {
        if(res[n] != -1 || n < 2) return res[n];

        // 计算或直接获取fib(n-2)
        int n_2;
        if(res[n-2] != -1){
            n_2 = res[n-2];
        }else{
            n_2 = (int) (fib(n-2)%(1e9+7));
            res[n-2] = n_2;
        }
        // 计算或直接获取fib(n-1)
        int n_1;
        if(res[n-1] != -1){
            n_1 = res[n-1];
        }else{
            n_1 = (int) (fib(n-1)%(1e9+7));
            res[n-1] = n_1;
        }
        // 计算fib(n)
        int r = (int) ((n_1 + n_2)%(1e9+7));
        res[n] = r;
        return r;

    }
}