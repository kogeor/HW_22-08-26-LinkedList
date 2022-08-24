package org.georgykoptelov.javatrainee;

public class MyLinkedList {
    public int size;
    private Object firstElement;
    private Object lastElement;

    public void add(Object item) {

        firstElement = size == 0 ? item : firstElement;
                lastElement=item;
        size++;
    }

    private static class Node {
        Object element;
        Object next;
        Object prev;
    }
}
