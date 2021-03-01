package com.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaProducerExample {
    
    public static void main(String[] args) {
        
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(properties);

        for (int x = 0; x <= 100; x++) {

            ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(
                "youtube-v1", String.valueOf(x), "MESSAGE KE-"+x);

            System.out.println(producerRecord.topic()+" --> "+producerRecord.key()+" --> "+producerRecord.value());

            producer.send(producerRecord);

        }

        producer.close();

    }

}
