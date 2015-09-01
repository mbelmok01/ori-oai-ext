/**
 * SetCounterStruct.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.search_php;

public class SetCounterStruct  implements java.io.Serializable {
    private int fulltext;

    private int notice;

    public SetCounterStruct() {
    }

    public SetCounterStruct(
           int fulltext,
           int notice) {
           this.fulltext = fulltext;
           this.notice = notice;
    }


    /**
     * Gets the fulltext value for this SetCounterStruct.
     * 
     * @return fulltext
     */
    public int getFulltext() {
        return fulltext;
    }


    /**
     * Sets the fulltext value for this SetCounterStruct.
     * 
     * @param fulltext
     */
    public void setFulltext(int fulltext) {
        this.fulltext = fulltext;
    }


    /**
     * Gets the notice value for this SetCounterStruct.
     * 
     * @return notice
     */
    public int getNotice() {
        return notice;
    }


    /**
     * Sets the notice value for this SetCounterStruct.
     * 
     * @param notice
     */
    public void setNotice(int notice) {
        this.notice = notice;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SetCounterStruct)) return false;
        SetCounterStruct other = (SetCounterStruct) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.fulltext == other.getFulltext() &&
            this.notice == other.getNotice();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getFulltext();
        _hashCode += getNotice();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SetCounterStruct.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "SetCounterStruct"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fulltext");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fulltext"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "notice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
