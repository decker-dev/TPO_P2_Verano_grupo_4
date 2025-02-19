package org.example.util;

import org.example.model.*;

public class BinaryTreeUtil {

    public static int totalNodes(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return 0;
        }

        return 1 + totalNodes(binaryTree.getLeft()) + totalNodes(binaryTree.getRight());
    }

    public static int height(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return 0;
        }

        return 1 + Math.max(height(binaryTree.getLeft()), height(binaryTree.getRight()));
    }

    public static boolean isFull(BinaryTree binaryTree) {
        return totalNodes(binaryTree) == Math.pow(2, height(binaryTree)) - 1;
    }

    public static boolean isComplete(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return true;
        }

        if(binaryTree.getLeft() != null && binaryTree.getRight() == null ||
                binaryTree.getLeft() == null && binaryTree.getRight() != null) {
            return false;
        }

        return isComplete(binaryTree.getLeft()) && isComplete(binaryTree.getRight());
    }

    /**
     * Precondiciones:La cola debe tener al menos un valor.
     * @param queue Cola a convertir en arbol
     * @return Devuelve la cola convertida a un arbol binario sesgado a la derecha
     */
    public static BinaryTree QueueToSkewedRightTree(Queue queue) {
        if (queue.isEmpty()) {
            throw new RuntimeException("Error, la cola está vacía.");
        }

        BinaryTree result = new DynamicBinaryTree(queue.getFirst());
        queue.remove();

        BinaryTree current = result; //Mantiene el nodo actual

        while (!queue.isEmpty()) {
            current.addRight(queue.getFirst());  //agrega un nuevo nodo a la derecha
            queue.remove();
            current = current.getRight();  //Mueve el puntero hacia el nuevo nodo derecho
        }

        return result;
    }

    /**
     * Precondiciones:La cola debe tener al menos un valor.
     * @param queue Cola a convertir en arbol
     * @return Devuelve la cola convertida a un arbol binario sesgado a la izquierda
     */
    public static BinaryTree QueueToSkewedLeftTree(Queue queue) {
        if (queue.isEmpty()) {
            throw new RuntimeException("Error, la cola está vacía.");
        }

        BinaryTree result = new DynamicBinaryTree(queue.getFirst());
        queue.remove();

        BinaryTree current = result;

        while (!queue.isEmpty()) {
            current.addLeft(queue.getFirst());  //Agrega un nuevo nodo a la izquierda
            queue.remove();
            current = current.getLeft();  //Mueve el puntero hacia el nuevo nodo izquierdo
        }

        return result;
    }

    /**
     * Precondiciones:Ambos arboles no deben estar vacios.
     * @param tree1,tree2 Arboles de busqueda a convertir
     * @return Combina ambos arboles.
     */
    public static SearchBinaryTree mergeTrees(SearchBinaryTree tree1, SearchBinaryTree tree2) {
        if (tree1 == null) {
            return tree2;
        }
        if (tree2 == null) {
            return tree1;
        }

        insertTree(tree1, tree2);
        return tree1;
    }

    /**
     * Precondiciones:Ambos arboles no deben estar vacios.
     * @param target,source Target siendo el arbol a modificar, source siendo el que sera integrado al target.
     * @return Inserta un arbol a otro de forma recursiva.
     */
    private static void insertTree(SearchBinaryTree target, SearchBinaryTree source) {
        if (source == null) {
            return;
        }

        // Insertamos la raíz del árbol fuente en el árbol destino
        target.add(source.getRoot());

        // Insertamos los nodos del subárbol izquierdo y derecho recursivamente
        insertTree(target, source.getLeft());
        insertTree(target, source.getRight());
    }

    /**
     * Recorre el árbol binario y mapea cada nodo a un diccionario donde la clave
     * es el valor del nodo y el valor es el nivel (altura relativa al nodo raíz).
     *
     * @param tree el árbol binario a mapear
     * @return un Dictionary con cada nodo mapeado a su nivel
     */
    public static Dictionary map(BinaryTree tree) {
        Dictionary dict = new DynamicDictionary();
        mapRec(tree, dict, 0);
        return dict;
    }

    /**
     * Método auxiliar que recorre el árbol en preorden.
     *
     * @param tree  el nodo actual del árbol
     * @param dict  el diccionario donde se agregan los pares (nodo, nivel)
     * @param level el nivel actual del nodo (la raíz es nivel 0)
     */
    private static void mapRec(BinaryTree tree, Dictionary dict, int level) {
        if (tree == null) {
            return;
        }
        // Se agrega el nodo actual al diccionario
        dict.add(tree.getRoot(), level);
        // Se recorre el subárbol izquierdo aumentando el nivel
        mapRec(tree.getLeft(), dict, level + 1);
        // Se recorre el subárbol derecho aumentando el nivel
        mapRec(tree.getRight(), dict, level + 1);
    }
    /**
     * Calcula la intersección de dos árboles binarios.
     * Solo se incluyen los nodos (y sus ramas) si el camino completo desde la raíz coincide.
     *
     * @param t1 Primer árbol.
     * @param t2 Segundo árbol.
     * @return Un nuevo árbol que es la intersección de t1 y t2, o null si no coincide la raíz.
     */
    public static BinaryTree intersection(BinaryTree t1, BinaryTree t2) {
        if (t1 == null || t2 == null) return null;
        if (t1.getRoot() != t2.getRoot()) return null;  // Si la raíz no coincide, se descarta todo

        // La raíz coincide: creamos la raíz del árbol de intersección.
        DynamicBinaryTree result = new DynamicBinaryTree(t1.getRoot());

        // Procesar recursivamente la rama izquierda
        BinaryTree leftInt = intersection(t1.getLeft(), t2.getLeft());
        if (leftInt != null) {
            attachSubtree(result, leftInt, true);
        }
        // Procesar recursivamente la rama derecha
        BinaryTree rightInt = intersection(t1.getRight(), t2.getRight());
        if (rightInt != null) {
            attachSubtree(result, rightInt, false);
        }
        return result;
    }

    /**
     * Método auxiliar para copiar recursivamente un subárbol (resultado de la intersección)
     * en el árbol destino, en la posición indicada (izquierda o derecha).
     *
     * @param parent Nodo en el que se adjuntará el subárbol.
     * @param subTree Subárbol a copiar.
     * @param attachLeft true para adjuntar en el hijo izquierdo, false en el derecho.
     */
    private static void attachSubtree(DynamicBinaryTree parent, BinaryTree subTree, boolean attachLeft) {
        if (subTree == null) return;
        if (attachLeft) {
            // Agregamos el nodo en la posición izquierda.
            parent.addLeft(subTree.getRoot());
            // Obtenemos el nodo recién creado para continuar la copia.
            DynamicBinaryTree child = (DynamicBinaryTree) parent.getLeft();
            attachSubtree(child, subTree.getLeft(), true);
            attachSubtree(child, subTree.getRight(), false);
        } else {
            // Agregamos el nodo en la posición derecha.
            parent.addRight(subTree.getRoot());
            DynamicBinaryTree child = (DynamicBinaryTree) parent.getRight();
            attachSubtree(child, subTree.getLeft(), true);
            attachSubtree(child, subTree.getRight(), false);
        }
    }
}
