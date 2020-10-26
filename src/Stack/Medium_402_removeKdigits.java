package Stack;

import java.util.Stack;

public class Medium_402_removeKdigits {
    public static void main(String[] args){
        String num = "10";
        int k = 1;
        String res = removeKdigits(num, k);
        System.out.println(res);

    }

    /**
     *思路：
     * 从左到右遍历
     * 每一个字符跟栈顶比较，如果栈顶大，则出栈（删除），否则入栈
     * 如果从某个时刻单调递增了，则直接从后面删除依次删除即可
     */
    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack();
        int count = 0;
        for(int i = 0; i < num.length(); i++){
            if(count < k){
                while(!stack.isEmpty()) {
                    if (stack.peek() > num.charAt(i) && count < k) {
                        stack.pop();
                        count++;
                    } else {
                        break;
                    }
                }
                if(stack.isEmpty() && num.charAt(i) == '0'){

                }else{
                    stack.push(num.charAt(i));

                }

            }else{
                if(stack.isEmpty() && num.charAt(i) == '0'){

                }else{
                    stack.push(num.charAt(i));
                }

            }
        }
        String res = "";
        if(stack.isEmpty()) res = "0";
        while(!stack.isEmpty()){
            res = stack.pop().toString() + res;
        }
        if(count < k){
            int cha = k-count;
            if(res.length() > cha){
                res = res.substring(0, res.length()-cha);
            }else{
                res = "0";
            }
        }
        return res;

    }
}
