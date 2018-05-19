package microservice.ictlab.iot.domain.sensor

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class SensorInputData(@Id
                      @GeneratedValue(strategy = GenerationType.AUTO)
                      var id: String? = null,
                      var sensorData: SensorDataEnum? = null,
                      var sensorMeasurement: SensorMeasurementEnum? = null,
                      var inputData: Double = 0.toDouble(),
                      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                      @JsonSerialize
                      @JsonDeserialize
                      var localDateTime: LocalDateTime? = null)