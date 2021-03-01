package com.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.UUID;
import java.util.stream.Stream;

public class KafkaProducerFromCsv {

    private static String KafkaServer = "localhost:9092";
    private static String KafkaTopic = "youtube-v1";
    private static String CsvFile = "yt-trending.csv";

    private Producer<String, String> producer() {

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaServer);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        return new KafkaProducer<String, String>(properties);

    }

    public static void main(String[] args) throws URISyntaxException {

        KafkaProducerFromCsv kafkaProducerFromCsv = new KafkaProducerFromCsv();
        kafkaProducerFromCsv.publishMessages();

    }

    private void publishMessages() throws URISyntaxException {

        final Producer<String, String> csvProducer = producer();

        try {

            URI uri = getClass().getClassLoader().getResource(CsvFile).toURI();
            Stream<String> fStream = Files.lines(Paths.get(uri));
            fStream.forEach(line -> {
            	System.out.println(line);
            	
                final ProducerRecord<String, String> csvRecord = new ProducerRecord<String, String>(
                        KafkaTopic, UUID.randomUUID().toString(), line);

                csvProducer.send(csvRecord, (metadata, exception) -> {
                    if(metadata != null){
                        System.out.println("CsvData: "+ csvRecord.key()+" | Value : "+ csvRecord.value());
                    }
                    else{
                        System.out.println("Error Sending Csv Record -> "+ csvRecord.value());
                    }
                });
            });

            fStream.close();

        }
        
        catch (IOException e) {
            e.printStackTrace();
        }
        
        // finally {
        //     System.out.println("\nDone!\n");
        // }

    }

}