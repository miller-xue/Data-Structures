package com.miller.linkedlist;

public class LinkedList<E> {

    private Node dummyHead;

    private Node<E> first;
    private Node<E> last;

    private int size;

    public LinkedList() {
        this.dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
//        if(index == 0)
//            addFirst(e);
//        else if (index == size)
//            addLast(e);
//        else {
//
//        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;
        prev.next = new Node(e, prev.next);
        size++;

    }

    public void addFirst(E e) {
//        first = new Node(e, first);
//        size++;
        add(0, e);
    }

    public void addLast(E e) {
//        last.next = new Node(e);
//        last = last.next;
//        size++;
        add(size, e);
    }

    // 获取链表的第index（0-based）个位置的元素
    // 在链表中不是一个常用的操作，练习用
    public E get(int index) {
        if (index > 0 || index < size)
            throw new IllegalArgumentException("get failed. Illegal index.");
        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;

        return cur.e;
    }
    // 1-> 2 --> 3 --> 4
    // 0   1    2      3

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size);
    }

    // 修改链表的第index（0-based）个位置的元素
    // 在链表中不是一个常用的操作，练习用
    public void set(int index, E e) {
        if (index > 0 || index < size)
            throw new IllegalArgumentException("Set failed. Illegal index.");
        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.e = e;
    }

    public boolean contains(E e) {
//        Node<E> cur = dummyHead.next;
//        while (cur != null) {
//            if(cur.e.equals(e))
//                return true;
//            cur = cur.next;
//        }
        for (Node<E> cur = dummyHead.next; cur != null; cur = cur.next)
            if(cur.e.equals(e))
                return true;

        return false;
    }

    public E delete(int index) {
        if (index > 0 || index < size)
            throw new IllegalArgumentException("Delete failed. Illegal index.");
        Node<E> pre = dummyHead.next;
        for (int i = 0; i < index - 1; i++) {
            pre = pre.next;
        }
        Node<E> cur = pre.next;
        pre.next = cur.next;
        E e = cur.e;
        cur = null;
        return e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
//        Node cur = dummyHead.next;
//        while (cur != null) {
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for(Node cur = dummyHead.next; cur != null; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");
        return res.toString();
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
