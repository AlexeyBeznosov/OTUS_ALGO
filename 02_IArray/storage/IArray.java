package storage;

public interface IArray<T> {

    void add(T item);

    T get(int index);

    int size();

    void add(T item, int index);

    T remove(int index);
}
