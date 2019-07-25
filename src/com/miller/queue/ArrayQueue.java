package com.miller.queue;

import com.miller.array.Array;

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    /**
     * 传入默认容积
     * @param capacity 初始容量
     */
    public ArrayQueue(int capacity) {
        this.array = new Array<>(capacity);
    }

    /**
     * 默认无参构造
     */
    public ArrayQueue() {
        this.array = new Array<>();
    }

    /**
     * O(1)
     * @param e
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }
    /**
     * O(n)
     * @return
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * O(1)
     * @return
     */
    @Override
    public E getFront() {
        return array.getFirst();
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
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * O(1)
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < getSize(); i++) {
            res.append(array.get(i));
            if(i != getSize() -1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

}
