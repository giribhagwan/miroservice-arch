# miroservice-arch

run kafka locally with docker-compose

```bash
    docker run -p 9092:9092 apache/kafka:4.1.0
    docker run --name learn_postgres -e POSTGRES_PASSWORD=pgsql -p 5433:5432 -d mydb
    docker run -d -p 9411:9411 openzipkin/zipkin