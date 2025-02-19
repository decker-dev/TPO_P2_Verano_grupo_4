package org.example;

import org.example.model.BinaryTree;
import org.example.model.Dictionary;
import org.example.model.DynamicBinaryTree;
import org.example.util.BinaryTreeUtil;

public class App {

    public static void main(String[] args) {
        // Construir el árbol del ejemplo:
        // Nivel 0: nodo 1 (raíz)
        // Nivel 1: nodos 5 y 3
        // Nivel 2: el nodo 5 tiene hijos 7 y 6
        BinaryTree tree = new DynamicBinaryTree(1);
        tree.addLeft(5);
        tree.addRight(3);
        tree.getLeft().addLeft(7);
        tree.getLeft().addRight(6);

        // Mapear el árbol a un diccionario: clave = valor del nodo, valor = nivel
        Dictionary dict = BinaryTreeUtil.map(tree);

        // Imprimir el diccionario
        System.out.println("Mapa del árbol (nodo -> nivel):");
        // Se asume que dict.getKeys() retorna un Set iterable
    }
}