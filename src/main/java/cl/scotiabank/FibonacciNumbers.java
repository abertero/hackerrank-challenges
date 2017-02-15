package cl.scotiabank;

public class FibonacciNumbers {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(String.format("Fib n=%s es %s es primo? %s", i, getFibonacci(i), isPrimeFibonacci(i)));
        }
    }

    public static int getFibonacci(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return getFibonacci(n - 1) + getFibonacci(n - 2);
        }
    }

    /**
     * Retorna true si el n-esimo elemento de la suceción es primo.
     *
     * @param n el n-esimo elemento.
     * @return true si es primo.
     */
    public static boolean isPrimeFibonacci(int n) {
        int fibonacciElement = getFibonacci(n);
        if (fibonacciElement > 1 && fibonacciElement <= 5) {
            return true;
        } else if (fibonacciElement % 2 == 0) {
            return false; // nos permite descartar los pares.
        } else {
            int sqrt = (int) Math.sqrt(fibonacciElement);
            for (int i = 3; i <= sqrt; i++) {
                if (fibonacciElement % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}