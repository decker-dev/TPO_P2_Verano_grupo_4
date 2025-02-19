package org.example.model;

public class DynamicBinaryTree implements BinaryTree {

    private final int root;
    private BinaryTree left;
    private BinaryTree right;

    public DynamicBinaryTree(int root) {
        this.root = root;
    }

    @Override
    public int getRoot() {
        return this.root;
    }

    @Override
    public BinaryTree getLeft() {
        return this.left;
    }

    @Override
    public BinaryTree getRight() {
        return this.right;
    }

    @Override
    public void addLeft(int a) {
        if(this.left != null) {
            throw new RuntimeException("Ya existe un hijo izquierdo");
        }
        this.left = new DynamicBinaryTree(a);
    }

    @Override
    public void addRight(int a) {
        if(this.right != null) {
            throw new RuntimeException("Ya existe un hijo derecho");
        }
        this.right = new DynamicBinaryTree(a);
    }

    @Override
    public void removeLeft() {
        this.left = null;
        /*if(this.left.getLeft() != null) {
            // el borrado del hijo más a la derecha
        } else if(this.left.getRight() != null) {
            // el borrado del hijo más a la izquierda
        } else {
            this.left = null;
        }*/
    }

    @Override
    public void removeRight() {
        this.right = null;
    }
}
