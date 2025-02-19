package org.example.model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DynamicBinaryMerkleTree implements BinaryMerkleTree {

    private final int value;
    private BinaryMerkleTree left;
    private BinaryMerkleTree right;

    /**
     * Constructor que crea un nodo con el valor dado.
     * Precondición: Ninguna.
     * Postcondición: Se crea un nodo sin hijos.
     */
    public DynamicBinaryMerkleTree(int value) {
        this.value = value;
    }

    @Override
    public int getRoot() {
        return this.value;
    }

    @Override
    public BinaryMerkleTree getLeft() {
        return this.left;
    }

    @Override
    public BinaryMerkleTree getRight() {
        return this.right;
    }

    @Override
    public void addLeft(int value) {
        // Precondición: this.left debe ser null.
        if (this.left != null) {
            throw new RuntimeException("Ya existe un hijo izquierdo");
        }
        // Estrategia: Crear un nuevo nodo y asignarlo a left.
        this.left = new DynamicBinaryMerkleTree(value);
    }

    @Override
    public void addRight(int value) {
        // Precondición: this.right debe ser null.
        if (this.right != null) {
            throw new RuntimeException("Ya existe un hijo derecho");
        }
        // Estrategia: Crear un nuevo nodo y asignarlo a right.
        this.right = new DynamicBinaryMerkleTree(value);
    }

    @Override
    public void removeLeft() {
        // Precondición: Si no existe left, no se realiza acción.
        // Estrategia: Asignar null al hijo izquierdo.
        this.left = null;
    }

    @Override
    public void removeRight() {
        // Precondición: Si no existe right, no se realiza acción.
        // Estrategia: Asignar null al hijo derecho.
        this.right = null;
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
        String leftHash = (this.left == null) ? "" : this.left.computeHash();
        String rightHash = (this.right == null) ? "" : this.right.computeHash();
        return sha256(String.valueOf(this.value) + leftHash + rightHash);
    }

    @Override
    public String getHash() {
        // Postcondición: Se retorna el hash actualizado del nodo.
        return computeHash();
    }
}