package omar.mebarki.springkafka.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class Consumer {
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);
    @Autowired
    KafkaTemplate kafkaTemplate;

    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(@Payload String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
        Message<String> messageK = MessageBuilder
                .withPayload(message)
                .setHeader(KafkaHeaders.TOPIC, "users2")
                .setHeader(KafkaHeaders.MESSAGE_KEY, "key" + UUID.randomUUID().toString())
                .build();
        kafkaTemplate.send(messageK);
    }
}
