package com.miller.linkedlist;

public class LinkedList<E> {
    private Node<E> first;
    private Node<E> last;

    private int size;

    public LinkedList() {
        this.first = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        first = new Node(e, first);
        size++;
    }

    public void add(int index, E e) {
        if(index< 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        if(index == 0)
            addFirst(e);
        else if (index == size)
            addLast(e);
        else {
            Node prev = first;
            for (int i = 0; i < index - 1; i++)
                prev = prev.next;
            prev.next = new Node(e, prev.next);
            size++;
        }
    }

    public void addLast(E e) {
        last.next = new Node(e);
        last = last.next;
        size++;
    }

    private class Node<E> {
        public E e;
        public Node next;

        public Node(E e, Node next) {
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
