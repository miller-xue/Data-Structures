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
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(e, first);
        first = newNode;
        if (f == null) {
            last = newNode;
        }
        size++;
    }

    public void addLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node(e);
        last = newNode;
        if (l == null) {
            first = newNode;
        }else {
            last.next = newNode;
        }
        size++;
    }

    public void add(E e) {
        addLast(e);
    }

    public void add(int index, E e) {
        final Node<E> newNode = new Node<>(e);
        if (index == size) {
            addLast(e);
        } else {

        }
    }

    public E removeFirst() {
        final Node<E> f = first;
        if(f == null)
            throw new NoSuchElementException();
        final E element = f.e;
        first = f.next;
        f.next = null;
        // TODO 复杂。涉及多
        return element;
    }

    public E removeLast() {
        final Node<E> l = last;
        if(l == null)
            throw new NoSuchElementException();
        // 得需要找到 最后一个的上一个 单向链表的复杂就是O(N) 双向链表就是O(1)
        // TODO
        return null;
    }


    public int size() {
        return size;
    }

    public E getFirst() {
        final Node<E> f = first;
        if(f == null)
            throw new NoSuchElementException();
        return f.e;
    }

    public E getLast() {
        final Node<E> l = last;
        if (last == null)
            throw new NoSuchElementException();
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
