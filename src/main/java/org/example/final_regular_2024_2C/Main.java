package org.example.final_regular_2024_2C;

import org.example.final_regular_2024_2C.model.DynamicMultipleDictionary;
import org.example.final_regular_2024_2C.model.MultipleDictionary;
import org.example.final_regular_2024_2C.model.List;

public class Main {
    public static void main(String[] args) {
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
    }

    // Método auxiliar para imprimir la lista
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