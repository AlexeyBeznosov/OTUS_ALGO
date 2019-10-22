package storage;

public class Node<T> {

    private T item;
    private Node<T> next;

    Node(T item) {
        this(item, null);
    }

    Node(T item, Node<T> next) {
        this.item = item;
        this.next = next;
    }

    void setItem(T item) {
        this.item = item;
    }

    void setNext(Node<T> next) {
        this.next = next;
    }

    T getItem() {
        return item;
    }

    Node<T> getNext() {
        return next;
    }
}
