/**
 * MetasStruct.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.submit_php;

public class MetasStruct  implements java.io.Serializable {
    private fr.archives_ouvertes.hal.ws.submit_php.MetaStruct[] metaSimple;

    private fr.archives_ouvertes.hal.ws.submit_php.AutLabStruct metaAutLab;

    public MetasStruct() {
    }

    public MetasStruct(
           fr.archives_ouvertes.hal.ws.submit_php.MetaStruct[] metaSimple,
           fr.archives_ouvertes.hal.ws.submit_php.AutLabStruct metaAutLab) {
           this.metaSimple = metaSimple;
           this.metaAutLab = metaAutLab;
    }


    /**
     * Gets the metaSimple value for this MetasStruct.
     * 
     * @return metaSimple
     */
    public fr.archives_ouvertes.hal.ws.submit_php.MetaStruct[] getMetaSimple() {
        return metaSimple;
    }


    /**
     * Sets the metaSimple value for this MetasStruct.
     * 
     * @param metaSimple
     */
    public void setMetaSimple(fr.archives_ouvertes.hal.ws.submit_php.MetaStruct[] metaSimple) {
        this.metaSimple = metaSimple;
    }


    /**
     * Gets the metaAutLab value for this MetasStruct.
     * 
     * @return metaAutLab
     */
    public fr.archives_ouvertes.hal.ws.submit_php.AutLabStruct getMetaAutLab() {
        return metaAutLab;
    }


    /**
     * Sets the metaAutLab value for this MetasStruct.
     * 
     * @param metaAutLab
     */
    public void setMetaAutLab(fr.archives_ouvertes.hal.ws.submit_php.AutLabStruct metaAutLab) {
        this.metaAutLab = metaAutLab;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MetasStruct)) return false;
        MetasStruct other = (MetasStruct) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.metaSimple==null && other.getMetaSimple()==null) || 
             (this.metaSimple!=null &&
              java.util.Arrays.equals(this.metaSimple, other.getMetaSimple()))) &&
            ((this.metaAutLab==null && other.getMetaAutLab()==null) || 
             (this.metaAutLab!=null &&
              this.metaAutLab.equals(other.getMetaAutLab())));
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
        if (getMetaSimple() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMetaSimple());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMetaSimple(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMetaAutLab() != null) {
            _hashCode += getMetaAutLab().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MetasStruct.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "MetasStruct"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metaSimple");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metaSimple"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "MetaStruct"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metaAutLab");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metaAutLab"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "AutLabStruct"));
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
