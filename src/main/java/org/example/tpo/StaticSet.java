package org.example.tpo;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * Implementación de un Set genérico utilizando un array estático.
 * @param <T> tipo de dato que implementa Comparable
 */
public class StaticSet<T extends Comparable<T>> implements Set<T> {

    private static final int MAX = 10000;

    private final T[] array;
    private int count;
    private final Random random;

    /**
     * Constructor sin parámetros.
     * Internamente creamos un array de tamaño fijo (MAX).
     */
    public StaticSet() {
        this.array = (T[]) new Comparable[MAX];
        this.count = 0;
        this.random = new Random();
    }

    @Override
    public void add(T a) {
        // Si el elemento ya existe, no hacemos nada
        if (this.contains(a)) {
            return;
        }
        // Agregamos al final y aumentamos el contador
        this.array[count] = a;
        this.count++;
    }

    @Override
    public void remove(T a) {
        for (int i = 0; i < count; i++) {
            if (array[i].equals(a)) {
                // Reemplazamos la posición i con el último elemento
                array[i] = array[count - 1];
                count--;
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public T choose() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacío");
        }
        // Si solo hay un elemento, lo devolvemos directamente
        if (this.count == 1) {
            return array[0];
        }
        int randomIndex = random.nextInt(count);
        return array[randomIndex];
    }

    @Override
    public boolean contains(T a) {
        for (int i = 0; i < count; i++) {
            if (array[i].equals(a)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Comparación de igualdad: dos StaticSet son iguales si
     * tienen los mismos elementos (independientemente del orden).
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StaticSet<?> that = (StaticSet<?>) o;

        // Si tienen distinto tamaño, no son iguales
        if (this.count != that.count) {
            return false;
        }
        // Si están vacíos, ambos son iguales
        if (this.count == 0) {
            return true;
        }
        // Ordenamos copias de los arrays para comparar contenido
        T[] aux1 = Arrays.copyOf(this.array, this.count);
        Object[] aux2 = Arrays.copyOf(that.array, that.count);

        Arrays.sort(aux1);
        Arrays.sort(aux2);

        // Comparamos elemento a elemento
        for (int i = 0; i < count; i++) {
            if (!aux1[i].equals(aux2[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Para mantener coherencia con equals, se recomienda
     * sobrescribir hashCode().
     */
    @Override
    public int hashCode() {
        // Estrategia simple: ordenamos el contenido y calculamos el hash
        T[] aux = Arrays.copyOf(this.array, this.count);
        Arrays.sort(aux);
        return Objects.hash((Object[]) aux);
    }
}