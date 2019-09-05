
public class QuickSort implements ISort {

    @Override
    public void sort(int[] arr) {
        int[] pointers = new int[arr.length * 2];
        int pointer = 0;
        pointers[pointer] = 0;
        pointers[pointer + 1] = arr.length - 1;
        int tail = 2;
        do {
            int in = pointers[pointer];
            int out = pointers[pointer + 1];
            int splitIndex = splitArray(arr, in, out, 0);
            if (splitIndex == out) {
                splitIndex = splitArray(arr, in, out, 1);
            }
            pointer += 2;
            if (splitIndex == out) {
                insertSort(arr, in, out);
            } else {
                if (splitIndex == in) {
                    pointers[tail] = splitIndex + 1;
                    pointers[tail + 1] = out;
                    tail += 2;
                } else {
                    pointers[tail] = in;
                    pointers[tail + 1] = splitIndex;
                    pointers[tail + 2] = splitIndex + 1;
                    pointers[tail + 3] = out;
                    tail += 4;
                }
            }
        } while (pointer < tail);
    }

    private int splitArray(int[] arr, int in, int out, int method) {
        int i = in;
        int pivot;
        if (method == 0) {
            pivot = getPivotByMiddle(arr, in, out);
        } else {
            pivot = getPivotByLast(arr, in, out);
        }
        for (int j = in; j <= out; j++) {
            while (i <= out && arr[i] <= pivot) {
                i++;
            }
            if (i == out + 1) {
                break;
            }
            if (i < j && arr[j] <= pivot) {
                swap(arr, i, j);
                if (j == out) {
                    i++;
                }
            }
        }
        return i - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int getPivotByMiddle(int[] arr, int in, int out) {
        return arr[(out + in) / 2];
    }

    private int getPivotByLast(int[] arr, int in, int out) {
        return arr[out];
    }

    private void insertSort(int[] arr, int in, int out) {
        for (int i = in; i <= out; i++) {
            int temp = arr[i];
            int j = i;
            while (j > in && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
