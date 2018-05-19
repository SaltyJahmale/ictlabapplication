package microservice.ictlab.iot.domain.node

import java.io.Serializable

enum class SensorNodeStatus : Serializable {
    OK, INTERMITTENT_FAILURE, DOWN
}