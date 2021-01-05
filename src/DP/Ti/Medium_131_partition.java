package DP.Ti;

import java.util.ArrayList;
import java.util.List;

public class Medium_131_partition {
    public static void main(String[] args){
        String s = "cdd";
        List<List<String>> x = partition(s);
        for(List<String> z: x){
            System.out.println("=========");
            for(String res: z){
                System.out.print(res + "-");
            }
        }
    }
    public static List<List<String>> partition(String s) {
        /**
         * 【类型：划分型】
         *
         * 【思路】
         * 1、最后一段：
         * 2、子问题：以每一个字符为 一个回文段的中间字符的 情况；
         * 看看partition中的注释理解一下。
         *
         * 自己做出来的时间很慢优化不了，可以再看看题解中的其他方法
         *
         */
        List<List<String>> outer = new ArrayList<>();
        if(s.equals(""))return outer;
        if(s.length() == 1){
            List<String> in = new ArrayList<>();
            in.add(s.substring(0,1));
            outer.add(in);
            return outer;
        }

        // 当s长度大于1时开始下面的内容
        // 其中第i个元素表示以第i个元素为中心点的所有可能的子回文串
        List<Integer> zuhe_j = new ArrayList<>();
        List<Integer> zuhe_o = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){ // i表示以i位置的字符为奇偶回文串的中心
            int mid_j = 0;  // 奇数个回文串的个数：至少为1
            int mid_o = 0;  // 偶数个回文串的个数：至少为0

            int sign_j = 0;
            int sign_o = 0;

            for(int len = 0; len < s.length(); len++){
                // 先判断mid为最中间的
                if(sign_j == 0 && i + len < s.length() && i - len >= 0){
                    if(s.charAt(i + len) == s.charAt(i - len)){
                        mid_j ++;
                    }else{
                        sign_j = 1;
                    }
                }else sign_j = 1;
                // 再判断子回文串为偶数个字符
                if(sign_o == 0 && len > 0 && i + len < s.length() && i - (len-1) >=0){
                    if(s.charAt(i + len) == s.charAt(i-(len-1))){
                        mid_o ++;
                    }else{
                        sign_o = 1;
                    }
                }else if(len == 0){

                }else{
                    sign_o = 1;
                }

                if(sign_j==1 && sign_o == 1) break;
            }
            zuhe_j.add(mid_j);
            zuhe_o.add(mid_o);
        }
        // 初始化，将第0个数进行初始化
        List<List<List<String>>> allchar = new ArrayList<>();
        List<String> in0 = new ArrayList<>();
        in0.add(s.substring(0,1));
        List<List<String>> zu0 = new ArrayList<>();
        zu0.add(in0);
        allchar.add(zu0);

