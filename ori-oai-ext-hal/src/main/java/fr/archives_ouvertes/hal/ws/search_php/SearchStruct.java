/**
 * SearchStruct.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.search_php;

public class SearchStruct  implements java.io.Serializable {
    private java.lang.String field;

    private java.lang.String searchType;

    private java.lang.String value;

    private java.lang.String join;

    public SearchStruct() {
    }

    public SearchStruct(
           java.lang.String field,
           java.lang.String searchType,
           java.lang.String value,
           java.lang.String join) {
           this.field = field;
           this.searchType = searchType;
           this.value = value;
           this.join = join;
    }


    /**
     * Gets the field value for this SearchStruct.
     * 
     * @return field
     */
    public java.lang.String getField() {
        return field;
    }


    /**
     * Sets the field value for this SearchStruct.
     * 
     * @param field
     */
    public void setField(java.lang.String field) {
        this.field = field;
    }


    /**
     * Gets the searchType value for this SearchStruct.
     * 
     * @return searchType
     */
    public java.lang.String getSearchType() {
        return searchType;
    }


    /**
     * Sets the searchType value for this SearchStruct.
     * 
     * @param searchType
     */
    public void setSearchType(java.lang.String searchType) {
        this.searchType = searchType;
    }


    /**
     * Gets the value value for this SearchStruct.
     * 
     * @return value
     */
    public java.lang.String getValue() {
        return value;
    }


    /**
     * Sets the value value for this SearchStruct.
     * 
     * @param value
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }


    /**
     * Gets the join value for this SearchStruct.
     * 
     * @return join
     */
    public java.lang.String getJoin() {
        return join;
    }


    /**
     * Sets the join value for this SearchStruct.
     * 
     * @param join
     */
    public void setJoin(java.lang.String join) {
        this.join = join;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchStruct)) return false;
        SearchStruct other = (SearchStruct) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.field==null && other.getField()==null) || 
             (this.field!=null &&
              this.field.equals(other.getField()))) &&
            ((this.searchType==null && other.getSearchType()==null) || 
             (this.searchType!=null &&
              this.searchType.equals(other.getSearchType()))) &&
            ((this.value==null && other.getValue()==null) || 
             (this.value!=null &&
              this.value.equals(other.getValue()))) &&
            ((this.join==null && other.getJoin()==null) || 
             (this.join!=null &&
              this.join.equals(other.getJoin())));
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
        if (getField() != null) {
            _hashCode += getField().hashCode();
        }
        if (getSearchType() != null) {
            _hashCode += getSearchType().hashCode();
        }
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        if (getJoin() != null) {
            _hashCode += getJoin().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchStruct.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "SearchStruct"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("field");
        elemField.setXmlName(new javax.xml.namespace.QName("", "field"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "searchType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("", "value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("join");
        elemField.setXmlName(new javax.xml.namespace.QName("", "join"));
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
