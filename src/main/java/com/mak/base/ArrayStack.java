package com.mak.base;

/**
 * Created by makai on 2018/5/29.
 */
public class ArrayStack<T> {
    private Object[] data = null;
    private int maxSize = 0; //栈容量
    private int top = -1;  //栈顶指针
    private int size = 0;

    ArrayStack() {
        this(10);
    }

    ArrayStack(int size) {
        if (size < 0) throw new RuntimeException("初始化大小不能小于0");
        this.maxSize = size;
        this.data = new Object[size];
        this.top = -1;
        this.size=0;
    }

    //入栈
    public boolean push(T t){
        if (top == maxSize -1){
            throw new RuntimeException("栈满");
        }else {
            data[++top]=t;
            size++;
            return true;
        }
    }

    //查看栈顶元素（不移除）
    public T peek(){
        if (top == -1){
            throw new RuntimeException("栈空");
        }else {
            return (T) data[top];
        }
    }

    //弹出栈顶元素
    public T pop(){
        if (top == -1){
            throw new RuntimeException("栈空");
        }else {
            size--;
            return (T) data[top--];
        }
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        stack.push("你好吗");
        stack.push("ok的");
        stack.push(5);
        while (stack.top > -1){
            System.out.println(stack.pop());
        }
    }
}
