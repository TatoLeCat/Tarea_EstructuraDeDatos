package sudoku;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] mapa =
                {
                        { 0, 0, 0, 0, 0, 3, 9, 0, 0 },
                        { 2, 0, 0, 0, 6, 0, 7, 4, 0 },
                        { 0, 5, 7, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 3, 6, 0, 5, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 4, 3, 0, 0, 6, 7, 8 },
                        { 0, 0, 1, 2, 5, 9, 0, 8, 0 },
                        { 0, 0, 8, 4, 0, 0, 0, 5, 0 },
                        { 3, 0, 5, 8, 0, 1, 2, 9, 6 }
                };

        Sudoku s = new Sudoku(mapa);

        System.out.println("Mapa original...");
        s.imprimir();

        System.out.println("\nMapa resuelto...");
        if (s.resolver()) {
            s.imprimir();
        }
        else {
            System.out.println("No hay solucion");
        }

        System.out.printf("Cantidad de vueltas atras = %d%n",
                s.contarBacktracking());
    }
}