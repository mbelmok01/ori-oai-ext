/**
 * Hal_WebServices_ReferentielsServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.ref_php;

public class Hal_WebServices_ReferentielsServiceLocator extends org.apache.axis.client.Service implements fr.archives_ouvertes.hal.ws.ref_php.Hal_WebServices_ReferentielsService {

    public Hal_WebServices_ReferentielsServiceLocator() {
    }


    public Hal_WebServices_ReferentielsServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Hal_WebServices_ReferentielsServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Hal_WebServices_ReferentielsPort
    private java.lang.String Hal_WebServices_ReferentielsPort_address = "http://paol.ccsd.cnrs.fr/ws/ref.php";

    public java.lang.String getHal_WebServices_ReferentielsPortAddress() {
        return Hal_WebServices_ReferentielsPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Hal_WebServices_ReferentielsPortWSDDServiceName = "Hal_WebServices_ReferentielsPort";

    public java.lang.String getHal_WebServices_ReferentielsPortWSDDServiceName() {
        return Hal_WebServices_ReferentielsPortWSDDServiceName;
    }

    public void setHal_WebServices_ReferentielsPortWSDDServiceName(java.lang.String name) {
        Hal_WebServices_ReferentielsPortWSDDServiceName = name;
    }

    public fr.archives_ouvertes.hal.ws.ref_php.Hal_WebServices_ReferentielsPort getHal_WebServices_ReferentielsPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Hal_WebServices_ReferentielsPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHal_WebServices_ReferentielsPort(endpoint);
    }

    public fr.archives_ouvertes.hal.ws.ref_php.Hal_WebServices_ReferentielsPort getHal_WebServices_ReferentielsPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            fr.archives_ouvertes.hal.ws.ref_php.Hal_WebServices_ReferentielsBindingStub _stub = new fr.archives_ouvertes.hal.ws.ref_php.Hal_WebServices_ReferentielsBindingStub(portAddress, this);
            _stub.setPortName(getHal_WebServices_ReferentielsPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHal_WebServices_ReferentielsPortEndpointAddress(java.lang.String address) {
        Hal_WebServices_ReferentielsPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (fr.archives_ouvertes.hal.ws.ref_php.Hal_WebServices_ReferentielsPort.class.isAssignableFrom(serviceEndpointInterface)) {
                fr.archives_ouvertes.hal.ws.ref_php.Hal_WebServices_ReferentielsBindingStub _stub = new fr.archives_ouvertes.hal.ws.ref_php.Hal_WebServices_ReferentielsBindingStub(new java.net.URL(Hal_WebServices_ReferentielsPort_address), this);
                _stub.setPortName(getHal_WebServices_ReferentielsPortWSDDServiceName());
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
        if ("Hal_WebServices_ReferentielsPort".equals(inputPortName)) {
            return getHal_WebServices_ReferentielsPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "Hal_WebServices_ReferentielsService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "Hal_WebServices_ReferentielsPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Hal_WebServices_ReferentielsPort".equals(portName)) {
            setHal_WebServices_ReferentielsPortEndpointAddress(address);
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
