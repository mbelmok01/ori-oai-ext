/**
 * Hal_WebServices_SubmitServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.submit_php;

public class Hal_WebServices_SubmitServiceLocator extends org.apache.axis.client.Service implements fr.archives_ouvertes.hal.ws.submit_php.Hal_WebServices_SubmitService {

    public Hal_WebServices_SubmitServiceLocator() {
    }


    public Hal_WebServices_SubmitServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Hal_WebServices_SubmitServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Hal_WebServices_SubmitPort
    private java.lang.String Hal_WebServices_SubmitPort_address = "http://paol.ccsd.cnrs.fr/ws/submit.php";

    public java.lang.String getHal_WebServices_SubmitPortAddress() {
        return Hal_WebServices_SubmitPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Hal_WebServices_SubmitPortWSDDServiceName = "Hal_WebServices_SubmitPort";

    public java.lang.String getHal_WebServices_SubmitPortWSDDServiceName() {
        return Hal_WebServices_SubmitPortWSDDServiceName;
    }

    public void setHal_WebServices_SubmitPortWSDDServiceName(java.lang.String name) {
        Hal_WebServices_SubmitPortWSDDServiceName = name;
    }

    public fr.archives_ouvertes.hal.ws.submit_php.Hal_WebServices_SubmitPort getHal_WebServices_SubmitPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Hal_WebServices_SubmitPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHal_WebServices_SubmitPort(endpoint);
    }

    public fr.archives_ouvertes.hal.ws.submit_php.Hal_WebServices_SubmitPort getHal_WebServices_SubmitPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            fr.archives_ouvertes.hal.ws.submit_php.Hal_WebServices_SubmitBindingStub _stub = new fr.archives_ouvertes.hal.ws.submit_php.Hal_WebServices_SubmitBindingStub(portAddress, this);
            _stub.setPortName(getHal_WebServices_SubmitPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHal_WebServices_SubmitPortEndpointAddress(java.lang.String address) {
        Hal_WebServices_SubmitPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (fr.archives_ouvertes.hal.ws.submit_php.Hal_WebServices_SubmitPort.class.isAssignableFrom(serviceEndpointInterface)) {
                fr.archives_ouvertes.hal.ws.submit_php.Hal_WebServices_SubmitBindingStub _stub = new fr.archives_ouvertes.hal.ws.submit_php.Hal_WebServices_SubmitBindingStub(new java.net.URL(Hal_WebServices_SubmitPort_address), this);
                _stub.setPortName(getHal_WebServices_SubmitPortWSDDServiceName());
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
        if ("Hal_WebServices_SubmitPort".equals(inputPortName)) {
            return getHal_WebServices_SubmitPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "Hal_WebServices_SubmitService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "Hal_WebServices_SubmitPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Hal_WebServices_SubmitPort".equals(portName)) {
            setHal_WebServices_SubmitPortEndpointAddress(address);
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
