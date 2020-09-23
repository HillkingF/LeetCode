package Stack;

import java.util.Stack;

public class Simple_232_stackToQueue {
    Stack resstack = new Stack();
    Stack helpstack = new Stack();

    public Simple_232_stackToQueue(){}

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(resstack.isEmpty()) {
            resstack.push(x);
        }else {
            while (!resstack.isEmpty()){
                helpstack.push(resstack.pop());
            }
            resstack.push(x);
            while (!helpstack.isEmpty()){
                resstack.push(helpstack.pop());
            }
        }

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int x = (int)resstack.peek();
        resstack.pop();
        return x;
    }

    /** Get the front element. */
    public int peek() {
        int x = 0;
        if(!resstack.isEmpty()) x = (int)resstack.peek();
        return x;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return resstack.isEmpty();
    }
}

class mainstack{
    public static void main(String[] args){
         Simple_232_stackToQueue obj = new Simple_232_stackToQueue();
         obj.push(1);
         int param_2 = obj.pop();
         int param_3 = obj.peek();
         boolean param_4 = obj.empty();
         System.out.print(param_3);
    }
}