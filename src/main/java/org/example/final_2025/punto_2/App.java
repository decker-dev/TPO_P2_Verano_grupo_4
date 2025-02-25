package org.example.final_2025.punto_2;

import org.example.final_2025.punto_2.model.DynamicMultipleDictionary;
import org.example.final_2025.punto_2.model.MultipleDictionary;
import org.example.final_2025.punto_2.model.Dictionary;
import org.example.final_2025.punto_2.util.MultipleDictionaryUtil;
import org.example.final_2025.punto_2.util.DictionaryUtil;

import static org.example.final_2025.punto_2.util.BinaryTreeUtil.couldBeStaticBinaryTreeAttribute;

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


        // Caso 1: [1, 2, 3, 0, 0, 1]
        // Se asume que 0 es un valor válido (no indicador de ausencia)
        Integer[] array1 = {1, 2, 3, 0, 0, 1};
        System.out.println("Array1 [1,2,3,0,0,1]" +
                couldBeStaticBinaryTreeAttribute(array1)); // true

        // Caso 2: [1, null, 3]
        Integer[] array2 = {1, null, 3};
        System.out.println("Array2 [1,null,3]" +
                couldBeStaticBinaryTreeAttribute(array2)); // true

        // Caso 3: [1, null, null, 4]
        // Aquí, el nodo 4 (índice 3) tiene como padre el índice 1, que es null.
        Integer[] array3 = {1, null, null, 4};
        System.out.println("Array3 [1,null,null,4]" +
                couldBeStaticBinaryTreeAttribute(array3)); // false

        // Caso 4: [null, 2, 3]
        Integer[] array4 = {null, 2, 3};
        System.out.println("Array4 [null,2,3]" +
                couldBeStaticBinaryTreeAttribute(array4)); // false

        // Caso 5: [1]
        Integer[] array5 = {1};
        System.out.println("Array5 [1]" +
                couldBeStaticBinaryTreeAttribute(array5)); // true

    }
}