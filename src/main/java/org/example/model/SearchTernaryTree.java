package org.example.model;

public interface SearchTernaryTree {

    int getRoot();

    SearchTernaryTree getLeft();

    SearchTernaryTree getMid();

    SearchTernaryTree getRight();

    void add(int a);

    void removeLeft();

    void removeMid();

    void removeRight();

}
