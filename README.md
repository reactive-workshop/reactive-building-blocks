reactive-building-blocks
==================

## Prerequsites
- colima/docker
- docker-compose

## Setup
- Clone the repo
- Start the docker container for mongo database using docker-compose `docker-compose up -d`
- Verify that the mongo container is up and exposing port 27017
```
➜  webflux-demos git:(master) ✗ docker ps -a
CONTAINER ID   IMAGE          COMMAND                  CREATED         STATUS         PORTS                                           NAMES
fbc8a04a8e02   mongo:latest   "docker-entrypoint.s…"   4 minutes ago   Up 4 minutes   0.0.0.0:27017->27017/tcp, :::27017->27017/tcp   mongo
```
- Run the application

  `./gradlew clean bootrun`
- Visit http://localhost:8080/events/all. It should be an array of 5 records.

- Lets fire a cURL to add another record in mongo db
```
curl --header "Content-Type: application/json" -X POST http://localhost:8080/events/add --data '{"id": 11, "content": "Hello World1"}'
```

- Refresh the above page, http://localhost:8080/events/all. There should be one more entry in the array the newly posted.

- Close this tab, and navigate to http://localhost:8080/events/stream. This should also same six entries in the array. Notice the ongoing loading button on the browser tab.
- Lets fire another cURL to add another record in mongo db
```
curl --header "Content-Type: application/json" -X POST http://localhost:8080/events/add --data '{"id": 12, "content": "Hello World2"}'
```
- Notice that the new entry is reflected on the browser already.
- Run the ReactiveUpdload main file which adds data in reactive manner and watch the values getting reflected on browser.
