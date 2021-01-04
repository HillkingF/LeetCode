package DP.Ti;

import java.util.ArrayList;
import java.util.List;

public class Medium_131_partition {
    public List<List<String>> partition(String s) {
        /**
         * 【类型：划分型】
         * 【提示：f[i][j]表示索引i到索引j之间的内容？】
         * 【思路】
         * 1、最后一段：
         * 2、子问题：以每一个字符为 一个回文段的中间字符的 情况；
         * 3、
         *
         */


        List<List<String>> zuhe_j = new ArrayList<>();  // 其中第i个元素表示以第i个元素为中心点的所有可能的子回文串
        List<List<String>> zuhe_o = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            List<String> mid_j = new ArrayList<>();  // 其中依次是
            List<String> mid_o = new ArrayList<>();
            int sign_j = 0;
            int sign_o = 0;
            for(int len = 0; i + len < s.length() && i - len >= 0; len++){
                if(len == 0){
                    mid_j.add(s.substring(i,i+1));
                }else{
                    // 先判断mid为最中间的
                    if(s.charAt(i + len) == s.charAt(i - len)){
                        mid_j.add(s.substring(i - len, i + len + 1));
                    }else sign_j = 1;

                    // 再判断子回文串为偶数个字符
                    if(s.charAt(i + len) == s.charAt(i-(len-1))){
                        mid_o.add(s.substring(i-(len-1),i + len + 1));
                    }else sign_o = 1;
                }
                if(sign_j==1 && sign_o == 1) break;
            }
            zuhe_j.add(mid_j);
            zuhe_o.add(mid_o);
        }




        List<List<String>> outer = new ArrayList<>();

        List<List<List<String>>> allchar = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            List<List<String>> eachouter = new ArrayList<>(); // 每一个字符串长度为i时，所有可能的组合
            for(int j = 0; j <= i; j++){ // 以每一个j位置的字符作为中点，字符串一共长i
                if(j == 0){
                    List<String> inner = new ArrayList<>();
                    inner.add(s.substring(0,1));
                    eachouter.add(inner);
                    allchar.add(eachouter);
                }else{  // i从1开始，j从0开始
                    List<String> inner = new ArrayList<>();
                    for(int len = 1; j-len >= 0 || j + len <= i; len ++ ){

                    }



                }
            }

        }

        return null;


    }
}

