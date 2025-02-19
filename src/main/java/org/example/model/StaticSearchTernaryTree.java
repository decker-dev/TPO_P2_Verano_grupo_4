package org.example.model;



public class StaticSearchTernaryTree implements SearchTernaryTree {
    private final TernaryTree ternaryTree;

    public StaticSearchTernaryTree(int root) {
        this.ternaryTree = new StaticTernaryTree(root);
    }

    private StaticSearchTernaryTree(TernaryTree ternaryTree) {
        this.ternaryTree = ternaryTree;
    }

    @Override
    public int getRoot() {
        return this.ternaryTree.getRoot();
    }

    @Override
    public StaticSearchTernaryTree getLeft() {
        TernaryTree left = this.ternaryTree.getLeft();
        if (left == null) {
            return null;
        }
        return new StaticSearchTernaryTree(left);
    }

    @Override
    public StaticSearchTernaryTree getMid() {
        TernaryTree mid = this.ternaryTree.getMid();
        if (mid == null) {
            return null;
        }
        return new StaticSearchTernaryTree(mid);
    }

    @Override
    public StaticSearchTernaryTree getRight() {
        TernaryTree right = this.ternaryTree.getRight();
        if (right == null) {
            return null;
        }
        return new StaticSearchTernaryTree(right);
    }

    @Override
    public void add(int a) {
        if (a < this.getRoot()) {
            this.ternaryTree.addLeft(a);
            if (this.getLeft() != null) {
                this.getLeft().add(a);
            }
        } else if (a == this.getRoot()) {
            this.ternaryTree.addMid(a);
            if (this.getMid() != null) {
                this.getMid().add(a);
            }
        } else {  // a > this.getRoot()
            this.ternaryTree.addRight(a);
            if (this.getRight() != null) {
                this.getRight().add(a);
            }
        }
    }

    @Override
    public void removeLeft() {
        this.ternaryTree.removeLeft();
    }

    @Override
    public void removeRight() {
        this.ternaryTree.removeRight();
    }

    @Override
    public void removeMid() {
        this.ternaryTree.removeMid();
    }
}
