
//        4. Алгоритм поиска чисел Фибоначчи +1 балл
//        4a. Через рекурсию
//        4b. Через итерацию
//        4c. По формуле золотого сечения
//        4d. Через умножение матриц (по желанию) +1 балл

public class Fbn {

    public static void main(String[] args) {
        int n = 50;
        System.out.println(getFbnByRecurs(n));
        System.out.println(getFbnByIter(n));
        System.out.println(getFbnByGold(n));
        System.out.println(getFbnByMatrix(n));
    }

    private static long getFbnByRecurs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return getFbnByRecurs(n - 1) + getFbnByRecurs(n - 2);
    }

    private static long getFbnByIter(int n) {
        long a = 0;
        long b = 1;
        for (int i = 2; i <= n; i++) {
            if (a > b) {
                b = a + b;
            } else {
                a = a + b;
            }
        }
        return a > b ? a : b;
    }

    private static long getFbnByGold(int n) {
        long f = Math.round(Math.pow((1d + Math.sqrt(5d)) / 2, n) / Math.sqrt(5));
        return f;
    }

    private static long getFbnByMatrix(int n) {
        long[] arr = new long[]{1, 1, 1, 0};
        long[] rez = new long[]{1, 1, 1, 0};
        int pow = n - 2;
        while (pow > 1) {
            if (pow % 2 == 1) {
                rez = muxArray(rez, arr);
            }
            arr = muxArray(arr, arr);
            pow = pow / 2;
        }
        if (pow > 0) rez = muxArray(rez, arr);
        return rez[0];
    }

    private static long[] muxArray(long[] arr1, long[] arr2) {
        long[] tempArray = new long[4];
        tempArray[0] = arr1[0] * arr2[0] + arr1[1] * arr2[2];
        tempArray[1] = arr1[0] * arr2[1] + arr1[1] * arr2[3];
        tempArray[2] = arr1[2] * arr2[0] + arr1[3] * arr2[2];
        tempArray[3] = arr1[2] * arr2[1] + arr1[3] * arr2[3];
        return tempArray;
    }
}
