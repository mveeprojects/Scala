# Couchbase Scala Example

## Set up local couchbase docker container (6.0.1)

* docker pull couchbase:6.0.1
* docker run -d -p8091:8091 -p11210:11210 --name=couchbasedb couchbase:6.0.1

Specified port 11210 directly as without this the application was logging that this port refused connection otherwise