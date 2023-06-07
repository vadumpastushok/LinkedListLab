package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CircularLinkedList<T> {

    private final List<T> myList = new ArrayList<>();

    public Integer length() {
        return myList.size();
    }

    public void append(T element) {
        myList.add(element);
    }

    public void insert(T element, Integer index) {
        myList.add(index, element);
    }

    public void delete(int index) {
        myList.remove(index);
    }

    public void deleteAll(T element) {
        myList.removeIf(it -> it == element);
    }

    public T get(int index) {
        return myList.get(index);
    }

    public CircularLinkedList<T> cloneList() {
        CircularLinkedList<T> newList = new CircularLinkedList<>();
        myList.forEach(newList::append);
        return newList;
    }

    public void reverse() {
        Collections.reverse(myList);
    }

    public Integer findFirst(T element) {
        return myList.indexOf(element);
    }

    public Integer findLast(T element) {
        return myList.lastIndexOf(element);
    }

    public void clear() {
        myList.clear();
    }

    public void extend(CircularLinkedList<T> list) {
        for (int i = 0;i < list.length(); i++) {
            myList.add(list.get(i));
        }
    }
}