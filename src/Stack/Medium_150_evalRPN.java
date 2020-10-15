package Stack;

// 逆波兰表达式求值

import java.util.Stack;

/**
 * 逆波兰表达式：
 *
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 *
 *     平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 *     该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 *
 * 逆波兰表达式主要有以下两个优点：
 *
 *     去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 *     适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。
 *
 */

public class Medium_150_evalRPN {
    public static void main(String[] args){
        String[] tokens = {"4", "13", "5", "/", "+"};
        int a = evalRPN(tokens);
        System.out.print(a);
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        int a;
        int b;

        for(String str: tokens){

            // 字符串类型判断
            if(str.equals("+")){
                a = stack.pop();
                b = stack.pop();
                stack.push(b + a);
            }
            else if(str.equals("-")){
                a = stack.pop();
                b = stack.pop();
                stack.push(b - a);
            }
            else if(str.equals("*")){
                a = stack.pop();
                b = stack.pop();
                stack.push(b * a);
            }
            else if(str.equals("/")){
                a = stack.pop();
                b = stack.pop();
                stack.push(b / a);
            }
            else stack.push(Integer.parseInt(str));
        }
        return stack.pop();
    }
    public static  int jisuan(int sign, Integer b, Integer a){
        if(sign == 1)return a + b;
        else if(sign == 2) return a - b;
        else if(sign == 3) return a * b;
        else if(sign == 4) return a/b;
        else return 0;
    }
}
