/**
 * TriangleService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public interface TriangleService extends javax.xml.rpc.Service {
    public java.lang.String getTriangleAddress();

    public DefaultNamespace.Triangle getTriangle() throws javax.xml.rpc.ServiceException;

    public DefaultNamespace.Triangle getTriangle(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
