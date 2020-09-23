package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class Simple_225_DuilieAndStack {
    private Queue<Integer> resqueue = new LinkedList<Integer>();
    private int count = 0; //记录队列中的元素个数
    public Simple_225_DuilieAndStack() {
    }

    /** Push element x onto stack. */
    public void push(int x) {
        resqueue.offer(x);
        if(!resqueue.isEmpty()){
            for(int i = 1; i<= count; i++)resqueue.offer(resqueue.poll());
        }
        count++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        count--;
        return resqueue.poll();
    }

    /** Get the top element. */
    public int top() {
        return resqueue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return resqueue.isEmpty();
    }
}

class mainclass{
    public static void main(String[] args){
        Simple_225_DuilieAndStack obj = new Simple_225_DuilieAndStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        int x = obj.top();
        System.out.print(x);
    }
}
