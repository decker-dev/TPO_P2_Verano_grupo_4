# FINAl REGULAR 2024-2C

## PUNTO 1

la razón principal de no aplicar búsqueda binaria es la naturaleza de la estructura (lista enlazada), la
cual no permite acceso aleatorio eficiente. En lugar de ello, se optó por una inserción ordenada que garantiza que, si
en el futuro se utiliza una estructura con acceso aleatorio, la búsqueda binaria pueda ser implementada sin mayores
cambios en la lógica de ordenación y manejo de duplicados.

## PUNTO 3

### A)

En la implementación actual del Diccionario Simple (por ejemplo, en la clase DynamicDictionary), los nodos se insertan
al final o según el orden de llegada. Para mantener el diccionario ordenado por clave, se debe modificar el método add(
int key, int value) para que inserte cada nuevo nodo en la posición correcta según el orden de la clave.

### B)

Ventajas:

* Seguridad y consistencia:
  Una estructura inmutable garantiza que, una vez creada, no se puede modificar. Esto evita errores por modificaciones
  inesperadas y facilita el razonamiento sobre el comportamiento del sistema.
* Facilidad en pruebas y depuración:
  La inmutabilidad elimina efectos secundarios, haciendo que las funciones y algoritmos que operan sobre el árbol sean
  más
  predecibles y sencillos de probar.

Desventajas:

* Costo de actualización:
  Cada operación que modifique el árbol (como inserciones o eliminaciones) requiere crear una nueva versión de la
  estructura. Aunque se pueden reutilizar partes no modificadas, esta recreación puede implicar un mayor consumo de
  memoria y tiempo de ejecución.
* Complejidad en la implementación:
  Adaptar algoritmos clásicos de árboles binarios a un contexto inmutable
  puede resultar más complejo, ya que es necesario gestionar la creación de nuevos nodos y la compartición estructural
  de
  manera cuidadosa.
* Uso de recursos:
  En escenarios donde se realizan muchas actualizaciones, el costo de crear nuevas versiones y mantener nodos antiguos (
  incluso compartidos) puede llevar a un mayor consumo de memoria en comparación con una estructura mutable optimizada.