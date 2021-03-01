package Hot_100;

import java.util.ArrayList;
import java.util.List;

public class Medium_22_generateParenthesis {
    public static void main(String[] args){
        List<String> res = generateParenthesis(4);
        for(String str: res){
            System.out.println(str);
        }
        String s = "(())(())";
        System.out.print(res.contains(s));


    }
    public static List<String> generateParenthesis(int n) {
        /**
         * 动态规划的思路：
         * 设置d[i]表示n=i时的括号组合
         * 初始化 d[0]="";
         * d[n] = "(" + d[m] + ")" + d[k]
         */
        List<String> [] list = new List[n+1];
        String s = "";
        List<String> tmp = new ArrayList<>();
        tmp.add(s);
        list[0] = tmp;

        for(int i = 1; i <= n; i++){
            List<String> d = new ArrayList<>();
            for(int m = 0; m < i; m++){
                int k = i - 1 - m;
                for(String ms: list[m]){
                    for(String ks: list[k]){
                        d.add("(" + ms + ")" + ks);
                    }
                }
            }
            list[i] = d;
        }
        return list[n];
    }
}
