# Factory Pattern

El patrón Factory es un patrón de diseño creacional que proporciona una interfaz para crear objetos en una superclase, pero permite a las subclases alterar el tipo de objetos que se crearán. Este patrón es útil cuando el proceso de creación de un objeto es complejo o requiere lógica adicional.

## Ventajas

- Separa la creación de objetos de su uso.
- Facilita la adición de nuevas clases de productos sin modificar el código existente.
- Promueve la reutilización del código al centralizar la lógica de creación.
- Reduce el acoplamiento entre clases al utilizar interfaces o clases abstractas.
- Facilita la implementación de pruebas unitarias al permitir la creación de objetos simulados o dobles.
- Permite la creación de objetos en función de la configuración o el contexto, lo que mejora la flexibilidad del sistema.

## Desventajas

- Puede aumentar la complejidad del código al introducir múltiples clases y jerarquías.
- Puede dificultar la comprensión del código para los desarrolladores que no están familiarizados con el patrón.
- Puede llevar a un mayor uso de memoria si se crean muchas instancias de productos.
- Puede hacer que el código sea menos eficiente si se utilizan muchas capas de abstracción.
- Puede dificultar la depuración si se producen errores en la lógica de creación de objetos.

## Ejemplo

```java
// Interfaz del producto
public interface Product {
    void use();
}

// Implementación concreta del producto
public class ConcreteProductA implements Product {
    @Override
    public void use() {
        System.out.println("Using ConcreteProductA");
    }
}

// Implementación concreta del producto
public class ConcreteProductB implements Product {
    @Override
    public void use() {
        System.out.println("Using ConcreteProductB");
    }
}

// Interfaz de la fábrica
public interface Factory {
    Product createProduct();
}

// Implementación concreta de la fábrica
public class ConcreteFactoryA implements Factory {
    @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }
}
```


