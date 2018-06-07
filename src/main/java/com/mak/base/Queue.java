package com.mak.base;

import java.util.Arrays;

/**
 * 队列
 * Created by makai on 2018/6/6.
 */
public class Queue<T> {

    private Object[] data;
    private int front; //队列头，允许删除
    private int rear; //队列尾，允许插入
    private int maxSize; //队列容量

    public Queue() {
        new Queue<>(10);
    }

    public Queue(int maxSize) {
        if (maxSize >= 0) {
            this.data = new Object[maxSize];
            this.rear = this.front = 0;
            this.maxSize = maxSize;
        } else {
            throw new RuntimeException("初始化大小不能小于0");
        }
    }

    public boolean isEmpty() {
        return front == rear ? true : false;
    }

    public boolean add(T t) {
        if (rear == maxSize) {
            throw new RuntimeException("队列已满，无法插入新元素");
        } else {
            data[rear++] = t;
            return true;
        }
    }

    //返回队列首元素但不删除
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            return (T) data[front];
        }
    }

    //出队
    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            T value = (T) data[front]; //保留队列front端元素
            data[front++] = null; //释放队列front端元素
            return value;
        }
    }

    public int length() {
        return rear - front;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "data=" + Arrays.toString(data) +
                ", front=" + front +
                ", rear=" + rear +
                ", maxSize=" + maxSize +
                '}';
    }

    public static void main(String[] args) {
        Queue queue = new Queue(10);
        System.out.println(queue.length());
        System.out.println(queue.isEmpty());
        queue.add("hello");
        queue.add(" ");
        queue.add("world");
        queue.add("!");
        System.out.println(queue.length());
        System.out.println(queue.isEmpty());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.length());
        System.out.println(queue);
    }
}
