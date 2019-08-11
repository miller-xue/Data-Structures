package com.miller.stack;

/**
 * 先进先出的数据结构
 * @param <E>
 */
public interface Stack<E> {

    /**
     * 获取大小
     * @return
     */
    int getSize();

    /**
     * 查看栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 往栈顶压入一个元素
     * @param e
     */
    void push(E e);

    /**
     * 弹出一个元素
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     * @return
     */
    E peek();
}
