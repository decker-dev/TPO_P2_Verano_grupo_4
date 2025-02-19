package org.example.util;

import org.example.model.BinaryTree;
import org.example.model.Dictionary;
import org.example.model.DynamicBinaryTree;
import org.example.model.Set;

public class DictionaryUtil {

    /**
     * Convierte un diccionario a un árbol binario de la siguiente forma:
     * - La raíz es el primer key obtenido del set, con su hijo izquierdo almacenando el value.
     * - Cada nodo key tiene un hijo derecho que es el siguiente key (según el orden que retorne el set)
     *   y éste tiene, a la izquierda, su value correspondiente.
     *
     * De esta manera, para cada par key/value se respeta la relación (el value está en el hijo izquierdo
     * de su key) y la secuencia se establece a partir del orden que retorne el set.
     *
     * @param dict Diccionario con pares key/value.
     * @return Árbol binario generado o null si el diccionario está vacío.
     */
    public static BinaryTree toBinaryTree(Dictionary dict) {
        Set keys = dict.getKeys();
        if (keys.isEmpty()) {
            return null;  // Diccionario vacío
        }

        // Extraer el primer par
        int key = keys.choose();
        int value = dict.get(key);
        // Crear la raíz con el key y asignar su hijo izquierdo con el value
        BinaryTree tree = new DynamicBinaryTree(key);
        tree.addLeft(value);
        keys.remove(key);  // Eliminamos la clave ya procesada

        BinaryTree current = tree;

        // Mientras queden claves en el set, se las agrega en cadena por el hijo derecho.
        while (!keys.isEmpty()) {
            key = keys.choose();
            value = dict.get(key);
            current.addRight(key);          // El siguiente key se enlaza como hijo derecho
            current = current.getRight();     // Avanzamos al nuevo nodo key
            current.addLeft(value);           // Se asigna el value al hijo izquierdo
            keys.remove(key);                 // Se elimina la clave ya procesada
        }
        return tree;
    }
}