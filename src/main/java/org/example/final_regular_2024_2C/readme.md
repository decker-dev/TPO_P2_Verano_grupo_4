En esta solución no se aplicó búsqueda binaria para localizar una clave en el diccionario, y te explico el porqué:
1.	Estructura de Claves con Lista Enlazada:
La implementación actual del diccionario utiliza una lista enlazada para almacenar los nodos (cada nodo representa una clave y su lista asociada de valores). En una lista enlazada, el acceso a un elemento en una posición intermedia requiere recorrer la lista desde el inicio hasta esa posición, lo que implica un costo lineal (O(n)). La búsqueda binaria, en cambio, requiere acceso aleatorio (como en un arreglo o un árbol balanceado) para dividir el espacio de búsqueda en mitades de forma eficiente.
•	Por eso, dado que nuestra estructura es una lista enlazada, la búsqueda binaria no es práctica.
2.	Alternativa Aplicada: Ordenamiento en la Inserción:
Como no podemos usar búsqueda binaria en la lista enlazada, la solución se enfocó en:
•	Mantener las claves ordenadas al momento de insertarlas en el diccionario. Esto se hace recorriendo la lista enlazada y posicionando el nuevo nodo en la posición correcta según el orden.
•	Mantener los valores asociados a cada clave ordenados y sin duplicados.
Para ello, se implementó el método auxiliar insertValueSorted que:
•	Recibe el nodo correspondiente a la clave.
•	Recorre la lista de valores asociada a esa clave para encontrar la posición correcta de inserción (de forma ordenada).
•	Verifica que el valor a insertar no se duplique.
De esta forma, se garantiza que cada lista de valores esté siempre ordenada y sin repeticiones.
3.	Motivación y Ventajas de Esta Aproximación:
•	Ordenar las claves y los valores: Facilita la gestión de la estructura y, en un futuro, si se decide cambiar la implementación (por ejemplo, usar un arreglo o un árbol), se podrá aprovechar la ordenación para aplicar búsqueda binaria u otras técnicas de búsqueda eficiente.
•	Evitar duplicados en los valores: Esto simplifica operaciones posteriores, ya que se tiene la seguridad de que cada valor es único para una clave.

En resumen, la razón principal de no aplicar búsqueda binaria es la naturaleza de la estructura (lista enlazada), la cual no permite acceso aleatorio eficiente. En lugar de ello, se optó por una inserción ordenada que garantiza que, si en el futuro se utiliza una estructura con acceso aleatorio, la búsqueda binaria pueda ser implementada sin mayores cambios en la lógica de ordenación y manejo de duplicados.

