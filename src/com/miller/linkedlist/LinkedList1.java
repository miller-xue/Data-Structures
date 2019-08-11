package com.miller.linkedlist;

import java.util.NoSuchElementException;

/**
 * 没有虚拟头节点的链表
 * 单向链表
 */
public class LinkedList1<E> {

    private Node<E> first;

    private Node<E> last;

    private int size;


    public LinkedList1() {
        first = null;
        last = null;
        size = 0;
    }

    public void addFirst(E e) {
        first = new Node<>(e, first);
        size++;
    }

    public void addLast(E e) {
        final Node<E> l = last;
        Node<E> newNode = new Node(e, null);
        if (first == null) {
            first = newNode;
        } else if (l == null) {
            first.next = last;
            last = newNode;
        }
        size++;
    }

    public int getSize() {
        return size;
    }

    public E getLast() {
        Node<E> l = last;
        if (last == null) {
            throw new NoSuchElementException("没有最后一个元素");
        }
        return l.e;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    private class Node<E> {
        public E e;
        public LinkedList1.Node next;

        public Node(E e, LinkedList1.Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
