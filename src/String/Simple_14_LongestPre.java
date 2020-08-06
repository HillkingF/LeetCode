package String;

public class Simple_14_LongestPre {
    public static void main(String[] args){
        String[] strs = {"flower","flow","flight"};
        String s = longestCommonPrefix1(strs);
        System.out.print(s);


    }
    public static String longestCommonPrefix(String[] strs) {
        char s;
        String res = "";
        int sign = 0;

        if(strs.length == 0 || strs == null) return "";
        if(strs.length == 1) return strs[0];

        for(int i = 0; i < strs[0].length(); i++){
            s = strs[0].charAt(i);
            for(int num = 1; num < strs.length; num++){
                if(strs[num].length()-1 >= i){
                    if(strs[num].charAt(i) != s){
                        sign = 1;
                        break;
                    }
                }else{
                    sign = 1;
                    break;
                }
            }
            if(sign == 1){
                res = strs[0].substring(0, i);
                break;
            }
        }
        if (sign == 0){
            res = strs[0];
        }
        return res;
    }

    /**
     * 对方法  longestCommonPrefix() 的优化
     */
    public static String longestCommonPrefix1(String[] strs) {
        char s;
        if(strs.length == 0 || strs == null) return "";
        for(int i = 0; i < strs[0].length(); i++){
            s = strs[0].charAt(i);
            for(int num = 1; num < strs.length; num++){
                if(strs[num].length()-1 < i || strs[num].charAt(i) != s)
                        return strs[0].substring(0, i);
                }
        }
        return strs[0];
    }
}
