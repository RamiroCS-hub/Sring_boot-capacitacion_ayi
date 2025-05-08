<div align="right">
<img width="32px" src="img/algo2.svg">
</div>

# TDA ABB

# ESTO ES UN TEMPLATE, COMPLETAR LO QUE HAGA FALTA, ELIMINAR LO QUE SOBRE (INCLUIDA ESTA LÍNEA)

## Alumno: (Nombre Apellido) - (Padrón) - (Mail)

- Para compilar:

```bash
línea de compilación
```

- Para ejecutar:

```bash
línea de ejecución
```

- Para ejecutar con valgrind:
```bash
línea con valgrind
```

---

##  Funcionamiento

Explicación de cómo funcionan las estructuras desarrolladas en el TP y el funcionamiento general del mismo.

Aclarar en esta parte todas las decisiones que se tomaron al realizar el TP, cosas que no se aclaren en el enunciado, fragmentos de código que necesiten explicación extra, etc.

Incluír **EN TODOS LOS TPS** los diagramas relevantes al problema (mayormente diagramas de memoria para explicar las estructuras, pero se pueden utilizar otros diagramas si es necesario).

### Por ejemplo:

El programa funciona abriendo el archivo pasado como parámetro y leyendolo línea por línea. Por cada línea crea un registro e intenta agregarlo al vector. La función de lectura intenta leer todo el archivo o hasta encontrar el primer error. Devuelve un vector con todos los registros creados.

<div align="center">
<img width="70%" src="img/diagrama1.svg">
</div>

En el archivo `sarasa.c` la función `funcion1` utiliza `realloc` para agrandar la zona de memoria utilizada para conquistar el mundo. El resultado de `realloc` lo guardo en una variable auxiliar para no perder el puntero original en caso de error:

```c
int *vector = realloc(vector_original, (n+1)*sizeof(int));

if(vector == NULL)
    return -1;
vector_original = vector;
```


<div align="center">
<img width="70%" src="img/diagrama2.svg">
</div>

---

## Respuestas a las preguntas teóricas
Incluír acá las respuestas a las preguntas del enunciado (si aplica).

# Árboles: Teoría, Implementación y Complejidad

## 1. Teoría de Árboles

### ¿Qué es un Árbol?
Un **árbol** es una estructura de datos jerárquica no lineal que consiste en nodos conectados por aristas. Sus características principales son:
- Tiene un único nodo raíz
- Cada nodo puede tener cero o más hijos
- No contiene ciclos
- Cualquier nodo puede tener un número arbitrario de hijos

