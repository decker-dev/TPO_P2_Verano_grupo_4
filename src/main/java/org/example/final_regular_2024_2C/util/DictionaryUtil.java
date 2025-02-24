package org.example.final_regular_2024_2C.util;

import org.example.final_regular_2024_2C.model.Dictionary;
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

}
