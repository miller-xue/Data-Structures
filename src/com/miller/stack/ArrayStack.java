package com.miller.stack;

import com.miller.array.Array;

public class ArrayStack<E> implements Stack<E> {
    // 数组
    private Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<E>(capacity);
    }

    public ArrayStack() {
        array = new Array<E>();
    }

    /**
     * O(1)
     * @return
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * O(1)
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }


    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * O(1) 平摊
     * @return
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * O(1) 平摊
     * @return
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * O(1)
     * @return
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("stack: ");
        res.append("[");
        for (int i = 0; i < getSize(); i++) {
            res.append(array.get(i));
            if (i != getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] Top");
        return res.toString();
    }
}
