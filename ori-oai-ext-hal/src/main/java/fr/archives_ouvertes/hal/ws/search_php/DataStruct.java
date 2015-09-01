/**
 * DataStruct.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.search_php;

public class DataStruct  implements java.io.Serializable {
    private java.lang.String metaName;

    private java.lang.String metaCode;

    private java.lang.String metaValue;

    public DataStruct() {
    }

    public DataStruct(
           java.lang.String metaName,
           java.lang.String metaCode,
           java.lang.String metaValue) {
           this.metaName = metaName;
           this.metaCode = metaCode;
           this.metaValue = metaValue;
    }


    /**
     * Gets the metaName value for this DataStruct.
     * 
     * @return metaName
     */
    public java.lang.String getMetaName() {
        return metaName;
    }


    /**
     * Sets the metaName value for this DataStruct.
     * 
     * @param metaName
     */
    public void setMetaName(java.lang.String metaName) {
        this.metaName = metaName;
    }


    /**
     * Gets the metaCode value for this DataStruct.
     * 
     * @return metaCode
     */
    public java.lang.String getMetaCode() {
        return metaCode;
    }


    /**
     * Sets the metaCode value for this DataStruct.
     * 
     * @param metaCode
     */
    public void setMetaCode(java.lang.String metaCode) {
        this.metaCode = metaCode;
    }


    /**
     * Gets the metaValue value for this DataStruct.
     * 
     * @return metaValue
     */
    public java.lang.String getMetaValue() {
        return metaValue;
    }


    /**
     * Sets the metaValue value for this DataStruct.
     * 
     * @param metaValue
     */
    public void setMetaValue(java.lang.String metaValue) {
        this.metaValue = metaValue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataStruct)) return false;
        DataStruct other = (DataStruct) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.metaName==null && other.getMetaName()==null) || 
             (this.metaName!=null &&
              this.metaName.equals(other.getMetaName()))) &&
            ((this.metaCode==null && other.getMetaCode()==null) || 
             (this.metaCode!=null &&
              this.metaCode.equals(other.getMetaCode()))) &&
            ((this.metaValue==null && other.getMetaValue()==null) || 
             (this.metaValue!=null &&
              this.metaValue.equals(other.getMetaValue())));
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
        if (getMetaName() != null) {
            _hashCode += getMetaName().hashCode();
        }
        if (getMetaCode() != null) {
            _hashCode += getMetaCode().hashCode();
        }
        if (getMetaValue() != null) {
            _hashCode += getMetaValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DataStruct.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "DataStruct"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metaName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metaName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metaCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metaCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metaValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metaValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
