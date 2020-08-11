package String;

public class Simple_58_countAndSay {
    public static void main(String[] args){
        String s = "";//"Hello World";
        int x = lengthOfLastWord(s);
        System.out.print(x);


    }

    /**
     * 【思路】
     * 从左到右，初始长度len=0，信号sign=false
     * 如果字符i为空格，则令信号sign=true
     * 继续读下一个，如果不是空格：（说明一定是一个字符）
     * 则长度为1，并且设置sign=false
     * 继续遍历下一个，重复上述操作。
     */
    public static int lengthOfLastWord(String s) {
        boolean sign = false;
        int len = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ')sign = true;
            else if (sign == true){
                len = 1;
                sign = false;
            }else len++;
        }
        return len;
    }
}
