package storage;

public class MatrixArray<T> implements IArray<T> {

    private IArray<IArray<T>> array;
    private int size;
    private int vector;

    public MatrixArray() {
        this(100);
    }

    public MatrixArray(int vector) {
        this.vector = vector;
        array = new SingleArray<>();
        size = 0;
    }

    @Override
    public void add(T item) {
        if (size == array.size() * vector) {
            array.add(new VectorArray<>(vector));
        }
        array.get(size / vector).add(item);
        size++;
    }

    @Override
    public T get(int index) {
        return array.get(index / vector).get(index % vector);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item, int index) {
        if (index == size - 1) {
            add(item);
        } else {
            if (size == array.size() * vector) {
                array.add(new VectorArray<>(vector));
            }
            shiftR(index);
            array.get(index / vector).add(item, index % vector);
            size++;
        }
    }

    @Override
    public T remove(int index) {
        T item = (T) array.get(index / vector).get(index % vector);
        array.get(index / vector).remove(index % vector);
        shiftL(index);
        size--;
        return item;
    }

    private void shiftR(int index) {
        for (int row = size / vector; row > index / vector; row--) {
            array.get(row).add(array.get(row - 1).get(vector - 1), 0);
            array.get(row - 1).remove(vector - 1);
        }
    }

    private void shiftL(int index) {
        for (int row = index / vector; row < (size - 1) / vector; row++) {
            array.get(row).add(array.get(row + 1).get(0), vector - 1);
            array.get(row + 1).remove(0);
        }
    }
}
