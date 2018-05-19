package microservice.ictlab.iot.service

import microservice.ictlab.iot.domain.sensor.SensorData
import microservice.ictlab.iot.repository.SensorDataRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class SensorDataService {

    @Autowired
    lateinit var sensorDataRepository: SensorDataRepository

    fun saveSensorData(sensorData: SensorData): SensorData {
        return sensorDataRepository.save(sensorData)
    }

    fun findById(id: Long): Optional<SensorData> {
        return sensorDataRepository.findById(id)
    }

    fun findAll(): MutableIterable<SensorData> {
        return sensorDataRepository.findAll()
    }

    fun updateNode(sensorData: SensorData): SensorData {
        return sensorDataRepository.save(sensorData)
    }
}