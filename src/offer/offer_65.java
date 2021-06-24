package offer;

public class offer_65 {
    public int add(int a, int b) {

        int res = 0;
        int count = 0;

        int c = 0;
        int moa = 0;
        int mob = 0;
        int sumi = 0;

        while(count < 32){
            // 获得a和b最低位的数：01
            moa = Math.abs(a % 2);
            a = a >>> 1;
            mob = Math.abs(b % 2);
            b = b >>> 1;



            // 将两个最低位和上一个进位进行 +，获得新的进位和本位和
            sumi = moa ^ mob ^ c;
            if((moa == 1 && mob == 1 && c == 1) ||
                    (moa == 1 && mob == 1 && c == 0) ||
                    (moa == 1 && mob == 0 && c == 1) ||
                    (moa == 0 && mob == 1 && c == 1)){
                c = 1;
            }else{
                c = 0;
            }


            // 将本位的和：先左移，然后加到结果中
            sumi = sumi << count;
            res = res | sumi;
            count ++;  // 1
        }
        return res;
    }
}


class offer_test_65{
    public static void main(String[] args) {
        offer_65 tes = new offer_65();
        int x = tes.add(-5,2);
        System.out.println(x);
    }
}