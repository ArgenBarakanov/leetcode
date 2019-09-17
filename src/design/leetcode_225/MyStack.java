package design.leetcode_225;
//Implement the following operations of a stack using queues.
//
//        push(x) -- Push element x onto stack.
//        pop() -- Removes the element on top of the stack.
//        top() -- Get the top element.
//        empty() -- Return whether the stack is empty.
//        Example:
//
//        MyStack stack = new MyStack();
//
//        stack.push(1);
//        stack.push(2);
//        stack.top();   // returns 2
//        stack.pop();   // returns 2
//        stack.empty(); // returns false
import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private int x ;
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        x = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
        this.x = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q1.size()>1){
            x = q1.remove();
            q2.add(x);
        }
        int res = q1.remove();
        q1 = q2;
        q2 = new LinkedList<>();
        return res;
    }

    /** Get the top element. */
    public int top() {
        return this.x;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
