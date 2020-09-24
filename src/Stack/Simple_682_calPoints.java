package Stack;

import java.util.Stack;

public class Simple_682_calPoints {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();
        int temp1 = 0;
        int temp = 0;
        for(String stri: ops){
            switch (stri){
                case "C":
                    if(!stack.isEmpty()) stack.pop();
                    break;
                case "D":
                    if(stack.isEmpty()) stack.push(0);
                    else stack.push((int)stack.peek() * 2);
                    break;
                case "+":
                    if(!stack.isEmpty()){
                        temp1 = 0;
                        temp = (int)stack.pop();
                        if(!stack.isEmpty()) temp1 = (int)stack.peek();
                        stack.push(temp);
                        stack.push(temp + temp1);
                    }else stack.push(0);
                    break;
                default:
                    stack.push(Integer.parseInt(stri));
            }
        }
        temp1 = 0;
        while(!stack.isEmpty()){
            temp1 = temp1 + (int)stack.pop();
        }
        return temp1;
    }
}
