package Stack;

import javax.swing.*;
import java.util.Stack;

public class Simple_155_MinStack {

}


class MinStack {
    private Stack<Integer> datastack;
    private Stack<Integer> helpstack;   //辅助栈一直保存当前最小值


    /** initialize your data structure here. */
    public MinStack() {
        datastack = new Stack<>();
        helpstack = new Stack<>();
    }

    public void push(int x) {
        datastack.push(x);
        if(helpstack.empty() || x <= helpstack.peek() ){
            helpstack.push(x);
        }else{
            helpstack.push(helpstack.peek());
        }
    }

    public void pop() {
        if(! datastack.empty()){
            datastack.pop();
            helpstack.pop();
        }
    }

    public int top() {
        if(! datastack.empty()){
            return datastack.peek();
        }
        else return 0;
    }

    public int getMin() {
        return helpstack.peek();
    }
}


