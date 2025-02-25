package org.example.final_2025.punto_2.util;

import org.example.final_2025.punto_2.model.BinaryTree;
import org.example.final_2025.punto_2.model.Stack;
import org.example.final_2025.punto_2.model.StaticStack;

public class BinaryTreeUtil {

    private BinaryTreeUtil() {

    }

    public static int totalNodes(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return 0;
        }

        return 1 + totalNodes(binaryTree.getLeft()) + totalNodes(binaryTree.getRight());
    }

    public static int height(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return 0;
        }

        return 1 + Math.max(height(binaryTree.getLeft()), height(binaryTree.getRight()));
    }

    public static boolean isFull(BinaryTree binaryTree) {
        return totalNodes(binaryTree) == Math.pow(2, height(binaryTree)) - 1;
    }

    public static boolean isComplete(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return true;
        }

        if (binaryTree.getLeft() != null && binaryTree.getRight() == null ||
                binaryTree.getLeft() == null && binaryTree.getRight() != null) {
            return false;
        }

        return isComplete(binaryTree.getLeft()) && isComplete(binaryTree.getRight());
    }

    public static int totalLeaves(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return 0;
        }

        return (binaryTree.getLeft() == null && binaryTree.getRight() == null ? 1 : 0)
                + totalLeaves(binaryTree.getLeft()) + totalLeaves(binaryTree.getRight());
    }

    public static void printPreOrder(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return;
        }
        System.out.println(binaryTree.getRoot());
        printPreOrder(binaryTree.getLeft());
        printPreOrder(binaryTree.getRight());
    }

    public static void printPreOrderLeaves(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return;
        }
        if (binaryTree.getLeft() == null && binaryTree.getRight() == null) {
            System.out.println(binaryTree.getRoot());
        }
        printPreOrder(binaryTree.getLeft());
        printPreOrder(binaryTree.getRight());
    }

    public static Stack mapPreOrder(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return null;
        }
        Stack result = new StaticStack();
        result.add(binaryTree.getRoot());
        fill(binaryTree.getLeft(), result);
        fill(binaryTree.getRight(), result);
        return result;
    }

    private static void fill(BinaryTree binaryTree, Stack stack) {
        if (binaryTree == null) {
            return;
        }
        stack.add(binaryTree.getRoot());
        fill(binaryTree.getLeft(), stack);
        fill(binaryTree.getRight(), stack);
    }

    public static boolean isSBT(BinaryTree binaryTree) {
        return isSBT(binaryTree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isSBT(BinaryTree binaryTree, int min, int max) {
        if (binaryTree == null) {
            return true;
        }

        if (binaryTree.getRoot() > max || binaryTree.getRoot() < min) {
            return false;
        }

        return isSBT(binaryTree.getLeft(),
                min,
                Math.min(max, binaryTree.getRoot())) &&

                isSBT(binaryTree.getRight(),
                        Math.max(min, binaryTree.getRoot()),
                        max);
    }
    /**
     * Verifica si un arreglo de Integer podría ser el atributo interno de la
     * implementación estática de árbol binario.
     *
     * Para ello se requiere que:
     *  - El primer elemento (índice 0) no sea null.
     *  - Para cada índice i > 0, si array[i] no es null, entonces el elemento
     *    en la posición (i - 1) / 2 (el padre) también debe existir (no ser null).
     *
     * @param array el arreglo de Integer a verificar
     * @return true si el arreglo cumple la condición, false de lo contrario
     */
    public static boolean couldBeStaticBinaryTreeAttribute(Integer[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        if (array[0] == null) {
            return false;
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i] != null) {
                int parentIndex = (i - 1) / 2;
                if (array[parentIndex] == null) {
                    return false;
                }
            }
        }
        return true;
    }
}
