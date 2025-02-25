package org.example.final_2025.punto_2.model;

public interface BinaryTree {

    int getRoot();

    BinaryTree getLeft();

    BinaryTree getRight();

    void addLeft(int a);

    void addRight(int a);

    void removeLeft();

    void removeRight();

}