        // cdd
        for(int i = 1; i < s.length(); i++){   // 用i来表示每一个序列的长度，长度依次递增
            // eachouter 表示每一个字符串长度为i时，所有可能的组合
            List<List<String>> eachouter = new ArrayList<>();
            for(int j = 0; j <= i; j++){ // 以每一个j位置的字符作为中点，字符串一共长i，判断字符串 j-i是否存在
                List<String> inner = new ArrayList<>();
                int len = i - j;  // 0
                // 以j作为中点的奇数长度的子回文串
                int mid_j = zuhe_j.get(j);
                if(mid_j > len){
                    if(j - len < 0){
                        // 说明j不能作为最后一段奇数长度的中心
                    }else if(j - len == 0){
                        // 说明j恰好为0-i长度的奇数回文串中心
                        inner.add(s.substring(j-len, j+len + 1));
                        eachouter.add(inner);
                    }else{
                        // 说明j恰好为最后一个奇数回文段的中心，在此之前还有别的段
                        // allchar.get(j - len - 1) 是以j-len-1为长度的所有回文段的集合
                        List<List<String>> last = allchar.get(j - len - 1);
                        for(List<String> in: last){
                            List<String> tmp = new ArrayList<>();
                            tmp.addAll(in);
                            tmp.add(s.substring(j-len, j+len + 1));
                            eachouter.add(tmp);
                        }
                    } // else
                } // if(mid_j >= len)

                // 以j作为中点的偶数长度的子回文段
                if(len > 0){
                    int mid_o = zuhe_o.get(j);
                    if(mid_o >= len) {  // len = 1,mid_o = 1
                        if(j - (len-1) < 0){
                            // 说明j不能作为最后一段奇数长度的中心
                        }else if(j - (len-1) == 0){
                            // 说明j恰好为0-i长度的偶数回文串中心
                            inner.add(s.substring(j-(len-1), j+len + 1));
                            eachouter.add(inner);
                        }else{
                            // 说明j恰好为最后一个偶数回文段的中心，在此之前还有别的段
                            // allchar.get(j - (len-1) - 1) 是以j-(len-1)-1为长度的所有回文段的集合
                            List<List<String>> last = allchar.get(j - (len-1) - 1);
                            for(List<String> in: last){
                                List<String> tmp = new ArrayList<>();
                                tmp.addAll(in);
                                tmp.add(s.substring(j-(len-1), j+len + 1));
                                eachouter.add(tmp);

                            }
                        } // else
                    }
                }
            }
            allchar.add(eachouter);
        }
        return allchar.get(s.length()-1);
    }



    // 下面是对上面进行的优化，但是时间基本没有提升

    private List<Integer> zuhe_j = new ArrayList<>();
    private List<Integer> zuhe_o = new ArrayList<>();
    private List<List<List<String>>> allchar = new ArrayList<>();

    public List<List<String>> partition_youhua(String s) {

        List<List<String>> outer = new ArrayList<>();
        if(s.equals(""))return outer;


        // 其中第i个元素表示以第i个元素为中心点的所有可能的子回文串
        for(int i = 0; i < s.length(); i++){ // i表示以i位置的字符为奇偶回文串的中心
            int mid_j = 0, mid_o = 0, sign_j = 0, sign_o = 0;

            for(int len = 0; len < s.length(); len++){
                // 先判断mid为最中间的
                if(sign_j == 0 && i + len < s.length() && i - len >= 0){
                    if(s.charAt(i + len) == s.charAt(i - len)) mid_j ++;
                    else  sign_j = 1;
                }else sign_j = 1;
                // 再判断子回文串为偶数个字符
                if(sign_o == 0 && len > 0 && i + len < s.length() && i - (len-1) >=0){
                    if(s.charAt(i + len) == s.charAt(i-(len-1)))mid_o ++;
                    else sign_o = 1;
                }else if(len != 0) sign_o = 1;
                if(sign_j==1 && sign_o == 1) break;
            }
            zuhe_j.add(mid_j);
            zuhe_o.add(mid_o);
        }

        for(int i = 0; i < s.length(); i++){   // 用i来表示每一个序列的长度，长度依次递增
            List<List<String>> eachouter = new ArrayList<>();// eachouter 表示每一个字符串长度为i时，所有可能的组合
            for(int j = 0; j <= i; j++){ // 以每一个j位置的字符作为中点，字符串一共长i，判断字符串 j-i是否存在
                eachouter = addpath(0,i, j,eachouter,s); // 以j作为中点的奇数长度的子回文串
                eachouter = addpath(1,i, j, eachouter,s);// 以j作为中点的偶数长度的子回文段
            }
            allchar.add(eachouter);
        }
        return allchar.get(s.length()-1);
    }

    public List<List<String>> addpath(int jiou,int i, int j, List<List<String>> eachouter, String s){
        int len = i - j;
        List<String> inner = new ArrayList<>();
        if(jiou == 0){
            int mid_j = zuhe_j.get(j);
            int c = j - len;
            int d = j+len + 1;
            if(mid_j > len){
                if(c == 0){
                    inner.add(s.substring(c, d));
                    eachouter.add(inner);
                }else if(c > 0){
                    for(List<String> in: allchar.get(c - 1)){
                        List<String> tmp = new ArrayList<>();
                        tmp.addAll(in);
                        tmp.add(s.substring(c, d));
                        eachouter.add(tmp);
                    }
                }
            }
        }else{
            if(len > 0){
                int mid_o = zuhe_o.get(j);
                if(mid_o >= len) {
                    int a = j - len + 1;
                    int b = j+len + 1;
                    if(a == 0){
                        inner.add(s.substring(a,b ));
                        eachouter.add(inner);
                    }else if(a > 0){
                        for(List<String> in: allchar.get(j - len)){
                            List<String> tmp = new ArrayList<>();
                            tmp.addAll(in);
                            tmp.add(s.substring(a, b));
                            eachouter.add(tmp);
                        }
                    }
                }
            }
        }
        return eachouter;
    }
}

