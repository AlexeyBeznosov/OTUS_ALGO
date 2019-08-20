
import java.util.Random;

public class TestShellAndInsertion {

    public static void main(String[] args) {
        int length = 100000;
        int[] arr = createArray(length);
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        InsertSort insertSort = new InsertSort();
        ShellSort shellSort = new ShellSort();
        testSort(insertSort, arr);
        testSort(shellSort, arr2);
        shuffleArray(arr, 10);
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        testSort(insertSort, arr);
        testSort(shellSort, arr2);
        shuffleArray(arr, 5d / length * 100);
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        testSort(insertSort, arr);
        testSort(shellSort, arr2);
    }

    private static int[] createArray(int length) {
        Random random = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(length);
        }
        return arr;
    }

    private static void testSort(ISort iSort, int[] arr) {
        long start = System.currentTimeMillis();
        iSort.sort(arr);
        long finish = System.currentTimeMillis() - start;
        for (int value : arr) {
            //System.out.print(value + "  ");
        }
        System.out.println("время выполнения " + iSort + ": " + finish + " ms");
    }

    private static void shuffleArray(int[] arr, double value) {
        Random random = new Random();
        int j;
        int k;
        int temp;
        for (int i = 0; i < arr.length * value / 100; i++) {
            j = random.nextInt(arr.length);
            k = random.nextInt(arr.length);
            temp = arr[j];
            arr[j] = arr[k];
            arr[k] = temp;
        }
    }
}
