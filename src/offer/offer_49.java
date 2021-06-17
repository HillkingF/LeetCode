package offer;

import java.util.ArrayList;

public class offer_49 {
    // 暴力法超出时间限制了
    public int nthUglyNumber(int n) {
        int num = 1;
        int i = 0;
        int res = 0;
        int restnum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        if(n == 0)return 0;
        while(i < n){
            restnum = num;
            while(restnum % 2 == 0){  // 是2的倍数
                restnum = restnum / 2;
                if(list.contains(restnum)){
                    restnum = 1;
                    break;
                }
            }
            while(restnum % 3 == 0){
                restnum = restnum / 3;
                if(list.contains(restnum)){
                    restnum = 1;
                    break;
                }
            }
            while(restnum % 5 == 0){
                restnum = restnum / 5;
                if(list.contains(restnum)){
                    restnum = 1;
                    break;
                }
            }
            // 判断restnum是否等于1：等于为丑数
            if(restnum == 1){
                i ++;
                list.add(num);
            }
            // num + 1
            num = num + 1;
        }
        return num - 1;
    }

    // 使用动态规划进行求解
    public int nthUglyNumber1(int n) {
        int[] res = new int[n + 1];  // 用res[i] 表示第i个丑数
        res[1] = 1;
        int p1 = 1, p2 = 1, p3 = 1;
        int tmp1, tmp2, tmp3;
        for(int i = 2; i < n + 1; i++){
            tmp1 = res[p1] * 2;
            tmp2 = res[p2] * 3;
            tmp3 = res[p3] * 5;
            res[i] = Math.min(Math.min(tmp1, tmp2), tmp3);
            if(res[i] == tmp1) p1++;
            if(res[i] == tmp2) p2++;
            if(res[i] == tmp3) p3++;
        }
        return res[n];
    }
}

class test_offer_49{
    public static void main(String[] args) {
        offer_49 test = new offer_49();
        int res = test.nthUglyNumber(253);
        System.out.println(res);
    }
}
