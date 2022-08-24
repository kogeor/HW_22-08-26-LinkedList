package org.georgykoptelov.javatrainee;

public class MyLinkedList<T> {
    private int sizeOfList;
    public int size()
    {
        return sizeOfList;
    }

    private Node firstElement;
    private Node lastElement;

    public void add(T item) {
        new Node(item, null, sizeOfList == 0 ? firstElement : lastElement);
    }

    public void add(T item, int position) {
        if ((position <= sizeOfList) && (position >= 0)) {
            new Node(item, position == (sizeOfList) ? null : getNode(position), position == 0 ? null : getNode(position - 1));
        }
    }

    public T getElement(int position) {
        if ((position < sizeOfList) && (position >= 0))
            return getNode(position).element;
        else return null;
    }

    public T getFirst() {
        if (firstElement != null)
            return firstElement.element;
        else
            return null;
    }

    public T getLast() {
        if (lastElement != null)
            return lastElement.element;
        else
            return null;
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

    public T deleteByIndex(int index) {
        if ((index < sizeOfList) && (index >= 0)) {
            Node node = getNode(index);
            return del(node);
        } else return null;
    }

    private T del(Node node) {
        if (node.prev != null)
            node.prev.next = node.next;
        else
            firstElement = node.next;
        if (node.next != null)
            node.next.prev = node.prev;
        else
            lastElement = node.prev;
        sizeOfList--;
        return node.element;
    }

    public T delete(String element) {
        Node node = firstElement;
        while (node != null) {
            if (node.element.equals(element)) {
                return del(node);
            }
            node = node.next;
        }
        return null;
    }

    public void showList() {
        int item = 0;
        while (item < sizeOfList) {
            System.out.println(getElement(item));
            item++;
        }
    }

    public int indexOf(String element) {
        int position=0;
        Node node=firstElement;
        while (node != null) {
            if (node.element.equals(element)) {

                return position;
            }
            position++;
            node = node.next;
        }
        return -1;
    }

    public boolean contains(T element) {

        Node node = firstElement;
        while (node != null) {
            if (node.element.equals(element)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void clear() {
        while (firstElement != null) {
            deleteByIndex(0);
        }
    }

    private class Node {
        Node next;
        T element;
        Node prev;

        public Node(T element, Node next, Node prev) {
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
            sizeOfList++;

        }
    }
}
