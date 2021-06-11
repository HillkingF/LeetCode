package offer;

public class offer_44 {

    // 好像溢出了, 修改一下
    public int findNthDigit(int n) {
        int i = 1;
        int lastn = 1;
        int count = 9;
        int res = 0;
        while(n > 0){
            if(i == 1){
                lastn = n;
                n = n - 9;
                i++;
            }else{
                lastn = n;
                count = count * 10;
                n = n - i * count;
                i ++;
            }

        }
        if(n == 0) return 9;
        else{
            i = i - 1;
            int d = 1;
            int num = lastn / i;  // 2/2 = 1
            int yushu = lastn % i;  //0
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
        }

        return res;
    }
}

class test44{
    public static void main(String[] args) {
        offer_44 test = new offer_44();
        int res = test.findNthDigit(32);
        System.out.println(res);
    }
}
