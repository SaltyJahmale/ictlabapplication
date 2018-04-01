package microservices.ictlab.authentication

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
class AuthenticationApplication

fun main(args: Array<String>) {
    runApplication<AuthenticationApplication>(*args)
}
