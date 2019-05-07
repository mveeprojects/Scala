# Alpakka producer/consumer

### How to run the relevant docker containers (Confluent Kafka and Zookeeper)

`cd docker`

`docker compose up -d`

### How to check that the producer has produced productively

Download the confluent platform (lots of useful binary files) from the link below
* https://www.confluent.io/product/confluent-platform/

`cd .../confluent-5.2.1/bin`

`./kafka-console-consumer --bootstrap-server localhost:9093 --topic test-topic --from-beginning`