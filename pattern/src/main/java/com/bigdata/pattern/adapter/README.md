# Adapter Pattern

El Patrón Adapter permite que dos clases con interfaces incompatibles trabajen juntas. Se utiliza para "adaptar" una clase existente a una nueva interfaz esperada, sin modificar su código original.

### Beneficios:

- Permite la reutilización de código existente.
- Facilita la integración de sistemas heterogéneos.
- Promueve la separación de preocupaciones (SRP).
- Reduce el acoplamiento entre clases.
- Facilita la evolución del sistema al permitir cambios en las interfaces sin afectar a las clases que las utilizan.
- Mejora la legibilidad y mantenibilidad del código al proporcionar una interfaz más clara y coherente.
- Permite la creación de adaptadores específicos para diferentes contextos, lo que facilita la adaptación de clases a múltiples interfaces.
- Facilita la implementación de patrones de diseño como el patrón Decorator, que permite agregar funcionalidades adicionales a un objeto sin modificar su estructura original.
- Facilita la creación de pruebas unitarias al permitir la creación de adaptadores simulados (mocks) que imitan el comportamiento de las clases originales.
- Facilita la implementación de patrones de diseño como el patrón Facade, que proporciona una interfaz simplificada para un conjunto de interfaces en un subsistema.

📘 Ejemplo: Adaptar un sistema de pagos

Supongamos que tienes un sistema de pagos que trabaja con una interfaz PaymentProcessor, pero quieres usar una API externa que no implementa esa interfaz. Usaremos el patrón Adapter para integrarla.

### Author

Raul Bolivar Navas | https://linkedin.com/in/rasysbox | rasysbox@hotmail.com

### License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
