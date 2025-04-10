# Proxy Pattern

El patrón Proxy proporciona un objeto sustituto o representante de otro objeto para controlar el acceso al original. El proxy puede:

- Controlar el acceso (como un filtro de seguridad)
- Añadir funcionalidades extra (como logs, caching, etc.)
- Retrasar la carga de objetos pesados (lazy loading)

🧪 Ejemplo: 

Servicio que accede a datos externos, pero lo controlamos con un Proxy para evitar múltiples llamadas innecesarias (simulando cache/log).

### Author

Raul Bolivar Navas | https://linkedin.com/in/rasysbox | rasysbox@hotmail.com

### License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.