package org.example.final_2025.punto_2.util;

import org.example.final_2025.punto_2.model.Dictionary;
import org.example.final_2025.punto_2.model.DynamicDictionary;
import org.example.final_2025.punto_2.model.MultipleDictionary;
import org.example.final_2025.punto_2.model.List;
import org.example.final_2025.punto_2.model.Set;

public class MultipleDictionaryUtil {

    private MultipleDictionaryUtil() {
        // Constructor privado para evitar instanciación
    }

    /**
     * Verifica si es posible convertir un diccionario múltiple en uno simple.
     * Esto es posible si y solo si para cada clave existe exactamente un valor.
     *
     * @param multi el diccionario múltiple a verificar
     * @return true si se puede convertir, false en caso contrario
     */
    public static boolean canConvertToSimpleDictionary(MultipleDictionary multi) {
        Set keys = multi.getKeys();
        while (!keys.isEmpty()) {
            int key = keys.choose();
            List values = multi.get(key);
            if (values.length() != 1) {
                return false;
            }
            keys.remove(key);
        }
        return true;
    }

    /**
     * Convierte un diccionario múltiple en un diccionario simple, siempre que cada clave
     * tenga un único valor asociado. Si alguna clave tiene más de un valor, se lanza una excepción.
     *
     * @param multi el diccionario múltiple a convertir
     * @return un diccionario simple con la información del múltiple
     * @throws RuntimeException si alguna clave tiene más de un valor
     */
    public static Dictionary convertToSimpleDictionary(MultipleDictionary multi) {
        if (!canConvertToSimpleDictionary(multi)) {
            throw new RuntimeException("No es posible convertir el diccionario múltiple a simple: alguna clave tiene más de un valor.");
        }
        Dictionary simpleDictionary = new DynamicDictionary();
        Set keys = multi.getKeys();
        while (!keys.isEmpty()) {
            int key = keys.choose();
            List values = multi.get(key);
            // Al haber verificado previamente, cada lista tiene exactamente un elemento (en índice 0)
            simpleDictionary.add(key, values.get(0));
            keys.remove(key);
        }
        return simpleDictionary;
    }
}