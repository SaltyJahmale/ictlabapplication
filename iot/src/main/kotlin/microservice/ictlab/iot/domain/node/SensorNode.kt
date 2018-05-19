package microservice.ictlab.iot.domain.node

import microservice.ictlab.iot.domain.sensor.SensorDataEnum
import java.io.Serializable
import javax.persistence.*

@Entity
class SensorNode(@Id
                 @Column
                 val name: String,
                 @Column
                 val ip: String,
                 @Column
                 val port: String,
                 @Column(unique = true)
                 val topic: String,
                 @Enumerated(EnumType.STRING)
                 @Column
                 val sensorNodeStatus: SensorNodeStatus = SensorNodeStatus.OK,
                 @Enumerated(EnumType.STRING)
                 @Column
                 val sensorDataEnum: SensorDataEnum,
                 @Enumerated(EnumType.STRING)
                 @Column
                 val connectionStatus: ConnectionStatus = ConnectionStatus.DISCONNECTED) : Serializable