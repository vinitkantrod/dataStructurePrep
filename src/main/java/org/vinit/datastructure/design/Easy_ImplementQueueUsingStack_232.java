package org.vinit.datastructure.design;

import java.util.Stack;

public class Easy_ImplementQueueUsingStack_232 {

    static class MyQueue {

        private Stack<Integer> s1 = new Stack<>();
        private Stack<Integer> s2 = new Stack<>();
        int front;
        public MyQueue() {
        }

        public void push(int x) {
            if (s1.empty())
                front = x;
            s1.push(x);
        }

        public int pop() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty())
                    s2.push(s1.pop());
            }
            return s2.pop();
        }

        public int peek() {
            if (!s2.isEmpty()) {
                return s2.peek();
            }
            return front;
        }

        public boolean empty() {
            return s1.isEmpty() && s2.empty();
        }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.peek();
        System.out.println(q.pop());
        System.out.println(q.empty());
        System.out.println(q.pop());
        System.out.println(q.empty());
    }
}
