package Stack;

import java.util.Stack;

public class Simple_1021_removeOuterParentheses {
    public String removeOuterParentheses(String S) {
        Stack<String> match =  new Stack();
        int left = 0;
        String res = "";
        String temp = "";
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i)=='('){
                match.push("(");
                left++;
            }else{
                left--;
                if(left != 0) match.push(")");
                else{
                    while(!match.isEmpty()) temp = temp + match.pop();
                    res = res + new StringBuilder(temp.substring(0, temp.length()-1)).reverse().toString();
                    temp = "";
                }
            }
        }
        return res;

    }
}
