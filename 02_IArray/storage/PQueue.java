package storage;

public class PQueue<T> {

    private SingleArray<Queue<T>> array;

    public PQueue() {
        array = new SingleArray<>();
    }

    public void enqueue(int priority, T item) {
        if (priority >= array.size()) {
            for (int i = array.size(); i <= priority; i++) {
                array.add(new Queue<T>());
            }
        }
        array.get(priority).enqueue(item);
    }

    public T dequeue() {
        int priority = 0;
        T temp;
        while (priority < array.size()) {
            temp = array.get(priority).dequeue();
            if (temp != null) {
                return temp;
            }
            priority++;
        }
        return null;
    }
}
