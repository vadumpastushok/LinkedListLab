package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularLinkedListTest {

    @Test
    void length() {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        list.append("1");
        list.append("2");
        assertEquals(2, list.length());
    }

    @Test
    void append() {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        list.append("1");
        list.append("3");
        list.append("2");
        assertEquals("2", list.get(2));
    }

    @Test
    void insert() {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        list.append("1");
        list.append("2");
        list.insert("3", 1);
        assertEquals("3", list.get(1));
    }

    @Test
    void delete() {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        list.append("1");
        list.insert("2", 0);
        list.append("3");
        list.delete(1);
        assertEquals("3", list.get(1));
    }

    @Test
    void deleteAll() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.append(0);
        list.append(1);
        list.append(0);
        list.append(2);
        list.deleteAll(0);
        assertEquals(2, list.length());
    }

    @Test
    void get() {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        list.append("1");
        list.append("2");
        list.insert("3", 1);
        list.append("4");
        assertEquals("4", list.get(3));
    }

    @Test
    void reverse() {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        list.append("1");
        list.append("2");
        list.append("3");
        list.append("4");
        list.reverse();
        assertEquals("4", list.get(0));
    }

    @Test
    void findFirst() {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        list.append("1");
        list.append("0");
        list.append("2");
        list.append("0");
        assertEquals(1, list.findFirst("0"));
    }

    @Test
    void findLast() {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        list.append("1");
        list.append("0");
        list.append("2");
        list.append("0");
        assertEquals(3, list.findLast("0"));
    }

    @Test
    void clear() {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        list.append("1");
        list.append("2");
        list.clear();
        assertEquals(0, list.length());
    }

    @Test
    void extend() {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        list.append("1");
        list.append("2");
        list.append("3");
        list.append("4");

        CircularLinkedList<String> sublist = new CircularLinkedList<>();
        sublist.append("a");
        sublist.append("b");
        sublist.append("c");

        list.extend(sublist);

        sublist.insert("d", 2);

        assertEquals("b", list.get(5));
    }
}