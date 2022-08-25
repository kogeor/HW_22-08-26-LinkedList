package org.georgykoptelov.javatrainee;

import java.util.Collection;

public class MyLinkedList<T extends Comparable<? super T>> {
    private int sizeOfList;
    private Node lastElement;
    private Node firstElement;

    public int size() {
        return sizeOfList;
    }

    public boolean add(T item) {
        new Node(item, null, sizeOfList == 0 ? firstElement : lastElement);
        sizeOfList++;
        return true;
    }

    public void add(int index, T element) {
        if ((index <= sizeOfList) && (index >= 0)) {
            new Node(element, index == (sizeOfList) ? null : getNode(index), index == 0 ? null : getNode(index - 1));
            sizeOfList++;
        }
    }

    public boolean addAll(int index, Collection<? extends T> collection) {
        for (var element : collection
        ) {
            this.add(index, element);
            index++;
        }
        return true;
    }

    public boolean addAll(Collection<? extends T> collection) {
        for (var element : collection
        ) {
            this.add(element);
        }
        return true;
    }

    public void addFirst(T element) {
        add(0, element);
    }

    public void addLast(T element) {
        add(sizeOfList, element);
    }

    public void clear() {
        while (firstElement != null) {
            remove(0);
        }
    }

    public T removeLast() {
        return del(lastElement);
    }
    public T removeFirst() {
        return del(firstElement);
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

    public T getElement(int position) {
        if ((position < sizeOfList) && (position >= 0))
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

    public T remove(int index) {
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

    public boolean delete(T element) {
        Node node = firstElement;
        while (node != null) {
            if (node.element.equals(element)) {
                del(node);
                return true;
            }
            node = node.next;
        }
        return false;
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

    public void set(int position, T item) {
        if ((position <= sizeOfList) && (position >= 0)) {
            new Node(item, position == (sizeOfList) ? null : getNode(position + 1), position == 0 ? null : getNode(position - 1));
        }
    }

    public void sort() {
        quickSort(this, 0, sizeOfList - 1);
    }

    private void quickSort(MyLinkedList<T> myLinkedList, int firstPosition, int lastPosition) {
        if (firstPosition < lastPosition) {
            int pivotIndex = partition(myLinkedList, firstPosition, lastPosition);
            quickSort(myLinkedList, firstPosition, pivotIndex - 1);
            quickSort(myLinkedList, pivotIndex + 1, lastPosition);
        }
    }

    private int partition(MyLinkedList<T> myLinkedList, int firstPosition, int lastPosition) {
        int pivotIndex = selectPivot(firstPosition, lastPosition);
        swap(myLinkedList, pivotIndex, lastPosition);
        int store = firstPosition;
        pivotIndex = lastPosition;
        for (int i = firstPosition; i <= lastPosition - 1; i++) {
            if ((myLinkedList.getElement(i)).compareTo(myLinkedList.getElement(pivotIndex)) <= 0) {
                swap(myLinkedList, i, store);
                store++;
            }
        }
        swap(myLinkedList, store, pivotIndex);
        pivotIndex = store;
        return pivotIndex;
    }

    private void swap(MyLinkedList<T> myLinkedList, int x, int y) {
        T temp = myLinkedList.getElement(x);
        myLinkedList.set(x, myLinkedList.getElement(y));
        myLinkedList.set(y, temp);
    }

    private int selectPivot(int first, int last) {
        return (first + last) / 2;
    }

    class Node {
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

        }

    }
}
