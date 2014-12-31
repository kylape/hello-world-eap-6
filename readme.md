#JAX-WS JBossWS-CXF "Hello World" Example

To build: 

    mvn clean install

Should only use artifcats found on maven central.

To deploy:

    cp endpoint/target/hello-world.war client-endpoint/target/hello-world-client.war $JBOSS_HOME/server/default/deploy

To test: 

    curl http://localhost:8080/hello-world-client/client
