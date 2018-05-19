package microservice.ictlab.iot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.scheduling.annotation.EnableScheduling


@EnableEurekaClient
@SpringBootApplication
@EnableJpaRepositories
@EnableScheduling
@ComponentScan
class IotApplication

fun main(args: Array<String>) {
    runApplication<IotApplication>(*args)
}
