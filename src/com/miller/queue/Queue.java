package com.miller.queue;

public interface Queue<E> {
    /**
     * 入队
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     * @return
     */
    E dequeue();

    /**
     * 获得队首
     * @return
     */
    E getFront();

    /**
     * 获取队列大小
     * @return
     */
    int getSize();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();
}
