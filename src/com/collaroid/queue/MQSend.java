package com.collaroid.queue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;


/**
 * Created by MacBookAir on 4/9/15.
 */
public class MQSend {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("172.16.23.102");
        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello World !";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("message send~~~");

            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
