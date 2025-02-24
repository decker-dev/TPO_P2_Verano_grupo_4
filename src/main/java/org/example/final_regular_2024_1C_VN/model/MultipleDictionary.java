package org.example.final_regular_2024_1C_VN.model;


public interface MultipleDictionary {

    List get(int key);

    Set getKeys();

    void add(int key, int value);

    void remove(int key, int value);

}
