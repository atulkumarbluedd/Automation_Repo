package JavaHandsOn.Design;

import java.util.Stack;

public class MyQueue2 {
    /**
     * here we are going to implement queue using stack
     * FIFO
     * 1. push
     * 2.pop
     * 3. peek
     * 4. empty
     */
    private Stack<Integer> first = new Stack<>();
    private Stack<Integer> second = new Stack<>();
    public MyQueue2() {

    }

    public void push(int x) {
      first.push(x);
    }

    public int pop() {
        while (!first.isEmpty()) second.push(first.pop());
        int popped=second.pop();
        while (!second.isEmpty()) first.push(second.pop());
        return popped;
    }

    public int peek() {
        while (!first.isEmpty()) second.push(first.pop());
        int peeked=second.peek();
        while (!second.isEmpty()) first.push(second.pop());
        return peeked;
    }

    public boolean empty() {
        return first.isEmpty() && second.isEmpty();

    }
}
