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
    void get() {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        list.append("1");
        list.append("2");
        list.insert("3", 1);
        list.append("4");
        assertEquals("4", list.get(3));
    }

    @Test
    void clear() {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        list.append("1");
        list.append("2");
        list.clear();
        assertEquals(0, list.length());
    }
}