![Árbol](https://media.geeksforgeeks.org/wp-content/uploads/20191005131555/General-Tree.jpg)

### ¿Qué es un Árbol Binario?
Un **árbol binario** es un tipo específico de árbol donde:
- Cada nodo puede tener como máximo dos hijos
- Estos hijos se designan específicamente como "hijo izquierdo" e "hijo derecho"
- No hay restricciones sobre los valores que pueden contener los nodos

![Árbol Binario](https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Binary_tree_v2.svg/300px-Binary_tree_v2.svg.png)

### ¿Qué es un Árbol Binario de Búsqueda (ABB)?
Un **árbol binario de búsqueda** añade la restricción de ordenamiento:
- Para cada nodo, todos los valores en su subárbol izquierdo son menores que el valor del nodo
- Para cada nodo, todos los valores en su subárbol derecho son mayores que el valor del nodo

![Árbol Binario de Búsqueda](https://upload.wikimedia.org/wikipedia/commons/thumb/d/da/Binary_search_tree.svg/300px-Binary_search_tree.svg.png)

### Ejemplos de uso
- **Árboles**: Sistemas de archivos 
- **Árboles Binarios**: Arboles de decisión
- **ABB**: Conjuntos ordenados, índices de bases de datos

## 2. Implementación de ABB

La implementación del Árbol Binario de Búsqueda fue desarrollada con las siguientes decisiones de diseño:

### Estructura de datos
- Se utiliza una estructura `nodo_t` para representar cada nodo del árbol, con punteros a sus hijos izquierdo y derecho
- La estructura `abb_t` contiene la raíz del árbol, el comparador de elementos y el contador de nodos

### Enfoque de implementación
### INSERCION
- **Algoritmo**: Implementada de forma iterativa. 
- **Complejidad**: Tiene una complejidad en tiempo de O(n) siendo 'n' la cantidad de nodos. Se van a recorrer todos los nodos en el caso de que se hayan insertado valores siempre mayores o siempre menores en orden quedando el arbol como una lista
![alt text](img/insercion.png)
- **Memoria**: 

![alt text](img/memoria_insert.png)

### BUSQUEDA
- **Forma**: Implementada de forma iterativa siguiendo un enfoque de descenso binario que aproveche la propiedad de ordenamiento
- **Complejidad**: Al igual que la inserción la búsqueda tiene una complejidad en tiempo de O(n). Igual que en el caso anterior esto ocurre cuando el arbol queda como una lista y se busca el nodo hoja

### ELIMINACION
- **Eliminación**: Implementada con tres casos distintos:
  - Eliminación de nodo hoja
  - Eliminación de nodo con un hijo
  - Eliminación de nodo con dos hijos (reemplazando con el predecesor inorden)
- **Recorridos**: Implementados tanto en forma recursiva como iterativa:
  - Recorrido recursivo: Más simple y elegante para entender
  - Recorrido iterativo: Más eficiente en términos de memoria para árboles grandes

graph TD
    A("actual (Nodo a eliminar con 2 hijos)");
    B("actual->izq");
    C("B->der");
    D("C->der (sustituto_padre)");
    E("D->der (sustituto - Predecesor Inorden)");
    F("actual->der");
    X1("...");
    X2("...");
    X3("...");

    A --> B;
    A --> F;
    B --> X1;
    B --> C;
    C --> X2;
    C --> D;
    D --> X3;
    D --> E["sustituto (Predecesor Inorden)<br/>Aquí termina el while"];

    subgraph "Búsqueda del Predecesor Inorden (Peor Caso - O(n))"
        direction LR
        B --"while (sustituto->der)"--> C;
        C --"while (sustituto->der)"--> D;
        D --"while (sustituto->der)"--> E;
    end

    style A fill:#f9d,stroke:#333,stroke-width:2px;
    style E fill:#9cf,stroke:#333,stroke-width:2px;
    style B fill:#lightgrey,stroke:#333,stroke-width:1px;
    style C fill:#lightgrey,stroke:#333,stroke-width:1px;
    style D fill:#lightgrey,stroke:#333,stroke-width:1px;
    style F fill:#lightgrey,stroke:#333,stroke-width:1px;

    linkStyle 0 stroke-width:2px,stroke:red,color:red;
    linkStyle 2 stroke-width:2px,stroke:blue,color:blue;
    linkStyle 4 stroke-width:2px,stroke:blue,color:blue;
    linkStyle 6 stroke-width:2px,stroke:blue,color:blue;

### Dificultades enfrentadas
- Manejo de punteros en la eliminación de nodos, especialmente para el caso de nodos con dos hijos
- Implementación de recorridos que puedan detenerse cuando la función de iteración devuelve false
- Liberación correcta de memoria, asegurando que no haya fugas ni referencias colgantes

## 3. Complejidad de las Operaciones

| Operación | Complejidad Promedio | Peor Caso | Mejor Caso |
|-----------|----------------------|-----------|------------|
| Búsqueda  | O(log n)             | O(n)      | O(1)       |
| Inserción | O(log n)             | O(n)      | O(1)       |
| Eliminación | O(log n)           | O(n)      | O(1)       |
| Recorrido | O(n)                 | O(n)      | O(n)       |

La complejidad depende de la forma del árbol:
- En un ABB balanceado, las operaciones principales tienen complejidad O(log n)
- En un ABB degenerado (similar a una lista enlazada), las operaciones tienen complejidad O(n)

Las operaciones son más eficientes cuando el árbol está balanceado, lo que ocurre cuando los elementos se insertan en un orden que distribuye equitativamente los nodos entre los subárboles izquierdo y derecho.
