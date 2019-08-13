package storage;

public class FactorArray<T> implements IArray<T> {

    private Object[] array;
    private int size;
    private int factor;

    public FactorArray() {
        size = 0;
        array = new Object[10];
        factor = 100;
    }

    @Override
    public void add(T item) {
        if (size == array.length) {
            resize();
        }
        array[size] = item;
        size++;
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item, int index) {
        if (size == array.length) {
            resize();
        }
        shiftR(index);
        array[index] = item;
        size++;
    }

    @Override
    public T remove(int index) {
        T item = (T) array[index];
        if (index == size - 1) {
            array[index] = null;
        } else {
            shiftL(index);
            array[size - 1] = null;
        }
        size--;
        return item;
    }

    private void resize() {
        Object[] newArray = new Object[size + size * factor / 100];
        System.arraycopy(array, 0, newArray, 0, size());
        array = newArray;
    }

    private void shiftR(int index) {
        System.arraycopy(array, index, array, index + 1, size - index);
    }

    private void shiftL(int index) {
        System.arraycopy(array, index + 1, array, index, size - index - 1);
    }
}
