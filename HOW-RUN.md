# How Start the Project

## 1. Docker

### 1.1. Build the Docker image

```txt
docker-compose up -d
```

### 1.2. Access the application

```txt
docker exec -it kafka bash
```

### 1.3. Produce messages to Kafka

```txt
kafka-console-producer --broker-list localhost:9092 --topic sensor-data
```
