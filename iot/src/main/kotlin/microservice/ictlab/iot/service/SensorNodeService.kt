package microservice.ictlab.iot.service

import microservice.ictlab.iot.domain.node.SensorNode
import microservice.ictlab.iot.repository.SensorNodeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class SensorNodeService {

    @Autowired
    lateinit var sensorNodeRepo: SensorNodeRepository

    fun createSensorNode(sensorNode: SensorNode): SensorNode {
        return sensorNodeRepo.save(sensorNode)
    }

    fun findById(name: String): Optional<SensorNode> {
        return sensorNodeRepo.findById(name)
    }

    fun findAll(): MutableIterable<SensorNode> {
        return sensorNodeRepo.findAll()
    }

    fun updateNode(sensorNode: SensorNode): SensorNode {
        return sensorNodeRepo.save(sensorNode)
    }
}