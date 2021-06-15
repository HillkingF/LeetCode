package offer;

public class offer_44 {

    // 好像溢出了, 修改一下
    public int findNthDigit(int n) {
        int i = 1;  // i是每一个数字的位数
        int count = 9;
        int res = 0;
        while(n > 0){
            if(i == 1){
                if(n < 10){  // 说明n 一定在0-9之间
                    break;
                }else{      // 说明n 一定从10开始
                    n = n - 9;
                    i++;    // 说明n至少为两位
                }
            }else{
                // (count * 1.0/n) * 10 * i) 是防止溢出最重要的一步
                if(1.0 <= ((count * 1.0/n) * 10 * i)){ // 说明在这个段位中
                    break;
                }else{ //说明不在这个段位中
                    count = count * 10;
                    n = n - i * count;
                    i ++;
                }
            }
        }
        int d = 1;
        int num = n / i;  // 2/2 = 1
        int yushu = n % i;  //0
        for (int j = 1; j < i; j++) {
            d = d * 10;  // 10
        }
        d = d + num - 1;
        if(yushu == 0){
        }else{
            d = d + 1;
        }
        String x = String.valueOf(d);
        if(yushu == 0){
            res = Integer.valueOf(String.valueOf(x.charAt(x.length()-1)));
        }else{
            res = Integer.valueOf(String.valueOf(x.charAt(yushu - 1)));
        }
        return res;
    }
}

class test44{
    public static void main(String[] args) {
        offer_44 test = new offer_44();
        int res = test.findNthDigit(2147483647);
        System.out.println(res);
    }
}
