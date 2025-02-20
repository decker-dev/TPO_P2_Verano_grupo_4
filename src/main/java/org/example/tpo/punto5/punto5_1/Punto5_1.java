package org.example.tpo.punto5.punto5_1;

public class Punto5_1 {
    public static void main(String[] args) {
        Stack<Integer> desordenadoConDuplicados = new DynamicStack<>();
        desordenadoConDuplicados.add(3);
        desordenadoConDuplicados.add(3);
        desordenadoConDuplicados.add(1);
        desordenadoConDuplicados.add(2);
        desordenadoConDuplicados.add(4);
        OrderedStack.sortAndRemoveDuplicates(desordenadoConDuplicados);
    }
}
