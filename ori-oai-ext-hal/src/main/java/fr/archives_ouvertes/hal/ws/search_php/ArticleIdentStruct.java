/**
 * ArticleIdentStruct.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.search_php;

public class ArticleIdentStruct  implements java.io.Serializable {
    private java.lang.String identifiant;

    private int version;

    private java.lang.String passwd;

    public ArticleIdentStruct() {
    }

    public ArticleIdentStruct(
           java.lang.String identifiant,
           int version,
           java.lang.String passwd) {
           this.identifiant = identifiant;
           this.version = version;
           this.passwd = passwd;
    }


    /**
     * Gets the identifiant value for this ArticleIdentStruct.
     * 
     * @return identifiant
     */
    public java.lang.String getIdentifiant() {
        return identifiant;
    }


    /**
     * Sets the identifiant value for this ArticleIdentStruct.
     * 
     * @param identifiant
     */
    public void setIdentifiant(java.lang.String identifiant) {
        this.identifiant = identifiant;
    }


    /**
     * Gets the version value for this ArticleIdentStruct.
     * 
     * @return version
     */
    public int getVersion() {
        return version;
    }


    /**
     * Sets the version value for this ArticleIdentStruct.
     * 
     * @param version
     */
    public void setVersion(int version) {
        this.version = version;
    }


    /**
     * Gets the passwd value for this ArticleIdentStruct.
     * 
     * @return passwd
     */
    public java.lang.String getPasswd() {
        return passwd;
    }


    /**
     * Sets the passwd value for this ArticleIdentStruct.
     * 
     * @param passwd
     */
    public void setPasswd(java.lang.String passwd) {
        this.passwd = passwd;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArticleIdentStruct)) return false;
        ArticleIdentStruct other = (ArticleIdentStruct) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.identifiant==null && other.getIdentifiant()==null) || 
             (this.identifiant!=null &&
              this.identifiant.equals(other.getIdentifiant()))) &&
            this.version == other.getVersion() &&
            ((this.passwd==null && other.getPasswd()==null) || 
             (this.passwd!=null &&
              this.passwd.equals(other.getPasswd())));
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
        if (getIdentifiant() != null) {
            _hashCode += getIdentifiant().hashCode();
        }
        _hashCode += getVersion();
        if (getPasswd() != null) {
            _hashCode += getPasswd().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ArticleIdentStruct.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "ArticleIdentStruct"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identifiant");
        elemField.setXmlName(new javax.xml.namespace.QName("", "identifiant"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("version");
        elemField.setXmlName(new javax.xml.namespace.QName("", "version"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("passwd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "passwd"));
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
