package microservice.ictlab.iot.mqttconfig

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttClient;
import microservice.ictlab.iot.domain.sensor.SensorData
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import microservice.ictlab.iot.repository.SensorDataRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.sql.Timestamp

@Component
class Subscriber : MqttCallback, InitializingBean {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    private val sensorDataRepository: SensorDataRepository? = null


    /**
     * set client to subscribe to the topic
     * @throws Exception
     */
    @Throws(Exception::class)
    override fun afterPropertiesSet() {
        val broker = "tcp://192.168.99.100:1883"   ;
        val clientId = MqttClient.generateClientId()
        val sampleClient = MqttClient(broker, clientId)
        sampleClient.connect()
        sampleClient.subscribe("topic")

    }

    override fun connectionLost(throwable: Throwable) {

    }

    /**
     *
     * @param topic is for debug
     * @param message is for debug purpose
     * @throws Exception
     */
    @Throws(Exception::class)
    override fun messageArrived(topic: String, message: MqttMessage) {
        // Called when a message arrives from the server that matches any
        // subscription made by the client
        val time = Timestamp(System.currentTimeMillis()).toString()
        println("Time:\t" + time + "  Topic:\t" + topic + "  Message:\t" + String(message.payload) + "  QoS:\t" + message.qos)

        val gson = Gson()
        val data = gson.fromJson(String(message.payload), SensorData::class.java)
        println(data.inputData)
//        sensorDataRepository!!.save(data)
        //        sensorDataRepository.deleteAll();
    }


    override fun deliveryComplete(iMqttDeliveryToken: IMqttDeliveryToken) {

    }
}