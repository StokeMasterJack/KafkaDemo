import java.time.Duration
import java.util.Properties
import org.apache.kafka.clients.CommonClientConfigs
import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.clients.consumer.KafkaConsumer


private const val EXCHANGE_NAME = "ramkoExchange"
private const val ROUTING_KEY = "routingKey"
private const val QUEUE_NAME = "queueName"


fun main(args: Array<String>) {
    val props = Properties()
    props.setProperty("bootstrap.servers", "192.168.0.193:9092")
    props.setProperty("group.id", "ramkoGroup")
    props.setProperty("enable.auto.commit", "true")
    props.setProperty("auto.commit.interval.ms", "1000")
    props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    val consumer: KafkaConsumer<String, String> = KafkaConsumer<String, String>(props)
    consumer.subscribe(listOf("ramkoTopic"))
    while (true) {
        val records: ConsumerRecords<String?, String?> = consumer.poll(Duration.ofMillis(100))
        for (record in records) {
            println("DaveMessage:")
//            System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value())
            println("   ${record.key()}: ${record.value()}]")
        }
    }

}