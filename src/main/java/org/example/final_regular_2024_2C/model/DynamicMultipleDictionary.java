package org.example.final_regular_2024_2C.model;

import org.example.final_regular_2024_2C.model.nodes.MultipleDictionaryNode;
import org.example.final_regular_2024_2C.model.nodes.Node;

public class DynamicMultipleDictionary implements MultipleDictionary {

    private MultipleDictionaryNode node;

    @Override
    public List get(int key) {
        if (this.node == null) {
            throw new RuntimeException("No se puede obtener un valor de una estructura vacía");
        }
        MultipleDictionaryNode aux = this.node;
        while (aux.getNext() != null) {
            if (aux.getKey() == key) {
                return map(aux.getValue());
            }
            aux = aux.getNext();
        }
        if (aux.getKey() == key) {
            return map(aux.getValue());
        }

        throw new RuntimeException("La clave no existe");
    }

    private List map(Node node) {
        List list = new LinkedList();
        Node aux = node;
        while (aux != null) {
            list.add(aux.getValue());
            aux = aux.getNext();
        }
        return list;
    }

    @Override
    public Set getKeys() {
        Set result = new DynamicSet();

        MultipleDictionaryNode aux = this.node;
        while (aux != null) {
            result.add(aux.getKey());
            aux = aux.getNext();
        }

        return result;
    }

    @Override
    public void add(int key, int value) {
        // Caso base: si la estructura está vacía, se crea el primer nodo
        if (this.node == null) {
            this.node = new MultipleDictionaryNode(key, new Node(value, null), null);
            return;
        }

        // Si la nueva clave es menor que la del primer nodo, inserción al inicio
        if (key < this.node.getKey()) {
            this.node = new MultipleDictionaryNode(key, new Node(value, null), this.node);
            return;
        }

        MultipleDictionaryNode prev = null;
        MultipleDictionaryNode current = this.node;

        // Recorrer la lista hasta hallar la posición donde la clave es mayor o igual a la nueva clave
        while (current != null && current.getKey() < key) {
            prev = current;
            current = current.getNext();
        }

        // Si la clave ya existe, se inserta el valor ordenadamente (sin duplicados)
        if (current != null && current.getKey() == key) {
            insertValueSorted(current, value);
        } else {
            // Si la clave no existe, se crea un nuevo nodo y se inserta en orden
            MultipleDictionaryNode newNode = new MultipleDictionaryNode(key, new Node(value, null), current);
            if (prev != null) {
                prev.setNext(newNode);
            }
        }
    }

    /**
     * Inserta el valor en la lista de valores del nodo, manteniendo el orden y evitando duplicados.
     */
    private void insertValueSorted(MultipleDictionaryNode dictNode, int value) {
        Node head = dictNode.getValue();

        // Si el nuevo valor es menor que el valor del primer nodo, se inserta al inicio
        if (value < head.getValue()) {
            dictNode.setValue(new Node(value, head));
            return;
        }

        // Si el valor es igual al del primer nodo, se evita la duplicación
        if (head.getValue() == value) {
            return;
        }

        Node prev = head;
        Node current = head.getNext();

        // Recorrer la lista hasta encontrar la posición de inserción
        while (current != null && current.getValue() < value) {
            prev = current;
            current = current.getNext();
        }

        // Si se encuentra un valor duplicado, no se inserta
        if (current != null && current.getValue() == value) {
            return;
        }

        // Inserta el nuevo valor manteniendo el orden
        Node newNode = new Node(value, current);
        prev.setNext(newNode);
    }

    @Override
    public void remove(int key, int value) {
        if (this.node == null) {
            throw new RuntimeException("La clave no existe");
        }

        if (this.node.getNext() == null) {
            if (this.node.getKey() == key) {
                if (this.node.getValue().getNext() == null) {
                    if (this.node.getValue().getValue() == value) {
                        this.node = null;
                        return;
                    }
                    throw new RuntimeException("No existe el valor para la clave indicada");
                }

                boolean result = remove(value, this.node.getValue());
                if (!result) {
                    throw new RuntimeException("No existe el valor para la clave indicada");
                }

                return;
            }
            throw new RuntimeException("La clave no existe");
        }

        if (this.node.getKey() == key) {
            if (this.node.getValue().getNext() == null) {
                if (this.node.getValue().getValue() == value) {
                    this.node = this.node.getNext();
                    return;
                }
                throw new RuntimeException("No existe el valor para la clave indicada");
            }

            boolean result = remove(value, this.node.getValue());
            if (!result) {
                throw new RuntimeException("No existe el valor para la clave indicada");
            }
            return;
        }

        MultipleDictionaryNode backup = this.node;
        MultipleDictionaryNode current = this.node.getNext();
        while (current != null) {
            if (current.getKey() == key) {
                if (current.getValue().getNext() == null) {
                    if (current.getValue().getValue() == value) {
                        backup.setNext(current.getNext());
                        return;
                    }
                    throw new RuntimeException("No existe el valor para la clave indicada");
                }
                boolean result = remove(value, current.getValue());
                if (!result) {
                    throw new RuntimeException("No existe el valor para la clave indicada");
                }
                return;
            }
            backup = current;
            current = current.getNext();
        }

        throw new RuntimeException("La clave no existe");
    }

    private boolean remove(int value, Node node) {
        Node backup = node;
        Node current = node.getNext();

        while (current.getNext() != null) {
            if (current.getValue() == value) {
                backup.setNext(current.getNext());
                return true;
            }
            backup = current;
            current = current.getNext();
        }

        if (current.getValue() == value) {
            backup.setNext(current.getNext());
            return true;
        }

        return false;
    }
}
