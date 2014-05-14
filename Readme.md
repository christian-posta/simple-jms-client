## Simple JMS Client

This is a quickstart to get you connected up to an activemq broker.


You can run a standalone broker to test against, or you can run the client, or both.

To run the client:

    mvn -Pclient 
    
To turn on trace logging, for example, run with this command-line param:
    
    mvn -Pclient -DbrokerUrl=tcp://localhost:61616?trace=true
    
To run the broker:

    mvn -Pbroker