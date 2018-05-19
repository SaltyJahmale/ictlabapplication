package microservice.ictlab.iot.resource

import microservice.ictlab.iot.service.SensorNodeService
import microservice.ictlab.iot.domain.node.SensorNode
import microservice.ictlab.iot.mqttconfig.MqttSubscriber
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping(value = ["/mqtt"])
class SensorNodeResource {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    lateinit var sub: MqttSubscriber

    @Autowired
    lateinit var sensorNodeService: SensorNodeService

    @RequestMapping("/node", method = [RequestMethod.POST])
    fun createNodeAndSubscribe(@RequestBody sensorNode: SensorNode) {
        try {
            sensorNodeService.createSensorNode(sensorNode)
        } catch (e: Exception) {
            log.error(e.message)
        }
    }

    @RequestMapping("/subscribe", method = [RequestMethod.PUT])
    fun subscribeToTopic(@RequestBody sensorNode: SensorNode) {
        try {
            sub.subscribe(sensorNode.topic)
            sensorNodeService.updateNode(sensorNode)
        } catch (e: Exception) {
            log.error(e.message)
        }
    }

    @RequestMapping("/unsubscribe", method = [RequestMethod.PUT])
    fun unsubscribeFromTopic(@RequestBody sensorNode: SensorNode) {
        try {
            sub.unsubscribe(sensorNode.topic)
            sensorNodeService.updateNode(sensorNode)
        } catch (e: Exception) {
            log.error(e.message)
        }
    }

    @RequestMapping("/node", method = [RequestMethod.GET])
    fun getNodeById(@RequestHeader name: String): Optional<SensorNode> {
        return sensorNodeService.findById(name)
    }

    @RequestMapping("/nodes", method = [RequestMethod.GET])
    fun getAllNodes(): MutableIterable<SensorNode> {
        return sensorNodeService.findAll()
    }

}