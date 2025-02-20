package org.example.tpo;

public class SetUtil {

    // Constructor privado para evitar instanciación
    private SetUtil() { }

    /**
     * Crea y devuelve una copia del set recibido.
     * Durante el proceso se vacía temporalmente el set original
     * para luego restaurarlo.
     *
     * @param set Set genérico a copiar.
     * @param <T> Tipo de elementos contenidos en el set.
     * @return Una nueva instancia de Set con los mismos elementos.
     */
    public static <T> Set<T> copy(Set<T> set) {
        Set<T> copy = new DynamicSet<>();
        Set<T> aux = new DynamicSet<>();

        while (!set.isEmpty()) {
            T element = set.choose();
            copy.add(element);
            aux.add(element);
            set.remove(element);
        }

        while (!aux.isEmpty()) {
            T element = aux.choose();
            set.add(element);
            aux.remove(element);
        }

        return copy;
    }
}