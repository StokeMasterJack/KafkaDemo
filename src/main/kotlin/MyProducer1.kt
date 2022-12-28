import java.util.Properties
import java.util.concurrent.Future
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.RecordMetadata

private const val EXCHANGE_NAME = "ramkoExchange"
private const val ROUTING_KEY = "routingKey"
private const val QUEUE_NAME = "queueName"

fun main(args: Array<String>) {
    println("starting kafka")
    val props = Properties()
    props.put("bootstrap.servers", "192.168.0.193:9092")
    props.put("compression.type","none")
    props.put("linger.ms", 1);
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

    val producer: Producer<String, String> = KafkaProducer(props)
    val future: Future<RecordMetadata> = producer.send(ProducerRecord<String, String>("ramkoTopic", "Name", "Dave"))

    val metaData:RecordMetadata = future.get()
    println("Dave metaData: ${metaData}")


    producer.close()
}