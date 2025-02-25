package org.example.final_2025.punto_1;

import org.example.final_2025.punto_1.model.DynamicStack;
import org.example.final_2025.punto_1.model.Stack;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Probando DynamicStack ===");

        // Caso 1: Operaciones válidas
        Stack stack = new DynamicStack();
        try {
            System.out.println("Agregando 1 (suma = 1)");
            stack.add(1); // suma = 1, permitido.

            System.out.println("Agregando 4 (suma = 1+4 = 5)");
            stack.add(4); // suma = 5, permitido ya que 5 % 3 != 0.

            System.out.println("El tope actual es: " + stack.getTop()); // Debe ser 4.

            System.out.println("TopCandidate: " + stack.topCandidate());
            // Con la pila [4, 1] (tope = 4, base = 1),
            // si se quita 4, la suma sería 1 (permitido) y
            // si se quita 1, la suma sería 4 (también permitido).
            // topCandidate devuelve el candidato más cercano al tope, es decir, 4.

            System.out.println("Eliminando el tope (4)...");
            stack.remove(); // Al eliminar 4, la suma pasa a ser 1.
            System.out.println("Nuevo tope: " + stack.getTop()); // Debe ser 1.

            // Intentamos eliminar el último elemento.
            // Al quitar 1, la suma resultante sería 0, y 0 es múltiplo de 3.
            System.out.println("Intentando eliminar el último elemento (1)...");
            stack.remove(); // Debería lanzar excepción.
        } catch (RuntimeException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        // Caso 2: Intento de agregar elemento que provoque suma múltiplo de 3.
        System.out.println("\n=== Probando agregar elemento que provoca suma múltiplo de 3 ===");
        stack = new DynamicStack();
        try {
            System.out.println("Agregando 2 (suma = 2)");
            stack.add(2); // suma = 2.
            System.out.println("Agregando 4 (suma = 2+4 = 6)");
            stack.add(4); // suma = 6, pero 6 % 3 == 0, debería lanzar excepción.
        } catch (RuntimeException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
}