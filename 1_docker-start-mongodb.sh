#!/usr/bin/env bash
MDB_VERSION=7.0.8

start_mongodb() {
  port=$((27016+"${1}"))
  echo "Starting MongoDB container 'mongo${1}' on port ${port}"
  docker run --rm -d -p "${port}":27017 -h "$(hostname)" --name mongo"${1}" mongo:"${MDB_VERSION}" --replSet=RS
  sleep 5
  docker exec mongo"${1}" mongosh --quiet --eval "rs.initiate();"
}

for i in $(seq 2); do start_mongodb "${i}"; done
