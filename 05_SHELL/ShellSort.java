
public class ShellSort implements ISort {

    @Override
    public void sort(int[] arr) {
        //int step = arr.length / 2;
        int step = 6;
        for (int inc = step; inc > 0; inc /= 2) {
            for (int i = 0; i < step; i++) {
                insertSort(arr, i, inc);
            }
        }
    }

    private static void insertSort(int[] arr, int start, int inc) {
        for (int i = start; i < arr.length; i += inc) {
            int temp = arr[i];
            int j = i;
            while (j > start && arr[j - inc] > temp) {
                arr[j] = arr[j - inc];
                j -= inc;
            }
            arr[j] = temp;
        }
    }
}
