package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void updateNext() {
        Node<String> node = new Node<>("data", new Node<>("data", null));
        Node<String> newNext = new Node<>("data", null);
        node.updateNext(newNext);
        assertEquals(newNext, node.getNext());
    }

    @Test
    void getData() {
        Node<String> node = new Node<>("data", new Node<>("data", null));
        assertEquals("data", node.getData());
    }

    @Test
    void getNext() {
        Node<String> next = new Node<>("data", null);
        Node<String> node = new Node<>("data", next);
        assertEquals(next, node.getNext());
    }
}