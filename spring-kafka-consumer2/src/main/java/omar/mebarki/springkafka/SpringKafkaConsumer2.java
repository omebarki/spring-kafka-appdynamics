package omar.mebarki.springkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SpringKafkaConsumer2 {

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaConsumer2.class, args);
    }

}
