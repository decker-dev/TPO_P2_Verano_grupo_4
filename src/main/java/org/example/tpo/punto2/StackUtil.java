package org.example.tpo.punto2;

public class StackUtil {

    /**
     * Invierte los elementos del stack recibido.
     * @param stack Stack genérico a invertir.
     * @param <T> Tipo de los elementos almacenados en la pila.
     */
    public static <T> void reverse(Stack<T> stack) {
        if (stack.isEmpty()) {
            return;
        }
        // Extrae el elemento del tope
        T top = stack.getTop();
        stack.remove();
        // Invierte recursivamente el resto de la pila
        reverse(stack);
        // Inserta el elemento extraído al fondo de la pila ya invertida
        insertAtBottom(stack, top);
    }

    /**
     * Inserta el elemento dado en el fondo de la pila.
     * @param stack Pila en la que se inserta el elemento.
     * @param element Elemento a insertar en el fondo.
     * @param <T> Tipo de los elementos en la pila.
     */
    private static <T> void insertAtBottom(Stack<T> stack, T element) {
        if (stack.isEmpty()) {
            stack.add(element);
            return;
        }
        // Extrae el tope temporalmente
        T top = stack.getTop();
        stack.remove();
        // Llama recursivamente para llegar al fondo
        insertAtBottom(stack, element);
        // Vuelve a insertar el tope extraído
        stack.add(top);
    }
}