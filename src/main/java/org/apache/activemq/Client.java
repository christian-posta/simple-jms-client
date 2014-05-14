package org.apache.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import javax.jms.Message;
import java.util.concurrent.TimeUnit;

/**
 * Created by ceposta on 5/14/14.
 */
public class Client {

    private static String brokerUrl = System.getProperty("brokerUrl", "tcp://localhost:61616");
    private static String destinationName = System.getProperty("queueName", "FOO.QUEUE");

    private static final Logger LOG = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) throws Exception {
        ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory(getBrokerUrl());


        Connection connection = cf.createConnection();
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        Destination dest = session.createQueue(destinationName);
        MessageConsumer consumer = session.createConsumer(dest);

        Message msg = consumer.receive(TimeUnit.SECONDS.toMillis(10));

        if (msg != null) {
            LOG.info("WooHoo got a message!");
        }else {
            LOG.info(":( boo... no message");
        }

        consumer.close();
        connection.close();
    }

    public static String getBrokerUrl() {
        return brokerUrl;
    }
}
