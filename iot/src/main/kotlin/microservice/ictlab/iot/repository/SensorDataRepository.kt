package microservice.ictlab.iot.repository

import microservice.ictlab.iot.domain.sensor.SensorData
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SensorDataRepository: JpaRepository<SensorData, Long>
