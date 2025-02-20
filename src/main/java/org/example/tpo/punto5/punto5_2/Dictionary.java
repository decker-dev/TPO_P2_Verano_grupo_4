package org.example.tpo.punto5.punto5_2;

public interface Dictionary {

    int get(int key);
    Set getKeys();
    void add(int key, int value);
    void remove(int key);

}
