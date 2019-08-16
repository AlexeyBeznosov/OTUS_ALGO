//        3. Алгоритмы поиска кол-ва простых чисел до N +1 балл
//        3a. Через перебор делителей.
//        3b. Несколько оптимизаций перебора делителей, с использованием массива.
//        3c. Решето Эратосфена.
//        3d. Решето Эратосфена с битовой матрицей, по 32 значения в одном int (по желанию) +1 балл

public class Prime {

    public static void main(String[] args) {
        int n = 200;
        System.out.println(getPrimeByIter(n));
        System.out.println(getPrimeByArray(n));
    }

    static int getPrimeByIter(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (checkSimple(i)) {
                count++;
            }
        }
        return count;
    }

    static int getPrimeByArray(int n) {
        int rez = 0;
        boolean[] prim = new boolean[n];
        int i;
        for (i = 0; i < n; i++) {
            prim[i] = true;
        }
        i = 2;
        while (i <= n) {
            if (prim[i - 1]) {
                for (int j = i * i; j <= n; j = j + i) {
                    prim[j - 1] = false;
                }
            }
            i++;
        }
        for (i = 1; i < n; i++) {
            if (prim[i]) {
                rez++;
            }
        }
        return rez;
    }

    private static boolean checkSimple(int i) {
        int countdiv = 2;
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                countdiv++;
            }
        }
        return countdiv == 2 ? true : false;
    }
}
