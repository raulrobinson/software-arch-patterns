# Template Pattern

Template Method define el esqueleto de un algoritmo en una clase base, permitiendo que las subclases redefinan ciertos pasos sin cambiar la estructura general del algoritmo.

### Ideal para:

- Reutilizar lógica común.
- Permitir personalización de ciertos pasos en subclases.
- Cumplir el principio de inversión de control.

***Ejemplo:*** Sistema que genera distintos tipos de notificaciones (correo, SMS), pero con una lógica base común.

Llamadas:

```txt
GET http://localhost:8080/api/template/email?to=alice@mail.com&msg=Hola
GET http://localhost:8080/api/template/sms?to=123456789&msg=Hola
```

Resultado:

```txt
📧 Validando dirección de correo: alice@mail.com
📧 Preparando contenido HTML: Hola
📧 Enviando correo a alice@mail.com con mensaje: Hola
✅ Notificación enviada a alice@mail.com
```
