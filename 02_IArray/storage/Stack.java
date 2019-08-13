package storage;

public class Stack<T> {

    private Node<T> head = null;

    public Stack() {
        head = null;
    }

    public void push(T item) {
        head = new Node<T>(item, head);
    }

    public T pop() {
        if (isEmpty()) return null;
        T item = head.getItem();
        head = head.getNext();
        return item;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
