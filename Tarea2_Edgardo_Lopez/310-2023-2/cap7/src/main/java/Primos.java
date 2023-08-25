public class Primos {
    boolean calcularDescendente(int x, int y) {
        if (y == 1) {
            return true;
        }
        else if (x % y == 0) {
            return false;
        }
        else{
            return calcularDescendente(x, y-1);
        }
    }


    boolean calcularAscendente(int x, int y) {
        // caso base (detiene)
        if (y >= (int)Math.sqrt(x)) {
            return true;
        }
        // caso base 2
        else if (x % y == 0) {
            return false;
        }
        // caso recursivo
        else {
            return calcularAscendente(x, y + 1);
        }
    }
}
