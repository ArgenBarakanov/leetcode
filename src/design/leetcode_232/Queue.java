package design.leetcode_232;

import java.util.Stack;
//Implement the following operations of a queue using stacks.
//
//        push(x) -- Push element x to the back of queue.
//        pop() -- Removes the element from in front of queue.
//        peek() -- Get the front element.
//        empty() -- Return whether the queue is empty.
//        Example:
//
//        MyQueue queue = new MyQueue();
//
//        queue.push(1);
//        queue.push(2);
//        queue.peek();  // returns 1
//        queue.pop();   // returns 1
//        queue.empty(); // returns false
public class Queue {
    private int top;
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public Queue() {
        top =0;
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    /** Push element x to the back of queue. */
    public void push(int x) {

        while(!s1.empty()){
            s2.push(s1.pop());
        }
        s2.push(x);
        while(!s2.empty()){
            s1.push(s2.pop());
        }
        if(!s1.empty()) this.top = s1.peek();

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int res = s1.pop();
        if(!s1.empty()){
            this.top = s1.peek();
        }
        return res;
    }

    /** Get the front element. */
    public int peek() {

        return top;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.empty();
    }
}
