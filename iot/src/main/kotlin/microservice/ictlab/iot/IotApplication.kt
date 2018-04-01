package microservice.ictlab.iot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
class IotApplication

fun main(args: Array<String>) {
    runApplication<IotApplication>(*args)
}
