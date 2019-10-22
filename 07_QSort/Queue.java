package storage;

public class Queue<T> {

    private Node<T> head, tail;

    public Queue() {
        head = null;
        tail = null;
    }

    public void enqueue(T item) {
        Node<T> node = new Node<T>(item);
        if (isEmpty()) {
            head = node;
            tail = head;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    public T dequeue() {
        if (isEmpty()) return null;
        T item = head.getItem();
        head = head.getNext();
        return item;
    }

    private boolean isEmpty() {
        return head == null;
    }
}
