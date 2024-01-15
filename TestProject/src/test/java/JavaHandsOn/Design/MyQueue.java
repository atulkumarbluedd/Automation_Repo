package JavaHandsOn.Design;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {

    /**
     * here we are going to implement queue using stack
     * FIFO
     * <p>
     * 1. push
     * 2.pop
     * 3. peek
     * 4. empty
     */

    private Deque<Integer> in_stk = new ArrayDeque<>();
    private Deque<Integer> out_stk = new ArrayDeque<>();

    public MyQueue() {

    }

    public int pop() {
        peek();
        return out_stk.pop();
    }

    /**
     * get the front element
     */

    public int peek() {
        /** if (out_stk.isEmpty()) this is important condition*/
        if (out_stk.isEmpty()) while (!in_stk.isEmpty()) out_stk.push(in_stk.pop());
        return out_stk.peek();
    }

    /**
     * return whether the queue is empty
     */
    public boolean empty() {
        return in_stk.isEmpty() && out_stk.isEmpty();
    }

    public void push(int x) {
        in_stk.push(x);
    }

}
