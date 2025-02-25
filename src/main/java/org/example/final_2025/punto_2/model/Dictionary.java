package org.example.final_2025.punto_2.model;

public interface Dictionary {

    int get(int key);

    Set getKeys();

    void add(int key, int value);

    void remove(int key);

}
