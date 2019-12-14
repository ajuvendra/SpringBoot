# SpringBoot
My SpringBoot learning

# Default Port Mappings
| Application Name | Port | 
| --------| -----|
| Limits Service | 8080, 8081, ... |
| Spring Cloud Config Server | 8888 |
| Currency Exchange Service | 8000, 8001, ... |
| Currency Conversion Service | 8100, 8101, ... |
| Netflix Eureka Naming Server | 8761 |
| Netflix Zuul API Gateway Server | 8765 |
| Zipkin Distributed Tracing Server | 9411 |

# URLs
| Application | URL |
| --------| -----|
| Limits Service | http://localhost:8080/limits POST: http://localhost:8080/application/referesh |
| Spring Cloud Config Server | http://localhost:8080/limits-service/default http://localhost:8080/limits-service/dev |
| Currency Converter Service - Direct Call | http://localhost:8080/currency-converter/from/EUR/to/INR/quantity/10000 |
| Currency Converter Service - Feign | http://localhost:8080/currency-converter-feign/from/EUR/to/INR/quantity/10000 |
| Currency Exchange Service | http://localhost:8080/currency-exchange/from/EUR/to/INR |
| Eureka | http://localhost:8761 |
| Zuul - Currency Exchange & Exchange Services | http://localhost:8765/currency-exchange-service/currency-exchange/from/EUR/to/INR |
| Zipkin | http://localhost:9411/zipkin |
| Spring Cloud Bus Refresh | http://localhost:8080/bus/referesh |