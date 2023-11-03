# MerchantSolutions - Signal Processing
Process a signal

Two ways to run as follows:

1) Run `TradingApplication.java` directly

    or

2) **Using Docker**

* Run ``` mvn clean package ```
* Run ``` docker-compose up ```

Swagger Link: http://localhost:8080/swagger-ui/index.html -- inprogress

API can be accessed via:

  **POST**: [/api/db/signal](http://localhost:8080/api/db/signal)

```
Body: 
{
"signal": 1,
"param1": 10,
"param2": 20
}
 ```

Also, it can be executed by importing this curl:

curl --location 'http://localhost:8080/api/db/signal' \
--data '{

"signal": 1,
"param1": 10,
"param2": 20
}'
