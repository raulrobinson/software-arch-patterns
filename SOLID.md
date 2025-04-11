# Principio SOLID

Los principios SOLID son cinco principios fundamentales de diseño de software orientado a objetos que ayudan a que el código sea más mantenible, extensible y comprensible.

Estos principios son:

🧱 1. S - Single Responsibility Principle (SRP)

    "Una clase debe tener una única razón para cambiar"

    Una clase debe hacer una sola cosa.

🧱 2. O - Open/Closed Principle (OCP)

    "Las clases deben estar abiertas para extensión, pero cerradas para modificación"

🧱 3. L - Liskov Substitution Principle (LSP)

    "Las clases hijas deben poder sustituir a sus clases padre sin alterar el comportamiento"

🧱 4. I - Interface Segregation Principle (ISP)

    "Los clientes no deben depender de interfaces que no utilizan"

🧱 5. D - Dependency Inversion Principle (DIP)

    "Depende de abstracciones, no de concreciones"

## Ejemplo de cada principio

### 1. Single Responsibility Principle (SRP)

```java
// Incorrecto: mezcla lógica de negocio y persistencia
public class UserService {
    public void register(User user) {
        // lógica de registro
    }

    public void saveUser(User user) {
        // guardado en base de datos
    }
}

// Solo lógica de negocio
@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void register(User user) {
        // lógica de registro
        repository.save(user);
    }
}

// Solo acceso a datos
@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
```

### 2. Open/Closed Principle (OCP)

```java
public interface DiscountStrategy {
    double applyDiscount(double price);
}

@Component
public class BlackFridayDiscount implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price * 0.5;
    }
}

// Se puede agregar más estrategias sin modificar la lógica de negocio:
@Service
public class CheckoutService {
    private final DiscountStrategy discount;

    public CheckoutService(DiscountStrategy discount) {
        this.discount = discount;
    }

    public double checkout(double price) {
        return discount.applyDiscount(price);
    }
}
```

### 3. Liskov Substitution Principle (LSP)

```java
public interface Notification {
    void send(String message);
}

public class EmailNotification implements Notification {
    public void send(String message) {
        // envía email
    }
}

public class SMSNotification implements Notification {
    public void send(String message) {
        // envía SMS
    }
}

// Puede usar cualquier implementación sin romperse
@Service
public class AlertService {
    private final Notification notification;

    public AlertService(Notification notification) {
        this.notification = notification;
    }

    public void alert(String msg) {
        notification.send(msg);
    }
}
```

### 4. Interface Segregation Principle (ISP)

```java
// Mala práctica: interfaz grande
public interface Worker {
    void code();
    void test();
    void manage();
}

// Buenas prácticas: interfaces pequeñas
public interface Developer {
    void code();
}

public interface Tester {
    void test();
}

public interface Manager {
    void manage();
}
```

#### 5. Dependency Inversion Principle (DIP)

```java
public interface PaymentProcessor {
    void process(double amount);
}

@Component
public class StripeProcessor implements PaymentProcessor {
    public void process(double amount) {
        System.out.println("Pagando con Stripe: " + amount);
    }
}

@Service
public class PaymentService {
    private final PaymentProcessor processor;

    public PaymentService(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void pay(double amount) {
        processor.process(amount);
    }
}
```

### Conclusión

Los principios SOLID son fundamentales para el diseño de software orientado a objetos. Aplicarlos correctamente puede mejorar la calidad del código, facilitar su mantenimiento y permitir una mejor colaboración entre desarrolladores. Recuerda que no siempre es necesario aplicar todos los principios en cada situación, pero tenerlos en mente te ayudará a tomar decisiones más informadas al diseñar tu software.

### Author

Raul Bolivar Navas | https://linkedin.com/in/rasysbox | rasysbox@hotmail.com

### License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
