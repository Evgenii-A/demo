package com.home.demo.stack;

import lombok.Data;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;

@Data
@Getter
public class Stack<T> {

    public AtomicInteger count = new AtomicInteger(0);
    private Node header = null;

    @Getter
    private class Node {
        T value;
        Node previous;

        public Node(T value, Node previous) {
            this.value = value;
            this.previous = previous;
        }
    }

    public void push(T t) {
        Node node = new Node(t, header);
        header = node;
        count.incrementAndGet();
    }

    public T peek() {
        T retVal = header.value;
        header = header.previous;
        return retVal;
    }

    public void method() {
        for (int i = 0; i < 101; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("fooboo");
            } else if (i % 3 == 0) {
                System.out.println("foo");
            } else if (i%5 == 0) System.out.println("boo");
            else System.out.println(i);
        }
    }
}

class MyClass {
    @SneakyThrows
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    stack.push(Thread.currentThread().getName() + " " + i);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                stack.push(Thread.currentThread().getName() + " " + i);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();


        System.out.println(stack.count.get());
    }
}

