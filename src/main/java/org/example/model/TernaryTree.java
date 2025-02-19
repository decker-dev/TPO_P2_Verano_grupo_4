package org.example.model;

public interface TernaryTree {
    int getRoot();
    TernaryTree getLeft();
    TernaryTree getRight();
    TernaryTree getMid();
    void addLeft(int a);
    void addMid(int a);
    void addRight(int a);
    void removeMid();
    void removeLeft();
    void removeRight();
}
