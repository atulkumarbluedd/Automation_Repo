package JavaHandsOn.Design;

import io.cucumber.java.sl.In;

import java.util.LinkedList;
import java.util.Queue;

public class mystack {
    /**
     * *******************LIFO ***************
     * this class will implement using 2 queues
     * Here pop and top is costly
     *
     * 1. push  : void
     * 2. pop  : int
     * 3. empty : boolean
     * 4. top   : int
     */
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();


    public mystack() {

    }

    public void push(int k) {
        q1.offer(k);

    }

    public int pop() {
        /** keep on popping and leave last element*/

        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        int popped = q1.poll();
        while (!q2.isEmpty()) q1.offer(q2.poll());
        return popped;

    }

    public boolean empty() {

        return q1.isEmpty() && q2.isEmpty();
    }

    public int top() {
        while (q1.size() > 1) q2.offer(q1.poll());
        int top_el = q1.poll();
        while (!q2.isEmpty()) q1.offer(q2.poll());
        /* one additional line we will put is as we need
        not to remove the element from top it's just to show*/
        q1.offer(top_el);
        return top_el;
    }
}
