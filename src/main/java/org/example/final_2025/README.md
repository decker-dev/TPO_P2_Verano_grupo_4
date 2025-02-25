# Final Adelantado 2025

## PUNTO 3

### A

Para hacer que el número (en el ejercicio, el 3) sea variable, lo que se puede hacer es introducir un atributo en la
clase, por ejemplo, llamado k, que almacene ese valor. Con este cambio, las condiciones se modificarían de la
siguiente forma:
En el método add, en lugar de verificar que la suma total más el nuevo elemento sea múltiplo de 3, se verifica que no
sea múltiplo de k:

```java
if((this.sum +a)%k ==0){
        throw new

RuntimeException("No se puede agregar el elemento "+a +
        " porque la suma resultante ("+(this.sum+a) +") es un múltiplo de "+k);
        }
```

En el método remove, se realiza una verificación similar para la suma que quedaría:

```java
if((this.sum -valueToRemove)%k ==0){
        throw new

RuntimeException("No se puede eliminar el elemento "+valueToRemove +
        " porque la suma de los elementos restantes ("+(this.sum-valueToRemove) +
        ") sería un múltiplo de "+k);
        }
```

En el método topCandidate, se cambia la condición para que devuelva el primer elemento cuyo retiro haga que la suma de
los restantes no sea múltiplo de k:

```java
if((this.sum -candidateValue)%k !=0){
        return candidateValue;
}
```

En cuanto a la complejidad computacional, se ve afectada ya que al pasar de 3 a K pasamos de una complejidad constante(
3)
a una lineal

### B

Al eliminar la raíz se reemplaza su valor por el de un nodo candidato, se elimina ese nodo de su
posición original y se reestructura el árbol mediante rotaciones para mantener el balance AVL.