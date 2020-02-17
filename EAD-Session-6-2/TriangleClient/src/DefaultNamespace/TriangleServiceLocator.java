/**
 * TriangleServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public class TriangleServiceLocator extends org.apache.axis.client.Service implements DefaultNamespace.TriangleService {

    public TriangleServiceLocator() {
    }


    public TriangleServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TriangleServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Triangle
    private java.lang.String Triangle_address = "http://localhost:8080/Triangle/services/Triangle";

    public java.lang.String getTriangleAddress() {
        return Triangle_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TriangleWSDDServiceName = "Triangle";

    public java.lang.String getTriangleWSDDServiceName() {
        return TriangleWSDDServiceName;
    }

    public void setTriangleWSDDServiceName(java.lang.String name) {
        TriangleWSDDServiceName = name;
    }

    public DefaultNamespace.Triangle getTriangle() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Triangle_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTriangle(endpoint);
    }

    public DefaultNamespace.Triangle getTriangle(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            DefaultNamespace.TriangleSoapBindingStub _stub = new DefaultNamespace.TriangleSoapBindingStub(portAddress, this);
            _stub.setPortName(getTriangleWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTriangleEndpointAddress(java.lang.String address) {
        Triangle_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (DefaultNamespace.Triangle.class.isAssignableFrom(serviceEndpointInterface)) {
                DefaultNamespace.TriangleSoapBindingStub _stub = new DefaultNamespace.TriangleSoapBindingStub(new java.net.URL(Triangle_address), this);
                _stub.setPortName(getTriangleWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Triangle".equals(inputPortName)) {
            return getTriangle();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://DefaultNamespace", "TriangleService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://DefaultNamespace", "Triangle"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Triangle".equals(portName)) {
            setTriangleEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
