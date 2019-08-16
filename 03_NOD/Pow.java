
//        2. Алгоритм возведения в степень +1 балл
//        2а. Итеративный (n умножений)
//        2b. Через степень двойки с домножением
//        2c. Через двоичное разложение показателя степени.

public class Pow {

    public static void main(String[] args) {
        int a = 7;
        int n = 13;
        System.out.println(getPowByMul(a, n));
        System.out.println(getPowByExp(a, n));
        System.out.println(getPowByBinDiv(a, n));
    }

    static long getPowByMul(long a, int n) {
        long rez = a;
        for (int i = 1; i < n; i++) {
            rez = rez * a;
        }
        return rez;
    }

    static long getPowByExp(long a, int n) {
        long rez = a;
        int pow = 1;
        while (pow < n) {
            if (pow + pow <= n) {
                rez = rez * rez;
                pow = pow + pow;
            } else {
                if (pow + 1 <= n) {
                    rez = rez * a;
                    pow++;
                }
            }
        }
        return rez;
    }

    static double getPowByBinDiv(double a, int n) {
        double rez = 1;
        int pow = n;
        double mulA = a;
        while (pow > 1) {
            if (pow % 2 == 1) {
                rez = rez * mulA;
            }
            mulA = mulA * mulA;
            pow = pow / 2;
        }
        if (pow > 0) rez = rez * mulA;
        return rez;
    }
}
