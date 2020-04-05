package com.rocketmq.demo.controller;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;

public class RocketMQConsumer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQPushConsumer defaultMQPushConsumer = new DefaultMQPushConsumer("maple_consumer_group");
        // 它会从命名服务器上拿到broker的地址
        defaultMQPushConsumer.setNamesrvAddr("");
        defaultMQPushConsumer.setConsumeTimeout(30000);
        defaultMQPushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        // 第二个参数：正则表达式，标签
        defaultMQPushConsumer.subscribe("maple_topic", "*");
//        defaultMQPushConsumer.subscribe("maple_topic", "tag_b");

        defaultMQPushConsumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            System.out.println("Receive Message : " + msgs);
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS; // 签收
        });

        defaultMQPushConsumer.start();
    }
}
