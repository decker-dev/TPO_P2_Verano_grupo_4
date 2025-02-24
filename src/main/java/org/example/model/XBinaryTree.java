package org.example.model;

/**
 * El código de esta interfaz fue creado para resolver un ejercicio de examen de otra cursada.
 */
public interface XBinaryTree {

    int getRoot();

    XBinaryTree getLeft();

    XBinaryTree getRight();

    void insertLeft(XBinaryTree left);

    void insertRight(XBinaryTree right);

    void removeLeft();

    void removeRight();

}
