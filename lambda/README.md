# Lambda Patterns

Lambda Architecture Pattern es un patrón de diseño arquitectónico ideal para sistemas de procesamiento de grandes volúmenes de datos (Big Data), donde se necesita tanto baja latencia como alta precisión.
Es un patrón que combina procesamiento batch y procesamiento en tiempo real (streaming) para ofrecer:

### Escalabilidad

- Tolerancia a fallos
- Procesamiento robusto y rápido

### Componentes principales
Lambda Architecture tiene 3 capas:

- Batch Layer
  - Procesa grandes volúmenes de datos acumulados.
  - Es precisa, pero tiene mayor latencia.
  - Genera vistas preprocesadas (batch views).
  - Ej: Hadoop, Apache Spark.


- Speed Layer (Real-time)
  - Procesa datos en tiempo real con menor precisión.
  - Proporciona resultados inmediatos.
  - Ej: Apache Storm, Apache Kafka Streams, Flink.


- Serving Layer
  - Expone datos combinados de la capa batch y real-time.
  - Consulta los resultados.
  - Ej: Cassandra, Elasticsearch, Druid.


### Flujo General

```text
         +-----------------+
         |     Client      |
         +--------+--------+
                  |
                  v
         +--------+--------+
         |     Ingestion    |
         |   (Kafka, etc)   |
         +--------+--------+
                  |
        +---------+----------+
        |                    |
        v                    v
+---------------+   +----------------+
|   Batch Layer |   |  Speed Layer   |
| (Spark/Hadoop)|   | (Flink/Storm)  |
+-------+-------+   +--------+-------+
        \                   /
         v                 v
      +-----------------------+
      |     Serving Layer     |
      | (Elasticsearch, etc.) |
      +-----------+-----------+
                  |
                  v
         +--------+--------+
         |     Dashboard    |
         +------------------+
```

### Ejemplo concreto

🛠 Caso: Sistema de monitoreo de temperatura IoT

- Batch Layer: Procesa logs históricos cada hora usando Apache Spark para calcular promedios por zona.
- Speed Layer: Detecta picos de temperatura en tiempo real con Apache Kafka + Flink.
- Serving Layer: Usa Cassandra para consultar el histórico y alertas recientes.

🧪 Stack típico en Java/Spring Boot

```text
Componente	Tecnología sugerida
Ingestión	Apache Kafka
Batch	        Apache Spark (Java API)
Speed	        Kafka Streams / Flink
Serving	        Cassandra / Elasticsearch
API	        Spring Boot REST API
```

🧱 Arquitectura Lambda Simplificada con Spring Boot

🔧 Tecnologías:

- Apache Kafka → Ingesta y stream layer.
- Spring Boot → Controladores, servicios y procesamiento.
- Spring Kafka → Consumo en tiempo real (Speed Layer).
- Scheduler con Spring → Batch layer simulado.
- Elasticsearch o PostgreSQL → Serving layer.
- Actuator o Swagger UI → Consultas al sistema.


```text
lambda-springboot/
├── src/main/java/com/example/lambda/
│   ├── controller/          # API de consulta
│   ├── service/
│   │   ├── StreamProcessorService.java
│   │   └── BatchProcessorService.java
│   ├── kafka/               # Listeners Kafka
│   ├── model/
│   ├── repository/
│   └── LambdaApplication.java
├── resources/
│   ├── application.yml
│   └── logback.xml
```
