/**
 * AutLabStruct.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.search_php;

public class AutLabStruct  implements java.io.Serializable {
    private fr.archives_ouvertes.hal.ws.search_php.AuthorStruct[] authors;

    private fr.archives_ouvertes.hal.ws.search_php.LaboratoryStruct[] labs;

    public AutLabStruct() {
    }

    public AutLabStruct(
           fr.archives_ouvertes.hal.ws.search_php.AuthorStruct[] authors,
           fr.archives_ouvertes.hal.ws.search_php.LaboratoryStruct[] labs) {
           this.authors = authors;
           this.labs = labs;
    }


    /**
     * Gets the authors value for this AutLabStruct.
     * 
     * @return authors
     */
    public fr.archives_ouvertes.hal.ws.search_php.AuthorStruct[] getAuthors() {
        return authors;
    }


    /**
     * Sets the authors value for this AutLabStruct.
     * 
     * @param authors
     */
    public void setAuthors(fr.archives_ouvertes.hal.ws.search_php.AuthorStruct[] authors) {
        this.authors = authors;
    }


    /**
     * Gets the labs value for this AutLabStruct.
     * 
     * @return labs
     */
    public fr.archives_ouvertes.hal.ws.search_php.LaboratoryStruct[] getLabs() {
        return labs;
    }


    /**
     * Sets the labs value for this AutLabStruct.
     * 
     * @param labs
     */
    public void setLabs(fr.archives_ouvertes.hal.ws.search_php.LaboratoryStruct[] labs) {
        this.labs = labs;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AutLabStruct)) return false;
        AutLabStruct other = (AutLabStruct) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.authors==null && other.getAuthors()==null) || 
             (this.authors!=null &&
              java.util.Arrays.equals(this.authors, other.getAuthors()))) &&
            ((this.labs==null && other.getLabs()==null) || 
             (this.labs!=null &&
              java.util.Arrays.equals(this.labs, other.getLabs())));
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
        if (getAuthors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAuthors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAuthors(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLabs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLabs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLabs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AutLabStruct.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "AutLabStruct"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authors");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "AuthorStruct"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("labs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "labs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "LaboratoryStruct"));
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
