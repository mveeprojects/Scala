## Scala Kafka (and Zookeeper)

https://dzone.com/articles/hands-on-apache-kafka-with-scala

### Running Zookeeper and Kafka locally (requires docker compose)
* cd into .../Scala/src/main/scala/kafka/docker
* run 'docker-compose up -d'

### Download confluent tools to monitor Kafka
* https://www.confluent.io/download/
* ./kafka-console-consumer --bootstrap-server localhost:9093 --topic marks-topic --from-beginning