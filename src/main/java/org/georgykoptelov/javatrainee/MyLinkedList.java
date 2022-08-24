package org.georgykoptelov.javatrainee;

public class MyLinkedList {
    public int size;
    private Node firstElement;
    private Node lastElement;

    public void add(Object item) {
        new Node(item, null, size == 0 ? firstElement : lastElement);

    }

    public Object getElement(int position) {
        Node currentNode;
        currentNode = firstElement;
        while (size < position) {
            currentNode = currentNode.next;
        }
        return currentNode.element;
    }

    private class Node {
        Node next;

        Object element;
        Node prev;

        public Node(Object element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
            if (size == 0) {
                firstElement = this;
            }
            lastElement = this;
            size++;

        }
    }
}
