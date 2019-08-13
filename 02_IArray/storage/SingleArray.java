package storage;

public class SingleArray<T> implements IArray<T> {

    private Object[] array;

    public SingleArray() {
        array = new Object[0];
    }

    @Override
    public void add(T item) {
        resize();
        array[size() - 1] = item;
    }

    @Override
    public T get(int index) {
        return (T)array[index];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void add(T item, int index) {
        resize();
        shiftR(index);
        array[index] = item;
    }

    @Override
    public T remove(int index) {
        T item = (T)array[index];
        shiftL(index);
        return item;
    }

    private void resize() {
        Object[] newArray = new Object[size() + 1];
        System.arraycopy(array, 0 , newArray, 0 , size());
        array = newArray;
    }

    private void shiftR(int index) {
        System.arraycopy(array, index, array, index + 1 , size() - index - 1);
    }

    private void shiftL(int index) {
        Object[] newArray = new Object[size() - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, size() - index - 1);
        array = newArray;
    }
}
