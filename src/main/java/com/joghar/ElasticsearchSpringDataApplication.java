package com.joghar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElasticsearchSpringDataApplication{

    private static final Logger logger = LoggerFactory.getLogger(ElasticsearchSpringDataApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchSpringDataApplication.class, args);
        // use elastic search 6.8.3
    }
}
