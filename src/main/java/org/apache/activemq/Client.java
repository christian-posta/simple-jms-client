package org.apache.activemq;

import javax.jms.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by ceposta on 5/14/14.
 */
public class Client {

    private static String brokerUrl = System.getProperty("brokerUrl", "tcp://localhost:61616");

    public static void main(String[] args) throws Exception {
        ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory(getBrokerUrl());


        Connection connection = cf.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination dest = session.createQueue("FOO.QUEUE");
        MessageConsumer consumer = session.createConsumer(dest);

        TimeUnit.SECONDS.sleep(10);

        consumer.close();
        connection.close();
    }

    public static String getBrokerUrl() {
        return brokerUrl;
    }
}
