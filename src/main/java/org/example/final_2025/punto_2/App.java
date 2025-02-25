package org.example.final_2025.punto_2;

import org.example.final_2025.punto_2.model.DynamicMultipleDictionary;
import org.example.final_2025.punto_2.model.MultipleDictionary;
import org.example.final_2025.punto_2.model.Dictionary;
import org.example.final_2025.punto_2.util.MultipleDictionaryUtil;
import org.example.final_2025.punto_2.util.DictionaryUtil;

public class App {
    public static void main(String[] args) {
        // Caso 1: Diccionario múltiple válido para conversión
        MultipleDictionary multiDict = new DynamicMultipleDictionary();
        multiDict.add(1, 100);
        multiDict.add(2, 200);
        multiDict.add(3, 300);

        System.out.println("Probando conversión de diccionario múltiple a simple (caso válido):");
        try {
            if (MultipleDictionaryUtil.canConvertToSimpleDictionary(multiDict)) {
                Dictionary simpleDict = MultipleDictionaryUtil.convertToSimpleDictionary(multiDict);
                DictionaryUtil.print(simpleDict);
            } else {
                System.out.println("No se puede convertir el diccionario múltiple a simple.");
            }
        } catch (RuntimeException e) {
            System.out.println("Error durante la conversión: " + e.getMessage());
        }

        // Caso 2: Diccionario múltiple no válido (una clave tiene más de un valor)
        MultipleDictionary invalidMulti = new DynamicMultipleDictionary();
        invalidMulti.add(1, 100);
        invalidMulti.add(1, 101); // Para la misma clave se agregan dos valores.
        invalidMulti.add(2, 200);

        System.out.println("\nProbando conversión de diccionario múltiple a simple (caso inválido):");
        try {
            if (MultipleDictionaryUtil.canConvertToSimpleDictionary(invalidMulti)) {
                Dictionary simpleDict = MultipleDictionaryUtil.convertToSimpleDictionary(invalidMulti);
                DictionaryUtil.print(simpleDict);
            } else {
                System.out.println("No se puede convertir el diccionario múltiple a simple.");
            }
        } catch (RuntimeException e) {
            System.out.println("Error durante la conversión: " + e.getMessage());
        }
    }
}