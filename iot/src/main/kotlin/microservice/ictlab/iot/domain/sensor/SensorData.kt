package microservice.ictlab.iot.domain.sensor

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class SensorData(@Id
                 @GeneratedValue(strategy = GenerationType.AUTO)
                 val id: Long? = null,
                 val name: String? = null,
                 val sensorLocation: String? = null,
                 @OneToMany(targetEntity = SensorInputData::class)
                 val inputData: List<SensorInputData>? = null,
                 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                 @JsonSerialize(using = LocalDateTimeSerializer::class)
                 @JsonDeserialize(using = LocalDateTimeDeserializer::class)
                 val localDateTime: LocalDateTime? = null) : Serializable