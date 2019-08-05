package 双栈实现一个队列;

import java.util.Stack;

public class MyQueue {

    private Stack stack1=new Stack<Integer>();
    private Stack stack2=new Stack<Integer>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
            return (int) stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        return (int) stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {

        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        return stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */