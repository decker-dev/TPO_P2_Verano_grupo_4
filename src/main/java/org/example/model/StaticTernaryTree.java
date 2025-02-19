package org.example.model;

/// ** La complejidad computacional al recorrer los nodos en el peor de los casos es de O(N) siendo N los niveles de la estructuras.
public class StaticTernaryTree implements TernaryTree {

    private static final int MAX = 10;
    private final Integer[] array;
    private final int indexRoot;

    public StaticTernaryTree(int root) {
        this.array = new Integer[(int) Math.pow(3, MAX) - 1];
        this.indexRoot = 0;
        this.array[indexRoot] = root;
    }

    private StaticTernaryTree(int indexRoot, Integer[] array) {
        this.array = array;
        this.indexRoot = indexRoot;
    }

    @Override
    public int getRoot() {
        return this.array[this.indexRoot];
    }

    @Override
    public TernaryTree getLeft() {
        if (this.array[3 * indexRoot + 1] == null) {
            return null;
        }
        return new StaticTernaryTree(3 * indexRoot + 1, array);
    }

    @Override
    public TernaryTree getMid() {
        if (this.array[3 * indexRoot + 2] == null) {
            return null;
        }
        return new StaticTernaryTree(3 * indexRoot + 2, array);
    }

    @Override
    public TernaryTree getRight() {
        if (this.array[3 * indexRoot + 3] == null) {
            return null;
        }
        return new StaticTernaryTree(3 * indexRoot + 3, array);
    }

    @Override
    public void addLeft(int a) {
        if (this.array[3 * indexRoot + 1] != null) {
            throw new RuntimeException("Ya existe un hijo izquierdo");
        }
        this.array[3 * indexRoot + 1] = a;
    }

    @Override
    public void addMid(int a) {
        if (this.array[3 * indexRoot + 2] != null) {
            throw new RuntimeException("Ya existe un hijo medio");
        }
        this.array[3 * indexRoot + 2] = a;
    }

    @Override
    public void addRight(int a) {
        if (this.array[3 * indexRoot + 3] != null) {
            throw new RuntimeException("Ya existe un hijo derecho");
        }
        this.array[3 * indexRoot + 3] = a;
    }

    @Override
    public void removeLeft() {
        this.array[3 * indexRoot + 1] = null;
    }

    @Override
    public void removeMid() {
        this.array[3 * indexRoot + 2] = null;
    }

    @Override
    public void removeRight() {
        this.array[3 * indexRoot + 3] = null;
    }
}
