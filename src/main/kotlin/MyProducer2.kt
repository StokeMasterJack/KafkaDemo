import RamkoProducer.producer
import java.util.Properties
import java.util.concurrent.Future
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.RecordMetadata
import org.apache.kafka.common.serialization.StringSerializer

private const val EXCHANGE_NAME = "ramkoExchange"
private const val ROUTING_KEY = "routingKey"
private const val QUEUE_NAME = "queueName"

fun main(args: Array<String>) {

    println("starting kafka")
    val props = Properties()
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.193:9092")


    val future: Future<RecordMetadata> = producer.send(ProducerRecord("ramkoTopic", "Name", "Dave"))

    val metaData: RecordMetadata = future.get()
    println("Dave metaData: ${metaData}")


    producer.close()
}

object RamkoProducer {

    const val EmailTopic = "EmailTopic"
    private val props: Properties = Properties().apply {
        this[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = "192.168.0.193:9092"
    }

    val producer: Producer<String, String> = KafkaProducer(props, StringSerializer(), StringSerializer())

    fun sendEmail(){

    }

    fun close() {
        producer.close()
    }
}