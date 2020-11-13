package Stack;

import java.util.Stack;

public class Medium_735_asteroidCollision {
    public static void main(String[] args){
        int[] ast = {8, -8};

        int[] res = asteroidCollision(ast);
        for(int i: res){
            System.out.println(i);
        }
    }

    // 考虑特殊情况，前一个向左，后一个像右，需要判断一下！！！
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int pre = 0;
        int now = 0;
        int signin = 0;
        for(int i: asteroids){
            now = i > 0? 1: 0;
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                while(!stack.isEmpty() ){
                    pre = stack.peek() > 0 ? 1: 0;  //上一个
                    if(pre + now == 1 && pre == 1){
                        if(Math.abs(i) > Math.abs(stack.peek())){
                            stack.pop();
                        }else if(Math.abs(i) == Math.abs(stack.peek())){
                            stack.pop();
                            signin = 1;
                            break;
                        }else{
                            signin = 1;
                            break;
                        }
                    }else{
                        signin = 0;
                        break;
                    }
                }
                if(signin == 0){
                    stack.push(i);
                }
                signin = 0;

            }

        }
        Stack<Integer> stack1 = new Stack<>();
        int j = 0;
        while(!stack.isEmpty()){
            j++;
            stack1.push(stack.pop());
        }
        int[] res = new int[j];
        j = 0;
        while(!stack1.isEmpty()){
            res[j] = stack1.pop();
            j++;
        }
        return res;
    }
}
