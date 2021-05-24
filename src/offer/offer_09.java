package offer;

import jdk.nashorn.internal.runtime.regexp.joni.constants.StackPopLevel;

import java.util.Stack;

public class offer_09 {
}


class CQueue {
    /* 用两个栈来建立一个队列:
    * 如果是入队列操作,则直接将元素压入instack
    * 如果是出队操作:
    * - 先判断outstack队列有没有元素,如果有则直接出栈;
    * - 如果没有,判断instack有没有元素,如果没有直接返回-1,
    * - 如果instack有元素,则将所有instack的元素出栈并压入outstack中
    * 最后从outstack中出栈一个元素
    * */
    private Stack<Integer> instack;
    private Stack<Integer> outstack;

    public CQueue() {
        instack = new Stack<>();
        outstack = new Stack<>();
    }

    public void appendTail(int value) {
        instack.push(value);
    }

    public int deleteHead() {
        if(outstack.isEmpty()){
            if(instack.isEmpty()) return -1;
            while(!instack.isEmpty()){
                outstack.push(instack.pop());
            }
            return outstack.pop();
        }else{
            return outstack.pop();
        }
    }
}


/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */