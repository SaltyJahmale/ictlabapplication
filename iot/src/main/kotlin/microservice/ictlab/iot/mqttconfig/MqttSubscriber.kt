package microservice.ictlab.iot.mqttconfig

import com.google.gson.Gson
import microservice.ictlab.iot.domain.node.SensorNode
import microservice.ictlab.iot.domain.sensor.SensorData
import microservice.ictlab.iot.service.SensorDataService
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttClient
import java.sql.Timestamp
import org.eclipse.paho.client.mqttv3.MqttException
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.util.*


@Component
class MqttSubscriber : MqttCallback {

    @Autowired
    lateinit var sensorDataService: SensorDataService

    @Value("192.168.99.100")
    private val host: String? = null

    @Value("1883")
    private val port: String? = null

    private val log = LoggerFactory.getLogger(this.javaClass)
    private var client: MqttClient? = null

    @Bean
    fun connect(): Boolean {
        try {
            client = MqttClient("tcp://${this.host}:${this.port}", UUID.randomUUID().toString(), MemoryPersistence())
            val mqttConnectOptions = MqttConnectOptions()
            mqttConnectOptions.isCleanSession = true
            client?.connect(mqttConnectOptions)
            client?.setCallback(this)
            log.info("==== Mqtt connected to ${this.host}:${this.port} ====")
        } catch (e: MqttException) {
            log.error("==== Mqtt exception ${e.message}  ====")
        }

        return client!!.isConnected
    }

    override fun connectionLost(throwable: Throwable) {
        log.error("Connection lost $throwable")
    }

    fun disconnect(sensorNode: SensorNode) {
        if(this.client!!.isConnected) {
            client?.disconnect()
        }
    }

    fun subscribe(topic: String) {
        if(!this.client!!.isConnected) {
            this.connect()
            log.info("==== Mqtt connecting first ====")
        } else {
            client?.subscribe(topic)
            log.info("==== Mqtt subscribed from $topic ====")
        }
    }

    fun unsubscribe(topic: String){
        if(!this.client!!.isConnected) {
            this.connect()
            log.info("==== Mqtt connecting first ====")
        } else {
            client?.unsubscribe(topic)
            log.info("==== Mqtt unsubscribe to $topic ====")

        }
    }

    /**
     *
     * @param topic is for debug
     * @param message is for debug purpose
     * @throws Exception
     */
    @Throws(Exception::class)
    override fun messageArrived(topic: String, message: MqttMessage) {
        // Called when a message arrives from the server that matches any subscription made by the client
        val time = Timestamp(System.currentTimeMillis()).toString()
        println("Time:\t $time   Topic:\t $topic Message:\t ${String(message.payload)} QoS:\t ${message.qos}")

        val gson = Gson()
        val data = gson.fromJson(String(message.payload), SensorData::class.java)
        this.sensorDataService.saveSensorData(data)
    }

    override fun deliveryComplete(iMqttDeliveryToken: IMqttDeliveryToken) {
        // blank for subscriber
    }

}