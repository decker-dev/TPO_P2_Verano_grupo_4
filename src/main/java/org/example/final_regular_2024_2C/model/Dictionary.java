package org.example.final_regular_2024_2C.model;

public interface Dictionary {

    int get(int key);

    Set getKeys();

    void add(int key, int value);

    void remove(int key);

}
