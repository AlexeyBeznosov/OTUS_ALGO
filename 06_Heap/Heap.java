public class Heap {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 7, 5, 5, 8, 6, 4, 15, 10, 29, 9, 7, 0, 21, 4, 23};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        buildHeap(arr);
        sortHeap(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void sortHeap(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            swapHeap(arr, i, 0);
            drown(arr, 0, i);
        }
    }

    private static void buildHeap(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            drown(arr, i, arr.length);
        }
    }

    private static void drown(int[] arr, int i, int size) {
        int indexBefore = i;
        int indexAfter;
        while (true) {
            indexAfter = drownOne(arr, indexBefore, size);
            if (indexAfter == indexBefore) {
                break;
            } else {
                indexBefore = indexAfter;
            }
        }
    }

    private static int drownOne(int[] arr, int i, int size) {

        int leftIndex = leftChildIndex(i);
        int rightIndex = rightChildIndex(i);
        int maxIndex = i;
        if (leftIndex < size && arr[leftIndex] > arr[maxIndex]) {
            maxIndex = leftIndex;
        }
        if (rightIndex < size && arr[rightIndex] > arr[maxIndex]) {
            maxIndex = rightIndex;
        }
        if (arr[maxIndex] > arr[i]) {
            swapHeap(arr, i, maxIndex);
            return maxIndex;
        }
        return i;
    }

    private static void swapHeap(int[] arr, int i, int maxIndex) {
        int temp = arr[i];
        arr[i] = arr[maxIndex];
        arr[maxIndex] = temp;
    }

    private static int leftChildIndex(int i) {
        return i * 2 + 1;
    }

    private static int rightChildIndex(int i) {
        return i * 2 + 2;
    }
}

