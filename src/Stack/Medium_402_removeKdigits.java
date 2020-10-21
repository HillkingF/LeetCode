package Stack;

import java.util.Stack;

public class Medium_402_removeKdigits {
    public static void main(String[] args){
        String num = "1432219";
        int k = 3;
        String res = removeKdigits(num, k);
        System.out.println(res);

    }
    public static String removeKdigits(String num, int k) {
        String res = "";
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int strnow = 0;
        int sign = 1;
        int i = 0;
        for (i = 0; i < num.length(); i++){
            if(stack.isEmpty())
                if(num.charAt(i)!='0')stack.push(Integer.valueOf(num.charAt(i)));
            else{
                strnow = Integer.valueOf(num.charAt(i));
                if(strnow != 0) {
                    if (strnow > stack.peek()) {
                        count += 1;
                    } else if (strnow == stack.peek()) stack.push(Integer.valueOf(num.charAt(i)));
                    else {
                        while (!stack.isEmpty()) {
                            if (count < k) {
                                stack.pop();
                                count += 1;
                            } else{
                                sign = 1;
                                break;
                            }
                        }
                    }
                }else{  //此时字符为0
                    while(!stack.isEmpty()){
                        if (count < k) {
                            stack.pop();
                            count += 1;
                        } else{
                            sign = 1;
                            break;
                        }
                    }
                }
                if( sign == 0) break;

                }
        }
        while(!stack.isEmpty()){
            res = stack.pop().toString() + res;
        }
        if(i == num.length()){

        }else{
            res = res + num.substring(i);
        }
        return res;

    }
}
