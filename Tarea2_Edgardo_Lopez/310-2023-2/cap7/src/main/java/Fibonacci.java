public class Fibonacci {
    static long conteo = 0;
    static long calcular(int n) {
        if (n < 2) {
            conteo++;
            return 1;
        }
        conteo++;
        return calcular(n - 1) + calcular(n - 2);
    }

    static long calcular(int n, long[] memoria) {
        if (memoria == null) {
            memoria = new long[n + 1];
            memoria[0] = 1;
            memoria[1] = 1;
        }

        if (memoria[n] != 0) {
            conteo++;
            return memoria[n];
        }

        /*if (n < 2) {
            conteo++;
            return 1;
        }*/


        conteo++;

        memoria[n] = calcular(n - 1, memoria) + calcular(n - 2, memoria);
        return memoria[n];
    }
}
