package org.example.model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StaticBinaryMerkleTree implements BinaryMerkleTree {

    private static final int MAX = 10; // Altura máxima del árbol
    private final Integer[] array;
    private final int indexRoot;

    /**
     * Constructor que crea un árbol estático con la raíz del valor dado.
     * Precondición: El valor de la raíz es válido.
     * Postcondición: Se inicializa el array que representa el árbol y se asigna la raíz.
     */
    public StaticBinaryMerkleTree(int value) {
        this.array = new Integer[(int) Math.pow(2, MAX) - 1];
        this.indexRoot = 0;
        this.array[indexRoot] = value;
    }

    /**
     * Constructor privado para instanciar subárboles.
     */
    private StaticBinaryMerkleTree(int indexRoot, Integer[] array) {
        this.array = array;
        this.indexRoot = indexRoot;
    }

    @Override
    public int getRoot() {
        return this.array[this.indexRoot];
    }

    @Override
    public BinaryMerkleTree getLeft() {
        int leftIndex = 2 * indexRoot + 1;
        if (leftIndex >= array.length || array[leftIndex] == null) {
            return null;
        }
        return new StaticBinaryMerkleTree(leftIndex, array);
    }

    @Override
    public BinaryMerkleTree getRight() {
        int rightIndex = 2 * indexRoot + 2;
        if (rightIndex >= array.length || array[rightIndex] == null) {
            return null;
        }
        return new StaticBinaryMerkleTree(rightIndex, array);
    }

    @Override
    public void addLeft(int value) {
        int leftIndex = 2 * indexRoot + 1;
        // Precondición: El índice debe estar dentro del array y no existir ya un hijo.
        if (leftIndex >= array.length) {
            throw new RuntimeException("Índice fuera de rango para hijo izquierdo");
        }
        if (array[leftIndex] != null) {
            throw new RuntimeException("Ya existe un hijo izquierdo");
        }
        array[leftIndex] = value;
    }

    @Override
    public void addRight(int value) {
        int rightIndex = 2 * indexRoot + 2;
        // Precondición: El índice debe estar dentro del array y no existir ya un hijo.
        if (rightIndex >= array.length) {
            throw new RuntimeException("Índice fuera de rango para hijo derecho");
        }
        if (array[rightIndex] != null) {
            throw new RuntimeException("Ya existe un hijo derecho");
        }
        array[rightIndex] = value;
    }

    @Override
    public void removeLeft() {
        int leftIndex = 2 * indexRoot + 1;
        if (leftIndex >= array.length || array[leftIndex] == null) {
            // Si no existe, no se realiza acción.
            return;
        }
        // Estrategia: Remover recursivamente los subárboles del hijo izquierdo.
        BinaryMerkleTree left = this.getLeft();
        if (left != null) {
            left.removeLeft();
            left.removeRight();
        }
        array[leftIndex] = null;
    }

    @Override
    public void removeRight() {
        int rightIndex = 2 * indexRoot + 2;
        if (rightIndex >= array.length || array[rightIndex] == null) {
            // Si no existe, no se realiza acción.
            return;
        }
        // Estrategia: Remover recursivamente los subárboles del hijo derecho.
        BinaryMerkleTree right = this.getRight();
        if (right != null) {
            right.removeLeft();
            right.removeRight();
        }
        array[rightIndex] = null;
    }

    /**
     * Función auxiliar para calcular el hash SHA‑256 de una cadena.
     */
    private String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String computeHash() {
        // Estrategia: Combinar el valor actual con los hashes de los hijos (si existen).
        String leftHash = "";
        BinaryMerkleTree left = this.getLeft();
        if (left != null) {
            leftHash = left.computeHash();
        }
        String rightHash = "";
        BinaryMerkleTree right = this.getRight();
        if (right != null) {
            rightHash = right.computeHash();
        }
        return sha256(String.valueOf(getRoot()) + leftHash + rightHash);
    }

    @Override
    public String getHash() {
        return computeHash();
    }
}