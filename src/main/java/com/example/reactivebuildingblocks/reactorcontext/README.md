## Reactor Context
A Sample to demo reactor context

#### How to run
From the root package
```
./gradlew clean bootRun
```
#### [Reactor Context](https://projectreactor.io/docs/core/release/api/reactor/util/context/Context.html)
For reactor context setup:
* ContextDemoFilter adds IP-Address and Location in the context based on the query param `id`
* ContextDemoService obtains the IP-Address and Location and logs them for audit.

To view them working run below curls:
```
curl http://localhost:8080/context\?id\=1
    output => IPAddress for Id=> 1.123.23.43
curl http://localhost:8080/context\?id\=100
    output => IPAddress for Id=> 100.123.23.43
curl http://localhost:8080/context\?id\=440
    output => IPAddress for Id=> 440.123.23.43
```
Logs should have below logs
```
Recived call from 1.123.23.43 and Location 1-Street
Recived call from 100.123.23.43 and Location 100-Street
Recived call from 440.123.23.43 and Location 440-Street
```