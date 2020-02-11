package DefaultNamespace;

public class TriangleProxy implements DefaultNamespace.Triangle {
  private String _endpoint = null;
  private DefaultNamespace.Triangle triangle = null;
  
  public TriangleProxy() {
    _initTriangleProxy();
  }
  
  public TriangleProxy(String endpoint) {
    _endpoint = endpoint;
    _initTriangleProxy();
  }
  
  private void _initTriangleProxy() {
    try {
      triangle = (new DefaultNamespace.TriangleServiceLocator()).getTriangle();
      if (triangle != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)triangle)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)triangle)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (triangle != null)
      ((javax.xml.rpc.Stub)triangle)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public DefaultNamespace.Triangle getTriangle() {
    if (triangle == null)
      _initTriangleProxy();
    return triangle;
  }
  
  public java.lang.String getArea(double side1, double side2, double side3) throws java.rmi.RemoteException{
    if (triangle == null)
      _initTriangleProxy();
    return triangle.getArea(side1, side2, side3);
  }
  
  
}