package microservice.ictlab.iot.domain.sensor

import java.io.Serializable

enum class SensorDataEnum : Serializable {
    TEMP, DENSITY, PROXIMITY, LIGHT, PRESSURE
}