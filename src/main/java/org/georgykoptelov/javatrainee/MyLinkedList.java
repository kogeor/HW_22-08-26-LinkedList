package org.georgykoptelov.javatrainee;


public class MyLinkedList<T> {
    private int sizeOfList;

    public int size() {
        return sizeOfList;
    }

    private Node firstElement;
    private Node lastElement;

    public void add(T item) {
        new Node(item, null, sizeOfList == 0 ? firstElement : lastElement);
        sizeOfList++;
    }

    public void add(T item, int position) {
        if ((position <= sizeOfList) && (position >= 0)) {
            new Node(item, position == (sizeOfList) ? null : getNode(position), position == 0 ? null : getNode(position - 1));
            sizeOfList++;
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

    public void set(int position, T item) {
        if ((position <= sizeOfList) && (position >= 0)) {
            new Node(item, position == (sizeOfList) ? null : getNode(position + 1), position == 0 ? null : getNode(position - 1));
        }
    }

    public void sort() {
        quickSort(this, 0, sizeOfList - 1);
    }

    private void quickSort(MyLinkedList<T> myLinkedList, int firstPosition, int lastPosition) {
        if (firstPosition >= lastPosition) {
            return;
        } else {
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
            if (((String) myLinkedList.getElement(i)).compareTo((String) myLinkedList.getElement(pivotIndex)) <= 0) {
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

    class Node implements Comparable<Node> {
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

        @Override
        public int compareTo(Node o) {
            return ((String) this.element).compareTo((String) o.element);
        }
    }
}
