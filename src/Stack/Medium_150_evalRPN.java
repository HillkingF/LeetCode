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
    public int (String[] tokens) {
        Stack<Integer> stack = new Stack();
        HashMap<int> sign = 0;  // 1:+  2:-  3:*  4:/
        for(String str: tokens){
            sign = 0;

            // 字符串类型判断
            if(str.equals("+"))sign = 1;
            else if(str.equals("-")) sign = 2;
            else if(str.equals("*")) sign = 3;
            else if(str.equals("/")) sign = 4;
            else sign = 0;

            // 是否需要出栈计算  sign！= 0时
            if(sign == 0) stack.push(Integer.parseInt(str));
            else{
                stack.push(
                        stack.pop()
                )
            }


        }
    }

    public int jisuan(int sign, int a, int b){
        if(sign == 1)return 
        else if(str.equals("-")) sign = 2;
        else if(str.equals("*")) sign = 3;
        else if(str.equals("/")) sign = 4;
        else sign = 0;
    }
}
