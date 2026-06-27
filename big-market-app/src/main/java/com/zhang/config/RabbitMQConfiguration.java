package com.zhang.config;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;

/**
 * @Author: ZhangJunjie
 * @Description: 配置RabbitMQ实现多线程处理接收消息
 * @DateTime: 2026/6/23 15:01
 **/
//@Configuration
public class RabbitMQConfiguration {

    private static final int INITIAL_CONCURRENT_CONSUMERS = 10;
    private static final int MAX_CONCURRENT_CONSUMERS = 10;

    @Bean("customContainerFactory")
    public SimpleRabbitListenerContainerFactory containerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer,
                                                                 ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConcurrentConsumers(INITIAL_CONCURRENT_CONSUMERS);
        factory.setMaxConcurrentConsumers(MAX_CONCURRENT_CONSUMERS);
        configurer.configure(factory, connectionFactory);
        return factory;

    }
}
