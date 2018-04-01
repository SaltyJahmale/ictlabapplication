package microservices.ictlab.reservation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
class ReservationApplication

fun main(args: Array<String>) {
    runApplication<ReservationApplication>(*args)
}
