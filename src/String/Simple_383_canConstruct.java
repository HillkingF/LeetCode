package String;

import java.util.Scanner;

public class Simple_383_canConstruct {
    public static void main(String[] args){
        String a = "aab";
        String b = "baa";

        boolean c = canConstruct(a, b);
        System.out.print(c);

    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        /**
         * 方法1、暴力法
         * 两次循环
         */
        if(magazine.length() < ransomNote.length()) return false;
        int j;
        int sign = 0;
        for(int i = 0; i < ransomNote.length(); i++){
            sign = 0;
            for(j = 0; j < magazine.length(); j++){
                if(ransomNote.charAt(i) == magazine.charAt(j)){
                    sign = 1;
                    if(j == 0) magazine = magazine.substring(1);
                    else magazine = magazine.substring(0, j) + magazine.substring(j + 1);
                    break;
                }
            }
            if(sign == 1) sign = 0;
            else return false;
        }
        return true;

        /**
         * 方法2，两次循环法
         * 每一次记录一个字符串中字符出现的次数
         * 最后第三次循环比较字符个数是否充足
         */

    }
}
