package offer;

import java.util.*;

// offer_38 中的解法正确,但是超出了时间限制
// 原因是重复字符没有进行剪枝
// 下面的 offer_38_youhua 进行了重复字符遍历前的剪枝优化
public class offer_38 {
    ArrayList<String> list;
    public String[] permutation(String s) {
        list = new ArrayList<>();
        dfs("", s);
        int N = list.size();
        String[] res = new String[N];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public void dfs(String part, String rest){
        if(rest.length() == 0 && !list.contains(part)){
            list.add(part);
            return;
        }

        for (int i = 0; i < rest.length(); i++) {
            if(i == rest.length()-1){
                dfs(part + rest.substring(i, i+1),
                        rest.substring(0, i));
            }else{
                dfs(part + rest.substring(i, i+1),
                        rest.substring(0, i) + rest.substring(i + 1, rest.length()));
            }
        }
    }
}

// 上面的解法是回溯的正确解法,但是超出时间限制了
// 原因是没有进行重复字符的剪枝
class offer_38_youhua {

    ArrayList<String> list;
    public String[] permutation(String s) {

        list = new ArrayList<>();
        dfs("", s);
        int N = list.size();
        String[] res = new String[N];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return  res;

    }
    public void dfs(String part, String rest){
        if(rest.length() == 0 ){
            list.add(part);
            return;
        }
        // set用于确定第x位的字符时,对重复字符进行剪枝优化
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < rest.length(); i++) {
            // 在第x位如果出现了重复字符,则直接进行剪枝
            if(set.contains(rest.charAt(i))) continue;
            if(i == rest.length()-1){
                dfs(part + rest.substring(i, i+1),
                        rest.substring(0, i));
            }else{
                dfs(part + rest.substring(i, i+1),
                        rest.substring(0, i) + rest.substring(i + 1, rest.length()));
            }
            set.add(rest.charAt(i));
        }
    }
}
