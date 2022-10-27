Event Streams
==================

- Make sure application is running.
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
