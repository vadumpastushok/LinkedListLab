package org.example;

public class CircularLinkedList<T> {

    private Node<T> head;

    public Integer length() {
        if (head == null) {
            return 0;
        }

        Node<T> node = head;
        int length = 1;
        while (node != null && node.getNext() != head) {
            length++;
            node = node.getNext();
        }
        return length;
    }

    public void append(T element) {
        if (head == null) {
            head = new Node<T>(element, null);
            head.updateNext(head);
            return;
        }

        Node<T> node = head;
        while (node.getNext() != head) {
            node = node.getNext();
        }

        Node<T> newNode = new Node<>(element, head);
        node.updateNext(newNode);
    }

    public void insert(T element, Integer index) {
        if (index < 0 || index > length()) {
            throw new IndexOutOfBoundsException("incorrect index");
        }
        if (head == null) {
            head = new Node<T>(element, null);
            head.updateNext(head);
            return;
        }

        Node<T> node = head;
        int i = 0;
        while (i != index - 1 && node.getNext() != head) {
            i++;
            node = node.getNext();
        }

        if (i == index - 1) {
            Node<T> newNode = new Node<>(element, node.getNext());
            node.updateNext(newNode);
        } else if (index == 0) {
            head = new Node<>(element, head);
            node.updateNext(head);
        }
    }

    public void delete(Integer index) {

    }

    public void deleteAll(T element) {

    }

    public T get(Integer index) {
        int i = 0;
        Node<T> node = head;
        while (node != null && node.getNext() != head && i < index) {
            i++;
            node = node.getNext();
        }
        if (node == null || i != index) {
            throw new IndexOutOfBoundsException("incorrect index");
        } else {
            return node.getData();
        }
    }

    public CircularLinkedList<T> clone() {
        return this;
    }

    public void reverse() {

    }

    public Integer findFirst(T element) {
        return 0;
    }

    public Integer findLast(T element) {
        return 0;
    }

    public void clear() {
        head = null;
    }

    public void extend(CircularLinkedList<T> list) {

    }

}
