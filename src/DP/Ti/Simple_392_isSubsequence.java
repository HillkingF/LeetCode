package DP.Ti;

import java.util.concurrent.TransferQueue;

public class Simple_392_isSubsequence {
    public boolean isSubsequence(String s, String t) {
        // 下面两种其实还是双指针的写法，动态规划的没有看懂
//        if(t.equals("") && t.equals(s)) return true;
//        if(s.length() > t.length()) return false;
//
//        int tlen = t.length();
//        int slen = s.length();  //0~m-1:共m个
//        int sloc = 0;
//        int[] f = new int[tlen + 1];  // 多的1是用来存储0状态的
//        // 其中f[i] 表示前i-1的t子串是否包含s的前n个子串
//        char[] t1 = t.toCharArray();
//        char[] s1 = s.toCharArray();
//        int i;
//        for(i = 1; i < tlen + 1; i ++){
//            f[i] = 0;
//            if(sloc != slen){
//                if(t1[i-1] == s1[sloc]){
//                    f[i] = 1;
//                    sloc ++;
//                }else{
//                    f[i] = f[i-1];
//                }
//            }else{
//                return true;
//            }
//        }
//
//        if(sloc < slen)return false;
//        else return true;
        if(t.equals("") && t.equals(s)) return true;
        if(s.length() > t.length()) return false;

        int tlen = t.length();
        int slen = s.length();  //0~m-1:共m个
        int sloc = 0;
        char[] t1 = t.toCharArray();
        char[] s1 = s.toCharArray();
        int i;
        for(i = 1; i < tlen + 1; i ++){
            if(sloc != slen){
                if(t1[i-1] == s1[sloc])sloc ++;
            }else return true;
        }
        if(sloc < slen)return false;
        else return true;

    }
}
