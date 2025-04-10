# Singleton Pattern

El patrón Singleton asegura que una clase tenga una única instancia y proporciona un punto de acceso global a ella.

## Ventajas

- Controla el acceso a la instancia única.
- Reduce el uso de memoria al evitar la creación de múltiples instancias.
- Facilita el control de recursos compartidos.
- Proporciona un punto de acceso global a la instancia.

## Desventajas

- Puede dificultar la prueba de unidades debido a su naturaleza global.
- Puede introducir problemas de concurrencia si no se maneja adecuadamente.
- Puede llevar a un diseño acoplado si se usa en exceso.
- Dificulta la extensión de la clase, ya que no se puede heredar de una clase Singleton.

## Ejemplo

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // Constructor privado para evitar instanciación externa
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

## Uso

```java
public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        // Usar la instancia singleton
    }
}
```

## Conclusión

El patrón Singleton es útil cuando se necesita garantizar que una clase tenga una única instancia y proporcionar un punto de acceso global a ella. Sin embargo, debe usarse con precaución para evitar problemas de diseño y pruebas.

