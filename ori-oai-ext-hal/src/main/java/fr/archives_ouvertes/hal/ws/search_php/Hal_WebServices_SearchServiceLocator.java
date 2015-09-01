/**
 * Hal_WebServices_SearchServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.search_php;

public class Hal_WebServices_SearchServiceLocator extends org.apache.axis.client.Service implements fr.archives_ouvertes.hal.ws.search_php.Hal_WebServices_SearchService {

    public Hal_WebServices_SearchServiceLocator() {
    }


    public Hal_WebServices_SearchServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Hal_WebServices_SearchServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Hal_WebServices_SearchPort
    private java.lang.String Hal_WebServices_SearchPort_address = "http://paol.ccsd.cnrs.fr/ws/search.php";

    public java.lang.String getHal_WebServices_SearchPortAddress() {
        return Hal_WebServices_SearchPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Hal_WebServices_SearchPortWSDDServiceName = "Hal_WebServices_SearchPort";

    public java.lang.String getHal_WebServices_SearchPortWSDDServiceName() {
        return Hal_WebServices_SearchPortWSDDServiceName;
    }

    public void setHal_WebServices_SearchPortWSDDServiceName(java.lang.String name) {
        Hal_WebServices_SearchPortWSDDServiceName = name;
    }

    public fr.archives_ouvertes.hal.ws.search_php.Hal_WebServices_SearchPort getHal_WebServices_SearchPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Hal_WebServices_SearchPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHal_WebServices_SearchPort(endpoint);
    }

    public fr.archives_ouvertes.hal.ws.search_php.Hal_WebServices_SearchPort getHal_WebServices_SearchPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            fr.archives_ouvertes.hal.ws.search_php.Hal_WebServices_SearchBindingStub _stub = new fr.archives_ouvertes.hal.ws.search_php.Hal_WebServices_SearchBindingStub(portAddress, this);
            _stub.setPortName(getHal_WebServices_SearchPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHal_WebServices_SearchPortEndpointAddress(java.lang.String address) {
        Hal_WebServices_SearchPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (fr.archives_ouvertes.hal.ws.search_php.Hal_WebServices_SearchPort.class.isAssignableFrom(serviceEndpointInterface)) {
                fr.archives_ouvertes.hal.ws.search_php.Hal_WebServices_SearchBindingStub _stub = new fr.archives_ouvertes.hal.ws.search_php.Hal_WebServices_SearchBindingStub(new java.net.URL(Hal_WebServices_SearchPort_address), this);
                _stub.setPortName(getHal_WebServices_SearchPortWSDDServiceName());
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
        if ("Hal_WebServices_SearchPort".equals(inputPortName)) {
            return getHal_WebServices_SearchPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "Hal_WebServices_SearchService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "Hal_WebServices_SearchPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Hal_WebServices_SearchPort".equals(portName)) {
            setHal_WebServices_SearchPortEndpointAddress(address);
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
