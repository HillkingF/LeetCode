package Hot_100;

public class Hard_32_longestValidParentheses {
    public static void main(String[] args){
        String s = "())((())(())()())";
        int res = longestValidParentheses(s);
        System.out.println(res);
    }
    public static int longestValidParentheses(String s) {
        if(s.equals("")) return 0;
        int[] f = new int[s.length()];  // f[i]=j;其中i表示第i个字母为一对括号的结尾标志，j表示第j位置与第i位置可以匹配一对括号
        int i = 0, j = 0;

        for(i = 0; i < s.length(); i++){
            f[i] = -1;
            if(s.charAt(i) == '(') f[i] = -1;
            else{
                j = i - 1;
                while(j >= 0){
                    if(f[j] != -1)  j = f[j] - 1;
                    else{
                        if(s.charAt(j) == '(')
                            f[i] = j;
                        break;
                    }
                }
            }
        }
        int max = 0;
        for (i = 0; i < s.length() ; i++) {
            j = i;
            while(j >= 0 && f[j] != -1){
                if(i-(f[j] - 1) > max) max = i - (f[j] - 1);
                j = f[j] - 1;
            }
        }
        return max;
    }
}
