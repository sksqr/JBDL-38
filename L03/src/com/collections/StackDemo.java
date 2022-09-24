package com.collections;

import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.add(1);
        stack.add(2);
        stack.add(3);

        stack.push(4);

        System.out.println(stack.pop());

        System.out.println(stack.pop());
    }
}
