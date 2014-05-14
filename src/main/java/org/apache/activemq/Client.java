package org.apache.activemq;

import javax.jms.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by ceposta on 5/14/14.
 */
public class Client {

    public static void main(String[] args) throws Exception{
        ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616?trace=true");

//        cf.getPrefetchPolicy().setQueuePrefetch(1);

        Connection connection = cf.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination dest = session.createQueue("FOO.QUEUE");
        MessageConsumer consumer = session.createConsumer(dest);

        TimeUnit.SECONDS.sleep(10);

        consumer.close();
        connection.close();
    }
}
