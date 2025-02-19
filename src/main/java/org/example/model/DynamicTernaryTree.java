package org.example.model;

/// ** La complejidad computacional es en el peor de los casos O(log3 N) siendo N los niveles de la estructuras.
public class DynamicTernaryTree implements TernaryTree {

    private final int root;
    private TernaryTree left;
    private TernaryTree mid;
    private TernaryTree right;

    public DynamicTernaryTree(int root) {
        this.root = root;
    }

    @Override
    public int getRoot() {
        return this.root;
    }

    @Override
    public TernaryTree getLeft() {
        return this.left;
    }

    @Override
    public TernaryTree getMid() {
        return this.mid;
    }

    @Override
    public TernaryTree getRight() {
        return this.right;
    }

    @Override
    public void addLeft(int a) {
        if (this.left != null) {
            throw new RuntimeException("Ya existe un hijo izquierdo");
        }
        this.left = new DynamicTernaryTree(a);
    }

    @Override
    public void addMid(int a) {
        if (this.mid != null) {
            throw new RuntimeException("Ya existe un hijo medio");
        }
        this.mid = new DynamicTernaryTree(a);
    }

    @Override
    public void addRight(int a) {
        if (this.right != null) {
            throw new RuntimeException("Ya existe un hijo derecho");
        }
        this.right = new DynamicTernaryTree(a);
    }

    @Override
    public void removeLeft() {
        this.left = null;
    }

    @Override
    public void removeMid() {
        this.mid = null;
    }

    @Override
    public void removeRight() {
        this.right = null;
    }
}
