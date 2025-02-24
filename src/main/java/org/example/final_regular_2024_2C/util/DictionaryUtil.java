package org.example.final_regular_2024_2C.util;

import org.example.final_regular_2024_2C.model.Dictionary;
import org.example.final_regular_2024_2C.model.DynamicDictionary;
import org.example.final_regular_2024_2C.model.Set;

public class DictionaryUtil {

    private DictionaryUtil() {
    }

    public static void print(Dictionary dictionary) {
        Set keys = dictionary.getKeys();
        while (!keys.isEmpty()) {
            int key = keys.choose();
            int value = dictionary.get(key);
            System.out.println("key: " + key + ", value: " + value);
            keys.remove(key);
        }
    }

    /**
     * Devuelve un nuevo diccionario simple con el complemento de D1 respecto a D2.
     * Se asume que D1 es subdiccionario de D2.
     * Es decir, se retornan aquellos pares (clave, valor) que están en D2 pero no en D1.
     */
    public static Dictionary complement(Dictionary d1, Dictionary d2) {
        // Crear un nuevo diccionario que almacenará el complemento
        Dictionary result = new DynamicDictionary();

        // Obtener el conjunto de claves de D2 y de D1
        Set keysD2 = d2.getKeys();
        Set keysD1 = d1.getKeys();

        // Remover de keysD2 todas las claves que se encuentren en D1
        while (!keysD1.isEmpty()) {
            int key = keysD1.choose();
            keysD2.remove(key);
            keysD1.remove(key); // Se remueve la clave de keysD1 para evitar un bucle infinito
        }

        // Agregar al diccionario resultado cada par de D2 cuya clave no estaba en D1
        while (!keysD2.isEmpty()) {
            int key = keysD2.choose();
            int value = d2.get(key);
            result.add(key, value);
            keysD2.remove(key);
        }

        return result;
    }
}