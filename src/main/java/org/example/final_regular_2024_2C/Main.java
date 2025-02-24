package org.example.final_regular_2024_2C;

import org.example.final_regular_2024_2C.model.DynamicMultipleDictionary;
import org.example.final_regular_2024_2C.model.MultipleDictionary;
import org.example.final_regular_2024_2C.model.List;
import org.example.final_regular_2024_2C.model.DynamicDictionary;
import org.example.final_regular_2024_2C.model.Dictionary;
import org.example.final_regular_2024_2C.util.DictionaryUtil;

public class Main {
    public static void main(String[] args) {
        // ================================
        // Prueba de MultipleDictionary
        // ================================
        MultipleDictionary dictionary = new DynamicMultipleDictionary();

        // Se agregan pares clave-valor
        dictionary.add(3, 30);
        dictionary.add(1, 10);
        dictionary.add(3, 20);
        dictionary.add(3, 30); // Valor duplicado para la clave 3, no se agregará
        dictionary.add(2, 40);
        dictionary.add(2, 35);
        dictionary.add(2, 45);
        dictionary.add(2, 40); // Valor duplicado para la clave 2, no se agregará
        dictionary.add(2, 40); // Valor duplicado para la clave 2, no se agregará
        dictionary.add(2, 40); // Valor duplicado para la clave 2, no se agregará
        dictionary.add(2, 40); // Valor duplicado para la clave 2, no se agregará
        dictionary.add(2, 40); // Valor duplicado para la clave 2, no se agregará

        // Se muestran los valores para cada clave (la estructura List se recorre manualmente)
        System.out.println("Valores para la clave 1: " + listToString(dictionary.get(1)));
        System.out.println("Valores para la clave 2: " + listToString(dictionary.get(2)));
        System.out.println("Valores para la clave 3: " + listToString(dictionary.get(3)));

        // ==========================================
        // Prueba del complemento de diccionarios simples
        // ==========================================
        System.out.println("\nPrueba del complemento de diccionarios simples:");
        Dictionary d2 = new DynamicDictionary();
        Dictionary d1 = new DynamicDictionary();

        // Agregamos pares a D2
        try {
            d2.add(1, 10);
            d2.add(2, 20);
            d2.add(3, 30);
            d2.add(4, 40);
        } catch (RuntimeException e) {
            System.out.println("Error en D2: " + e.getMessage());
        }

        // Agregamos pares a D1 (subdiccionario de D2)
        try {
            d1.add(2, 20);
            d1.add(3, 30);
        } catch (RuntimeException e) {
            System.out.println("Error en D1: " + e.getMessage());
        }

        System.out.println("Diccionario D2:");
        DictionaryUtil.print(d2);

        System.out.println("\nDiccionario D1:");
        DictionaryUtil.print(d1);

        // Se calcula el complemento: pares en D2 que no están en D1
        Dictionary complement = DictionaryUtil.complement(d1, d2);
        System.out.println("\nComplemento de D1 respecto a D2:");
        DictionaryUtil.print(complement);
    }

    private static String listToString(List list) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.length(); i++) {
            sb.append(list.get(i));
            if (i < list.length() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}