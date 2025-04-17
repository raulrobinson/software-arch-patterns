# Software Architectural Patterns

Software architectural patterns are general reusable solutions to commonly occurring problems in software architecture within a given context. 
They are not finished designs but templates that can be applied to solve a particular problem in a specific context. 

### Principio SOLID

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

Based in the Concept of Clean Architecture, the software architectural patterns are a set of best practices and guidelines that help developers design and structure their software systems in a way that is maintainable, scalable, and adaptable to change.

Here are some **(56)** most common software architectural patterns:

1. **Singleton Pattern**: This pattern restricts the instantiation of a class to one single instance. It is used when exactly one object is needed to coordinate actions across the system.


3. **Factory Pattern**: This pattern defines an interface for creating an object but allows subclasses to alter the type of objects that will be created. It is used when a class cannot anticipate the class of objects it must create.


4. **Observer Pattern**: This pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. It is used when an object needs to notify other objects without making assumptions about who those objects are.


5. **Strategy Pattern**: This pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. It lets the algorithm vary independently from clients that use it. It is used when you want to define a set of algorithms, encapsulate each one, and make them interchangeable.


6. **Decorator Pattern**: This pattern allows behavior to be added to individual objects, either statically or dynamically, without affecting the behavior of other objects from the same class. It is used when you want to add responsibilities to individual objects dynamically and transparently, without affecting other objects.


7. **Adapter Pattern**: This pattern allows incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces. It is used when you want to use an existing class but its interface does not match the one you need.


8. **Facade Pattern**: This pattern provides a simplified interface to a complex subsystem. It defines a higher-level interface that makes the subsystem easier to use. It is used when you want to provide a simple interface to a complex system.


9. **Command Pattern**: This pattern encapsulates a request as an object, thereby allowing for parameterization of clients with queues, requests, and operations. It is used when you want to parameterize objects with operations.


10. **Proxy Pattern**: This pattern provides a surrogate or placeholder for another object to control access to it. It is used when you want to control access to an object, such as lazy initialization, access control, logging, etc.


11. **Template Method Pattern**: This pattern defines the skeleton of an algorithm in a method, deferring some steps to subclasses. It lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure. It is used when you want to define the skeleton of an algorithm in a method, deferring some steps to subclasses.


12. **Builder Pattern**: This pattern separates the construction of a complex object from its representation so that the same construction process can create different representations. It is used when you want to construct a complex object step by step.


13. **Composite Pattern**: This pattern composes objects into tree structures to represent part-whole hierarchies. It lets clients treat individual objects and compositions uniformly. It is used when you want to represent part-whole hierarchies of objects.


14. **State Pattern**: This pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class. It is used when you want to allow an object to change its behavior when its internal state changes.


15. **Mediator Pattern**: This pattern defines an object that encapsulates how a set of objects interact. It promotes loose coupling by keeping objects from referring to each other explicitly, and it lets you vary their interaction independently. It is used when you want to define an object that encapsulates how a set of objects interact.


16. **Chain of Responsibility Pattern**: This pattern passes a request along a chain of handlers. Each handler decides either to process the request or to pass it to the next handler in the chain. It is used when you want to pass a request along a chain of handlers.


17. **Visitor Pattern**: This pattern represents an operation to be performed on the elements of an object structure. It lets you define a new operation without changing the classes of the elements on which it operates. It is used when you want to define a new operation without changing the classes of the elements on which it operates.


18. **Bridge Pattern**: This pattern separates an object’s interface from its implementation so that the two can vary independently. It is used when you want to decouple an abstraction from its implementation so that the two can vary independently.


19. **Flyweight Pattern**: This pattern uses sharing to support large numbers of fine-grained objects efficiently. It is used when you want to minimize memory usage by sharing common parts of state between multiple objects.


20. **Prototype Pattern**: This pattern creates new objects by copying an existing object, known as the prototype. It is used when the cost of creating a new instance of an object is more expensive than copying an existing instance.


21. **Memento Pattern**: This pattern captures and externalizes an object’s internal state without violating encapsulation, allowing the object to be restored to this state later. It is used when you want to capture and externalize an object’s internal state without violating encapsulation.


22. **Interpreter Pattern**: This pattern defines a representation for a grammar and an interpreter that uses the representation to interpret sentences in the language. It is used when you want to define a grammar for a language and provide an interpreter for it.


23. **Data Access Object (DAO) Pattern**: This pattern provides an abstract interface to some type of database or other persistence mechanism. It is used when you want to separate the data access logic from the business logic.


24. **Repository Pattern**: This pattern mediates between the domain and data mapping layers, acting like an in-memory domain object collection. It is used when you want to separate the logic that retrieves data from the underlying storage system.


25. **Service Layer Pattern**: This pattern defines an application's boundary with a layer of services that establishes a set of available operations. It is used when you want to define a service layer that encapsulates the business logic of the application.


26. **Microservices Pattern**: This pattern structures an application as a collection of loosely coupled services, which implement business capabilities. It is used when you want to build a distributed system that can be developed, deployed, and scaled independently.


27. **Event-Driven Architecture Pattern**: This pattern uses events to trigger and communicate between decoupled services. It is used when you want to build a system that reacts to events and can scale independently.


