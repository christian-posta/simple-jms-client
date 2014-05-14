package org.apache.activemq;

import org.apache.activemq.broker.BrokerService;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import java.util.concurrent.TimeUnit;

/**
 * Created by ceposta on 5/14/14.
 */
public class Broker {

    public static void main(String[] args) throws Exception {
        BrokerService brokerService = new BrokerService();
        brokerService.setDataDirectory("target/activemq-data");
        brokerService.addConnector("tcp://localhost:61616");
        brokerService.start();
        brokerService.waitUntilStarted();
    }
}
