#JAX-WS JBossWS-CXF "Hello World" Example

Build and deploy: `mvn clean install; cd endpoint; mvn jboss-as:deploy`

Test: 

    cd client-endpoint
    mvn jboss-as:deploy
    curl http://localhost:8080/hello-world-client/client

Requires use of JBoss EAP 6 BOM (only available in 6.2+).

##ASYNC CONFIG

Use `wsconsume` to generate the async client interface:

    $JBOSS_HOME/bin/wsconsume.sh -b async_binding.xml -k -p com.redhat.gss.ws \
        'http://localhost:8080/hello-world/TestService?wsdl'

Where `async_binding.xml` is in the `client-endpoint` directory, and you need
to have the endpoint already deployed to get the WSDL.  This has already been
done in this example, but it's important you know how to generate the client
because it's quite difficult to get the interface correct by hand.

The aysnc test will invoke the endpoint and then wait on the `Future` object to
return with a response.  The endpoint has been modified to sleep for 10
seconds.