28. **Serverless Architecture Pattern**: This pattern allows developers to build and run applications without managing servers. It is used when you want to build applications that can scale automatically and only pay for the resources you use.


29. **CQRS (Command Query Responsibility Segregation) Pattern**: This pattern separates the read and write operations of a data store. It is used when you want to optimize the performance, scalability, and security of your application by separating the read and write operations.


30. **Event Sourcing Pattern**: This pattern stores the state of a system as a sequence of events. It is used when you want to capture all changes to an application state as a sequence of events.


31. **Saga Pattern**: This pattern manages distributed transactions by coordinating a series of local transactions. It is used when you want to manage long-running transactions in a distributed system.


32. **Circuit Breaker Pattern**: This pattern prevents an application from repeatedly trying to execute an operation that is likely to fail. It is used when you want to prevent an application from making repeated requests to a service that is likely to fail.


33. **Bulkhead Pattern**: This pattern isolates different parts of a system to prevent a failure in one part from cascading to other parts. It is used when you want to prevent a failure in one part of a system from affecting other parts.


34. **Throttling Pattern**: This pattern limits the number of requests that can be made to a service in a given time period. It is used when you want to prevent a service from being overwhelmed by too many requests.


35. **Rate Limiting Pattern**: This pattern controls the rate at which requests are processed. It is used when you want to limit the number of requests that can be made to a service in a given time period.


36. **API Gateway Pattern**: This pattern provides a single entry point for all clients to access the services in a microservices architecture. It is used when you want to provide a single entry point for all clients to access the services in a microservices architecture.


37. **Service Discovery Pattern**: This pattern allows services to find and communicate with each other without hardcoding the address of the service. It is used when you want to enable services to discover and communicate with each other dynamically.


38. **Load Balancing Pattern**: This pattern distributes incoming network traffic across multiple servers. It is used when you want to ensure that no single server becomes overwhelmed with too much traffic.


39. **Content Delivery Network (CDN) Pattern**: This pattern uses a network of servers to deliver content to users based on their geographic location. It is used when you want to improve the performance and availability of your application by delivering content from a server that is geographically closer to the user.


40. **Data Lake Pattern**: This pattern stores large amounts of structured and unstructured data in its raw form. It is used when you want to store large amounts of data in its raw form for future analysis.


41. **Data Warehouse Pattern**: This pattern stores structured data from multiple sources in a single repository for analysis and reporting. It is used when you want to store structured data from multiple sources in a single repository for analysis and reporting.


42. **ETL (Extract, Transform, Load) Pattern**: This pattern extracts data from multiple sources, transforms it into a suitable format, and loads it into a target system. It is used when you want to extract data from multiple sources, transform it into a suitable format, and load it into a target system.


43. **Lambda Architecture Pattern**: This pattern combines batch and real-time processing to provide a comprehensive view of data. It is used when you want to combine batch and real-time processing to provide a comprehensive view of data.


44. **Kappa Architecture Pattern**: This pattern simplifies the Lambda architecture by using a single stream processing engine for both batch and real-time processing. It is used when you want to simplify the Lambda architecture by using a single stream processing engine for both batch and real-time processing.


45. **Data Mesh Pattern**: This pattern decentralizes data ownership and architecture to enable teams to own and manage their data as a product. It is used when you want to decentralize data ownership and architecture to enable teams to own and manage their data as a product.


46. **Data Fabric Pattern**: This pattern provides a unified architecture for managing data across multiple environments. It is used when you want to provide a unified architecture for managing data across multiple environments.


47. **DataOps Pattern**: This pattern applies DevOps principles to data management to improve collaboration and automation. It is used when you want to apply DevOps principles to data management to improve collaboration and automation.


48. **MLOps Pattern**: This pattern applies DevOps principles to machine learning to improve collaboration and automation. It is used when you want to apply DevOps principles to machine learning to improve collaboration and automation.


49. **AIOps Pattern**: This pattern applies artificial intelligence to IT operations to improve collaboration and automation. It is used when you want to apply artificial intelligence to IT operations to improve collaboration and automation.


50. **DevSecOps Pattern**: This pattern integrates security practices into DevOps processes. It is used when you want to integrate security practices into DevOps processes to ensure that security is considered at every stage of the development lifecycle.


51. **GitOps Pattern**: This pattern uses Git as a single source of truth for declarative infrastructure and applications. It is used when you want to use Git as a single source of truth for declarative infrastructure and applications.


52. **Infrastructure as Code (IaC) Pattern**: This pattern manages infrastructure through code and automation. It is used when you want to manage infrastructure through code and automation.


53. **Configuration as Code Pattern**: This pattern manages configuration through code and automation. It is used when you want to manage configuration through code and automation.


54. **Secrets Management Pattern**: This pattern manages sensitive information such as passwords and API keys. It is used when you want to manage sensitive information such as passwords and API keys securely.


55. **Continuous Integration (CI) Pattern**: This pattern automates the process of integrating code changes into a shared repository. It is used when you want to automate the process of integrating code changes into a shared repository.


56. **Continuous Delivery (CD) Pattern**: This pattern automates the process of delivering code changes to production. It is used when you want to automate the process of delivering code changes to production.

### Author

Raul Bolivar Navas | https://linkedin.com/in/rasysbox | rasysbox@hotmail.com

### License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.