package Hot_100;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.StreamSupport;

public class Hard_76_minWindow {
    public static void main(String[] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = minWindow1(s,t);
        // String res = minsort(s);
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
        String res = "";
        int reslength = Integer.MAX_VALUE;
        int tmplen = 0;
        int sign = 0;

        // 构造字符数量字典
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if(tmap.containsKey(t.charAt(i))){ tmap.put(t.charAt(i), tmap.get(t.charAt(i)) + 1);
            }else{ tmap.put(t.charAt(i), 1); }
            smap.put(t.charAt(i), 0);
        }
        if(tmap.containsKey(s.charAt(0))){  smap.put(s.charAt(0), 1); }


        while(end < s.length() && start <= end){
            sign = 0;
            String y = s.substring(start, end + 1);  // start 到 end范围内的子串
            System.out.println(y);
            tmplen = y.length();
            // 对比目前维护的smap中是否包含全部的tmap
            for(char a : tmap.keySet()){
                if(smap.get(a) >= tmap.get(a)){
                }else{ // 说明y 不包含t
                    sign = 1;
                    end ++;
                    if(end < s.length() && tmap.containsKey(s.charAt(end))){
                        smap.put(s.charAt(end), smap.get(s.charAt(end)) + 1);
                    }
                    break;
                }
            }
            if(sign == 0){ // 说明y包含t
                if(tmplen < reslength){
                    reslength = tmplen;
                    res = y;
                }
                if(smap.containsKey(s.charAt(start))){
                    smap.put(s.charAt(start), smap.get(s.charAt(start)) - 1);
                    start ++;
                }else{
                    while(!tmap.containsKey(s.charAt(start))){
                        if(start < end){
                            start ++;
                        }else{
                            break;
                        }

                    }
                }
                if(start > end){
                    end ++;
                }
            }
        }
        return res;
    }

}
