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
        if (head == null) {
            return;
        }
        int i = 0;
        Node<T> node = head;
        while (node != null && node.getNext() != head && i != index - 1) {
            i++;
            node = node.getNext();
        }

        if (i == index - 1 && node != null && node.getNext() != head) {
            node.updateNext(node.getNext().getNext());
        } else  if (index == 0 && head.getNext() == head) {
            head = null;
        } else if (index == 0 && node != null) {
            node.updateNext(head.getNext());
            head = head.getNext();
        }
    }

    public void deleteAll(T element) {
        if (head == null) {
            return;
        }
        if (head == element && head.getNext() == head) {
            head = null;
            return;
        }
        Node<T> node = head;
        do {
            if (node.getNext().getData() == element) {
                if (node.getNext() == head) {
                    head = node.getNext().getNext();
                }
                node.updateNext(node.getNext().getNext());
            }
            node = node.getNext();
        } while (node != head);
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

    public CircularLinkedList<T> cloneList() {
        CircularLinkedList<T> list = new CircularLinkedList<>();
        if (head == null) {
            return list;
        }
        Node<T> node = head;
        do {
            list.append(node.getData());
            node = node.getNext();
        } while (node != head);
        return list;
    }

    public void reverse() {
        if (head == null || head.getNext() == head) {
            return;
        }

        Node<T> tail = head;

        Node<T> prevNode = head;
        Node<T> node = head.getNext();
        while (node.getNext() != head) {
            Node<T> nextNode = node.getNext();
            node.updateNext(prevNode);
            prevNode = node;
            node = nextNode;
        }
        node.updateNext(prevNode);
        head = node;
        tail.updateNext(head);
    }

    public Integer findFirst(T element) {
        if (head == null) {
            return -1;
        }
        Node<T> node = head;
        int result = -1;
        int index = 0;
        do {
            if (node.getData().equals(element)) {
                result = index;
                break;
            }
            index++;
            node = node.getNext();
        } while (node != head);
        return result;
    }

    public Integer findLast(T element) {
        if (head == null) {
            return -1;
        }
        Node<T> node = head;
        int result = -1;
        int index = 0;
        do {
            if (node.getData().equals(element)) {
                result = index;
            }
            index++;
            node = node.getNext();
        } while (node != head);
        return result;
    }

    public void clear() {
        head = null;
    }

    public void extend(CircularLinkedList<T> list) {
        if (list.length() == 0) {
            return;
        }
        Node<T> node = head;
        while (node != null && node.getNext() != head) {
            node = node.getNext();
        }

        if (node == null) {
            node = new Node<>(list.get(0), null);
            head = node;
        } else {
            node.updateNext(new Node<>(list.get(0),  null));
            node = node.getNext();
        }

        for (int i = 1; i < list.length(); i++) {
            node.updateNext(new Node<>(list.get(i), null));
            node = node.getNext();
        }
        node.updateNext(head);
    }
}