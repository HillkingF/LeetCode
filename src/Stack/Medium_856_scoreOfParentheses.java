package Stack;

import java.util.Stack;

public class Medium_856_scoreOfParentheses {
    public static void main(String[] args){
        String S =  "()()";
        int res = scoreOfParentheses(S);
        System.out.print(res);

    }
    public static int scoreOfParentheses(String S) {
        /** 题目
         * () 得 1 分。  设为 A 情况，栈不空，则A入栈。A是计算后的字符串1
         * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。   设为
         * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
         */
        Stack<String> stack = new Stack<>();
        int tmp = 0;
        for(int i = 0; i < S.length(); i++){
            if(S.substring(i, i+1).equals("(")){
                stack.push(S.substring(i, i+1));
            }else if(S.substring(i, i+1).equals(")")){
                while(!stack.isEmpty()){
                    if(stack.peek().equals("(")){
                        stack.pop();
                        if(tmp == 0){  tmp = 1; }
                        else{  tmp = 2 * tmp;  }
                        break;
                    }else{  //说明栈顶是一个数字
                        if(tmp == 0){  tmp = Integer.parseInt(stack.pop()); }
                        else{ tmp = tmp + Integer.parseInt(stack.pop());}
                    }
                }
                stack.push(String.valueOf(tmp));
            }
            tmp = 0;
        }
        while (!stack.isEmpty()){ tmp = tmp + Integer.parseInt(stack.pop());  }
        return tmp;

    }
}
