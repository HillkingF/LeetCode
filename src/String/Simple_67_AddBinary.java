package String;

public class Simple_67_AddBinary {
    public static void main(String[] args){
        String a = "1010";
        String b = "1011";
        String c = addBinary(a,b);
        System.out.print(c);
    }

    public static String addBinary(String a, String b) {
        /**
         * pa指向字符串a的最后一个，pb指向字符串b的最后一个
         * sign 表示进位
         * 将每一次指向的两个字符转换成字符串（直接转换成整数为字符的ascll码），再转换成整数。
         * 根据整数和来判断进位和本位值（这里可能影响了速度，直接使用字符判断进位和本位和可能会快一点）
         * 然后向前依次遍历，当某一个字符串遍历结束后，跳出循环单独遍历
         */
        int pa = a.length() - 1;
        int pb = b.length() -1;
        int sum;
        char sign = '0';

        String s = "";

        while(pa > -1 && pb > -1){
            sum = Integer.parseInt(Character.toString(a.charAt(pa))) +
                    Integer.parseInt(Character.toString(b.charAt(pb))) +
                    Integer.parseInt(Character.toString(sign));
            s = Integer.toString(sum%2) + s;
            if (sum > 1) sign = '1';
            else sign = '0';
            pb--;
            pa--;
        }
        if(pa == -1 && pb == -1){
            if(sign == '1')s = sign + s;
        }else if(pa == -1){
            while(pb > -1){
                sum = Integer.parseInt(Character.toString(b.charAt(pb))) +
                        Integer.parseInt(Character.toString(sign));
                s = Integer.toString(sum%2) + s;
                if (sum > 1) sign = '1';
                else sign = '0';
                pb--;
            }
            if(pb == -1){
                if(sign == '1')s = sign + s;
            }
        }else if(pb == -1){
            while(pa > -1){
                sum = Integer.parseInt(Character.toString(a.charAt(pa))) +
                        Integer.parseInt(Character.toString(sign));
                s = Integer.toString(sum%2) + s;
                if (sum > 1) sign = '1';
                else sign = '0';
                pa--;
            }
            if(pa == -1){
                if(sign == '1')s = sign + s;
            }
        }
        return s;
    }
}
