package String;

public class Medium_227_Calculate {
    public static void main(String[] args){
        String s = "3+2*2";
        int a = calculate1(s);
        System.out.println(a);
    }


    public static int calculate(String s) {

        /**
         * 【条件分析】
         *  运算符优先级 (/ *) > (+-)
         *  字符串仅包含非负整数： 也就是包含0和正数
         *  所有表达式都是有效的
         *
         * 【思路】
         * 删除所有空格；
         * 从头开始遍历：
         * 两个指针：p1先计算后面的* '/'，p2计算前面的+-
         */

        if(s.length() < 3) return Integer.parseInt(s);  //小于3位一定是一个整数
        s = "0+" +s.replace(" ", "") + "+0";  // 删除所有的空格
        System.out.println(s);
        int x = -1, y = 1, z, t = -1;   //坐标索引
        int xy = 0, yz, yt = 1, tz;   //部分和

        for(z = 2; z < s.length(); z++ ){
            if(Character.isDigit(s.charAt(z))){
                //pass
            }else{
                // 1、z这个位置终于不是数字了，判断是什么符号
                if(s.charAt(z) == '+'||s.charAt(z) == '-'){

                    if(t!= -1){
                        tz = Integer.parseInt(s.substring(t+1, z));
                        yz = s.charAt(t) == '*'? yt*tz : yt/tz;
                        t = -1;
                        xy = s.charAt(y) == '+'? xy + yz : xy - yz;
                        x = y;
                        y = z;
                    }else{
                        //如果是+-，先确定yz；
                        yz = Integer.parseInt(s.substring(y+1, z));
                        //计算前面的和,记做xy
                        xy = s.charAt(y) == '+'? xy + yz : xy - yz;
                        //x,y均前移
                        x = y;
                        y = z;
                    }
                }else{
                    //如果是乘除号，t上线
                    if(t != -1){
                        tz = Integer.parseInt(s.substring(t+1, z));
                        yt = s.charAt(t) == '*'? yt*tz: yt/tz;
                        t = z;
                    }else{
                        t = z;
                        yt = Integer.parseInt(s.substring(y+1, t));
                    }


                }

            }
        }
        return xy;


    }
    public static int calculate1(String s) {

        /**
         * 【对calculate优化】
         */

        if (s.length() < 3) return Integer.parseInt(s);  //小于3位一定是一个整数
        s = "0+" + s.replace(" ", "") + "+0";  // 删除所有的空格
        int y = 1, t = -1;   //坐标索引
        int xy = 0, yz, yt = 1;   //部分和

        for (int z = 2; z < s.length(); z++) {
            if (!Character.isDigit(s.charAt(z))) {
                if (s.substring(z, z + 1).equals("+") || s.substring(z, z + 1).equals("-")) {
                    if (t != -1)
                        yz = s.charAt(t) == '*' ? yt * Integer.parseInt(s.substring(t + 1, z)) : yt / Integer.parseInt(s.substring(t + 1, z));
                    else
                        yz = Integer.parseInt(s.substring(y + 1, z));
                    xy = s.charAt(y) == '+' ? xy + yz : xy - yz;
                    y = z;
                    t = -1;
                } else {
                    if (t != -1)
                        yt = s.charAt(t) == '*' ? yt * Integer.parseInt(s.substring(t + 1, z)) : yt / Integer.parseInt(s.substring(t + 1, z));
                    else
                        yt = Integer.parseInt(s.substring(y + 1, z));
                    t = z;
                }
            }
        }
        return xy;
        }
    public static int calculate2(String s) {

        /**
         * 【使用栈或者队列】
         */

        return 0;
    }


}
