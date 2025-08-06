package kafka.Utils;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;
import java.time.Duration;
import java.util.*;
public class KafkaConsumerUtils {
    private static final String BOOTSTRAP_SERVERS = "localhost:9092";
    private static final String TOPIC = "my-topic";
    private static final String GROUP_ID = "test-consumer-group";

    public static List<String> consumeMessages(int timeoutSeconds) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList(TOPIC));

        List<String> messages = new ArrayList<>();
        long startTime = System.currentTimeMillis();

        while ((System.currentTimeMillis() - startTime) < timeoutSeconds * 1000) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(500));
            for (ConsumerRecord<String, String> record : records) {
                messages.add(record.value());
            }
        }

        consumer.close();
        return messages;
    }
}
