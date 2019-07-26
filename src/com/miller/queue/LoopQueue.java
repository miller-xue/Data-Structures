package com.miller.queue;

public class LoopQueue<E> implements Queue<E> {
    /**
     * 存放数据数组
     */
    private E[] data;
    /**
     * 初始化 front头(第一个) tail(指向下一个元素位置)尾
     */
    private int front, tail;

    /**
     * 队列大小 可以不声明size（TODO 学完后，循环队列 尝试不写size 维护循环队列）
     */
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * O(1)
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * O(1)
     * @return
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 入队 O(1) 复杂度均摊
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
        // 如果 tail + 1 == 头 ，就表示队列已经满了
        if ((tail + 1) % data.length == front)
            resize(getCapacity() * 2);
        data[tail] = e;
        // (tail + 1) % data.length 计算出下一个 tail
        tail = (tail + 1) % data.length;
        size++;
    }


    /**
     * 出队列 O(1) 均摊
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException(" Cannot dequeue from an empty queue");
        E ret = data[front]; // 取出值
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if(size == getCapacity() /4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    /**
     * O(1)
     * @return
     */
    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException(" Cannot dequeue from an empty queue");
        return data[front];
    }

    // TODO toString  resize 两种不同的遍历方式

    private void resize(int newCapacity) {
        // 创建一个新数组 数组容量+1   1是维护环形队列的容量
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++)
            newData[i] = data[(i + front) % data.length];
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue: size = %d , capacity = %d \n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail ; i =(i + 1) % data.length) {
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LoopQueue<>();
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
