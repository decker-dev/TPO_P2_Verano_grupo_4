package org.example.model;

public interface BinaryMerkleTree {

    /**
     * Devuelve el valor almacenado en el nodo.
     * Precondición: El nodo no es nulo.
     * Postcondición: Se retorna el valor almacenado.
     */
    int getRoot();

    /**
     * Devuelve el hash del árbol (calculado en la raíz).
     * Precondición: El nodo no es nulo.
     * Postcondición: Se retorna el hash computado.
     */
    String getHash();

    /**
     * Devuelve el subárbol izquierdo.
     * Precondición: El subárbol izquierdo existe.
     * Postcondición: Se retorna una referencia al subárbol izquierdo.
     */
    BinaryMerkleTree getLeft();

    /**
     * Devuelve el subárbol derecho.
     * Precondición: El subárbol derecho existe.
     * Postcondición: Se retorna una referencia al subárbol derecho.
     */
    BinaryMerkleTree getRight();

    /**
     * Agrega un subárbol izquierdo con el valor especificado.
     * Precondición: No debe existir ya un hijo izquierdo.
     * Postcondición: Se crea el subárbol izquierdo con el valor dado y se actualiza el hash.
     * Estrategia: Se verifica la ausencia del hijo y se instancia un nuevo nodo.
     */
    void addLeft(int value);

    /**
     * Agrega un subárbol derecho con el valor especificado.
     * Precondición: No debe existir ya un hijo derecho.
     * Postcondición: Se crea el subárbol derecho con el valor dado y se actualiza el hash.
     * Estrategia: Se verifica la ausencia del hijo y se instancia un nuevo nodo.
     */
    void addRight(int value);

    /**
     * Remueve el subárbol izquierdo.
     * Precondición: El subárbol izquierdo debe existir (aunque, si no existe, no se realiza acción).
     * Postcondición: Se elimina el subárbol izquierdo y se actualiza el hash.
     * Estrategia: Se asigna null al hijo izquierdo y se propaga la actualización.
     */
    void removeLeft();

    /**
     * Remueve el subárbol derecho.
     * Precondición: El subárbol derecho debe existir (aunque, si no existe, no se realiza acción).
     * Postcondición: Se elimina el subárbol derecho y se actualiza el hash.
     * Estrategia: Se asigna null al hijo derecho y se propaga la actualización.
     */
    void removeRight();

    /**
     * Computa y retorna el hash del nodo basado en su valor y en los hashes de sus subárboles.
     * Precondición: Los hijos pueden ser nulos.
     * Postcondición: Se retorna el hash actualizado en forma de cadena.
     * Estrategia: Se utiliza una función hash (por ejemplo, SHA‑256) que combina el valor y los hashes de los hijos.
     */
    String computeHash();
}