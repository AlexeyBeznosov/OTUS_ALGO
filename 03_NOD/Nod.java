//        1. Алгоритм Евклида поиска НОД +1 балл
//        1a. Через вычитание
//        1b. Через остаток
//        1c. Через битовые операции (по желанию)

public class Nod {

    public static void main(String[] args) {
        int a = 51000100;
        int b = 15;
        System.out.println(getNodBySub(a, b));
        System.out.println(getNodByDiv(b, a));
    }

    static int getNodBySub(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    static int getNodByDiv(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a == 0 ? b : a;
    }
}
