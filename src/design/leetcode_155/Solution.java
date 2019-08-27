package design.leetcode_155;

import java.util.Stack;
//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//        push(x) -- Push element x onto stack.
//        pop() -- Removes the element on top of the stack.
//        top() -- Get the top element.
//        getMin() -- Retrieve the minimum element in the stack.
//
//
//        Example:
//
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        minStack.getMin();   --> Returns -3.
//        minStack.pop();
//        minStack.top();      --> Returns 0.
//        minStack.getMin();   --> Returns -2.
public class Solution {
}
class MinStack {
    Stack<Integer> stack=new Stack<>();
    int min=Integer.MAX_VALUE;
    public void push(int x) {
        if(x<=min) {stack.push(min); min=x;}//если то что нужно добавить меньше минимума то обновляем мин и сначала пихаем бывший мин потом новый
        stack.push(x);
    }
    public void pop() {
        if(stack.peek()==min){ stack.pop(); min=stack.pop(); }//если вытаскиваемый элемент равен минимуму надо обновить его
        else stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return min;
    }
}
