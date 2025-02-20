package org.example.tpo.punto1.punto1_3;

public class Punto1_3 {
    public static void main(String[] args) {

        int n = 10;
        int[][] matrizCaracol = generarMatrizCaracol(n);

        // Imprimir la matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrizCaracol[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Genera una matriz en forma de caracol de dimensión nxn, llenándola en
     * sentido horario desde el borde hacia el centro.
     *
     * Complejidad: O(n²), ya que se recorren y llenan todos los elementos de la matriz.
     *
     * @param n Dimensión de la matriz.
     * @return Matriz de caracol de tamaño nxn.
     */

    private static int[][] generarMatrizCaracol(int n) {
        int[][] matriz = new int[n][n];
        int valor = 1, filaInicio = 0, filaFin = n - 1, colInicio = 0, colFin = n - 1;

        while (filaInicio <= filaFin && colInicio <= colFin) {
            // Llenar la fila superior
            for (int col = colInicio; col <= colFin; col++) {
                matriz[filaInicio][col] = valor++;
            }
            filaInicio++;

            // Llenar la columna derecha
            for (int fila = filaInicio; fila <= filaFin; fila++) {
                matriz[fila][colFin] = valor++;
            }
            colFin--;

            // Llenar la fila inferior (si queda)
            if (filaInicio <= filaFin) {
                for (int col = colFin; col >= colInicio; col--) {
                    matriz[filaFin][col] = valor++;
                }
                filaFin--;
            }

            // Llenar la columna izquierda (si queda)
            if (colInicio <= colFin) {
                for (int fila = filaFin; fila >= filaInicio; fila--) {
                    matriz[fila][colInicio] = valor++;
                }
                colInicio++;
            }
        }

        return matriz;
    }
}
