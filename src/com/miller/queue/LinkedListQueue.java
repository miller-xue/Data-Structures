package com.miller.queue;

import java.util.NoSuchElementException;

public class LinkedListQueue<E> implements Queue<E> {

    private class Node<E> {
        public E e;
        public Node<E> next;

        public Node(E e) {
            this.e = e;
            this.next = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 链表头当作队列头，尾当作队列尾  入队出队获取都是（O(1)） 单向链表
     * 链表头尾作队列头，头当作队列尾  入队是O(1) 出队是O(N) 获取的O(1)
     * 双向链表就无所谓
     *
     */
    private Node<E> head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        // 给tail后缀节点
        Node<E> node = new Node<>(e);
        if (tail == null) {
            head = node;
            tail = node;
        } else{
            tail.next = node;
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        Node<E> retNode = head;
        head = head.next;
        retNode.next = null;
        if(head == null)
            tail = null;
        size --;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if(head == null)
            throw new NoSuchElementException("元素头节点为空");
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        Node<E> cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }


    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedListQueue<>();
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
