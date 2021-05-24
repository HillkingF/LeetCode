package offer;

import javax.swing.*;

public class offer_05 {
    public static void main(String[] args) {
        String s = "We are happy.";
        String res = replaceSpace(s);
        System.out.println(s.length());
        System.out.println(res);


    }
    public static String replaceSpace(String s) {
        String newstr = "";
        int start = 0;
        int end = 0;
        int blank = 0;
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) != ' '){
                end = i;
                i ++; // 此时 i= end + 1
                if(i == s.length()){
                    newstr = newstr + s.subSequence(start, end + 1);
                    break;
                }
            }else{  // 这一位是空格
                if(s.charAt(end) != ' '){
                    newstr = newstr + s.subSequence(start, end + 1);
                }
                blank = i;  // 接下来判断有几个空格
                while(blank < s.length() && s.charAt(blank) == ' '){
                    newstr = newstr + "%20";
                    blank ++;
                }
                if(blank == s.length()){
                    break;
                }else{
                    start = blank;
                    end = blank;
                    i = blank;
                }
            }
        }
        return newstr;
    }
}
