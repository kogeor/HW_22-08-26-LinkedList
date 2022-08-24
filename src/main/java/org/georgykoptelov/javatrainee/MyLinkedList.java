package org.georgykoptelov.javatrainee;

public class MyLinkedList {
    public  int size;
    private Object firstElement;
    private Object lastElement;

    public void add(Object item) {
        new Node(item, null, firstElement);

    }

    private class Node {
        public Node(Object element, Object next, Object prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
            if (size == 0) {
                firstElement = this;
            }
            lastElement = this;
            size++;

        }

        Object element;
        Object next;
        Object prev;
    }
}
