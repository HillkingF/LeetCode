package Hot_100;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.StreamSupport;

public class Hard_76_minWindow {
    public static void main(String[] args){
        String s = "asabeiwafgc";
        String t = "ac";
        // String res = minWindow(s,t);
        String res = minsort(s);
        System.out.println(res);
    }


    /**
     * 下面可运行，但是太慢了，超出leetcode 时间限制
     */
    public static String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        if(s.equals(t)) return s;

        int tlen = t.length();
        char[] tchar = t.toCharArray();
        Arrays.sort(tchar);
        String t0 = new String(tchar);

        for(int len = tlen; len <= s.length(); len++) {  // 短序列的长度从t的长度一直到s的长度
            int i = 0;
            int j = i + len - 1;
            while (j < s.length()) {
                String stmp = s.substring(i, j + 1); //待比较的短序列
                char[] schar = stmp.toCharArray();
                Arrays.sort(schar);

                String s1 = new String(schar);
                String t1 = t0;
                int szhizhen = 0;
                int tzhizhen = 0;
                while(szhizhen < s1.length()){
                    if(tzhizhen < t1.length()){
                        if(s1.charAt(szhizhen) == t1.charAt(tzhizhen)){
                            szhizhen ++;
                            tzhizhen ++;
                        }else{
                            szhizhen ++;
                        }
                    }else{
                        break;
                    }
                }
                if(tzhizhen < t1.length()){
                    i ++;
                    j ++;
                }else{
                    return s.substring(i, j + 1);
                }
            }
        }
        return "";

    }

    public static String minWindow1(String s, String t) {
        if(s.length() < t.length()) return "";
        if(s.equals(t)) return s;

        int start = 0;
        int end = 0;
        String x = minsort(t);
        String res = "";
        int reslength = Integer.MAX_VALUE;
        while(end < s.length()){
            String y = minsort(s.substring(start, end + 1));
        }



        return "";

        


    }
    // 对子序列进行排序
    public static String minsort(String x){
        char[] xchar = x.toCharArray();
        Arrays.sort(xchar);
        String newstr = new String(xchar);
        return newstr;
    }
}
