package org.example.tpo.punto5.punto5_1;

public class OrderedStack<T extends Comparable<T>> extends DynamicStack<T> {

    /**
     * Ordena y elimina los elementos repetidos de una pila utilizando un conjunto
     * para eliminar duplicados y una cola para ordenar.
     *
     * Complejidad: O(n²) en el peor caso, debido a la inserción ordenada en la pila,
     * donde n es la cantidad de elementos en la pila original.
     *
     * @param original Pila original.
     * @return Pila ordenada y sin duplicados.
     * @param <T> Tipo de elementos en la pila, debe ser comparable.
     */

    public static <T extends Comparable<T>> Stack<T> sortAndRemoveDuplicates(Stack<T> original) {
        // Usamos DynamicSet para eliminar duplicados
        Set<T> uniqueSet = new DynamicSet<>();
        DynamicQueue<T> tempQueue = new DynamicQueue<>();

        // Transferir elementos al set (elimina duplicados automáticamente)
        while (!original.isEmpty()) {
            uniqueSet.add(original.getTop());
            original.remove();
        }

        // Transferir a cola temporal para ordenar
        while (!uniqueSet.isEmpty()) {
            T element = uniqueSet.choose();
            tempQueue.add(element);
            uniqueSet.remove(element);
        }

        // Ordenar insertando en la pila original
        while (!tempQueue.isEmpty()) {
            T current = tempQueue.getFirst();
            tempQueue.remove();

            Stack<T> tempStack = new DynamicStack<>();

            // Encontrar la posición correcta para insertar
            while (!original.isEmpty() && original.getTop().compareTo(current) < 0) {
                tempStack.add(original.getTop());
                original.remove();
            }

            original.add(current);

            // Restaurar elementos temporales
            while (!tempStack.isEmpty()) {
                original.add(tempStack.getTop());
                tempStack.remove();
            }
        }

        return original;
    }
}