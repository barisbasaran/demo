package com.baris.demo.kafka;

import lombok.AllArgsConstructor;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class WordCountProcessor {

    private static final Serde<String> STRING_SERDE = Serdes.String();

    private final StreamsBuilderFactoryBean streamsBuilderFactoryBean;

    @Autowired
    void buildPipeline(StreamsBuilder streamsBuilder) {
        streamsBuilder
            .stream("input-topic", Consumed.with(STRING_SERDE, STRING_SERDE))
            .flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+")))
            .groupBy((key, value) -> value, Grouped.with(STRING_SERDE, STRING_SERDE))
            .count(Materialized.as("counts"))
            .toStream()
            .to("output-topic");
    }

    public Long getWordCount(String word) {
        return (Long) streamsBuilderFactoryBean
            .getKafkaStreams()
            .store(StoreQueryParameters.fromNameAndType("counts", QueryableStoreTypes.keyValueStore()))
            .get(word);
    }
}
