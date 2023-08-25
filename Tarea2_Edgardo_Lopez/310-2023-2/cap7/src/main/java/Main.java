public class Main {
    public static void main(String[] args) {
        final int N = 50;
        System.out.println("Metodo mejorado");
        Fibonacci.conteo = 0;
        System.out.println(Fibonacci.calcular(N, null));
        System.out.println("Recursiones: " + Fibonacci.conteo);

        System.out.println("Metodo original...");
        Fibonacci.conteo = 0;
        System.out.println(Fibonacci.calcular(N));
        System.out.println("Recursiones: " + Fibonacci.conteo);
    }
}
// 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
// 0  1  2  3  4  5   6  7   8   9