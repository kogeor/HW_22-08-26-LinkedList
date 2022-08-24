package org.georgykoptelov.javatrainee;

public class MyLinkedList {
    public int size;
    private Node firstElement;
    private Node lastElement;

    public void add(Object item) {
        new Node(item, null, size == 0 ? firstElement : lastElement);
    }

    public void add(Object item, int position) {
        if (position <= size) {
            new Node(item, position == (size) ? null : getNode(position), position == 0 ? null : getNode(position - 1));
        }
    }

    public Object getElement(int position) {
        if (position < size)
            return getNode(position).element;
        else return null;
    }

    private Node getNode(int itemPosition) {
        Node currentNode;
        currentNode = firstElement;
        int position = 0;
        while (position < itemPosition) {
            currentNode = currentNode.next;
            position++;
        }
        return currentNode;
    }

    public void showList() {
        int item = 0;
        while (item < size) {
            System.out.println(getElement(item));
            item++;
        }
        System.out.println();
    }

    private class Node {
        Node next;

        Object element;
        Node prev;

        public Node(Object element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
            if (this.prev == null)
                firstElement = this;
            else
                prev.next = this;
            if (this.next != null)
                next.prev = this;
            else
                lastElement = this;
            size++;

        }
    }
}
