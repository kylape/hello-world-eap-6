package com.redhat.gss.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.12.SP1-redhat-1
 * 2015-02-05T11:23:51.764-08:00
 * Generated source version: 2.7.12.SP1-redhat-1
 * 
 */
@WebServiceClient(name = "TestServiceService", 
                  wsdlLocation = "http://localhost:8080/hello-world/TestService?wsdl",
                  targetNamespace = "http://ws.gss.redhat.com/") 
public class TestServiceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://ws.gss.redhat.com/", "TestServiceService");
    public final static QName TestServicePort = new QName("http://ws.gss.redhat.com/", "TestServicePort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/hello-world/TestService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(TestServiceService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/hello-world/TestService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public TestServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TestServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TestServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public TestServiceService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public TestServiceService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public TestServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns HelloWorld
     */
    @WebEndpoint(name = "TestServicePort")
    public HelloWorld getTestServicePort() {
        return super.getPort(TestServicePort, HelloWorld.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HelloWorld
     */
    @WebEndpoint(name = "TestServicePort")
    public HelloWorld getTestServicePort(WebServiceFeature... features) {
        return super.getPort(TestServicePort, HelloWorld.class, features);
    }

}
