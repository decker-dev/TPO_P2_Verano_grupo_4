package org.example.model;

public class DynamicSearchTernaryTree implements SearchTernaryTree {
    private final TernaryTree ternaryTree;

    public DynamicSearchTernaryTree(int root) {
        this.ternaryTree = new DynamicTernaryTree(root);  // Asumiendo que existe DynamicTernaryTree
    }

    private DynamicSearchTernaryTree(TernaryTree ternaryTree) {
        this.ternaryTree = ternaryTree;
    }

    @Override
    public int getRoot() {
        return this.ternaryTree.getRoot();
    }

    @Override
    public SearchTernaryTree getLeft() {
        TernaryTree left = this.ternaryTree.getLeft();
        if (left == null) {
            return null;
        }
        return new DynamicSearchTernaryTree(left);
    }

    @Override
    public SearchTernaryTree getMid() {
        TernaryTree mid = this.ternaryTree.getMid();
        if (mid == null) {
            return null;
        }
        return new DynamicSearchTernaryTree(mid);
    }

    @Override
    public SearchTernaryTree getRight() {
        TernaryTree right = this.ternaryTree.getRight();
        if (right == null) {
            return null;
        }
        return new DynamicSearchTernaryTree(right);
    }

    @Override
    public void add(int a) {
        if (a < this.getRoot()) {
            if (this.getLeft() != null) {
                this.getLeft().add(a);
            } else {
                this.ternaryTree.addLeft(a);
            }
        } else if (a == this.getRoot()) {
            if (this.getMid() != null) {
                this.getMid().add(a);
            } else {
                this.ternaryTree.addMid(a);
            }
        } else {  // a > this.getRoot()
            if (this.getRight() != null) {
                this.getRight().add(a);
            } else {
                this.ternaryTree.addRight(a);
            }
        }
    }

    @Override
    public void removeLeft() {
        this.ternaryTree.removeLeft();
    }

    @Override
    public void removeMid() {
        this.ternaryTree.removeMid();
    }

    @Override
    public void removeRight() {
        this.ternaryTree.removeRight();
    }
}

