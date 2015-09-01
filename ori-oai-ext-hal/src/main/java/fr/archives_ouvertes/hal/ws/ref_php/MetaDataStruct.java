/**
 * MetaDataStruct.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.ref_php;

public class MetaDataStruct  implements java.io.Serializable {
    private java.lang.String name;

    private java.lang.String libelle;

    private java.lang.String comment;

    private boolean required;

    private java.lang.String[] domain;

    public MetaDataStruct() {
    }

    public MetaDataStruct(
           java.lang.String name,
           java.lang.String libelle,
           java.lang.String comment,
           boolean required,
           java.lang.String[] domain) {
           this.name = name;
           this.libelle = libelle;
           this.comment = comment;
           this.required = required;
           this.domain = domain;
    }


    /**
     * Gets the name value for this MetaDataStruct.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this MetaDataStruct.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the libelle value for this MetaDataStruct.
     * 
     * @return libelle
     */
    public java.lang.String getLibelle() {
        return libelle;
    }


    /**
     * Sets the libelle value for this MetaDataStruct.
     * 
     * @param libelle
     */
    public void setLibelle(java.lang.String libelle) {
        this.libelle = libelle;
    }


    /**
     * Gets the comment value for this MetaDataStruct.
     * 
     * @return comment
     */
    public java.lang.String getComment() {
        return comment;
    }


    /**
     * Sets the comment value for this MetaDataStruct.
     * 
     * @param comment
     */
    public void setComment(java.lang.String comment) {
        this.comment = comment;
    }


    /**
     * Gets the required value for this MetaDataStruct.
     * 
     * @return required
     */
    public boolean isRequired() {
        return required;
    }


    /**
     * Sets the required value for this MetaDataStruct.
     * 
     * @param required
     */
    public void setRequired(boolean required) {
        this.required = required;
    }


    /**
     * Gets the domain value for this MetaDataStruct.
     * 
     * @return domain
     */
    public java.lang.String[] getDomain() {
        return domain;
    }


    /**
     * Sets the domain value for this MetaDataStruct.
     * 
     * @param domain
     */
    public void setDomain(java.lang.String[] domain) {
        this.domain = domain;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MetaDataStruct)) return false;
        MetaDataStruct other = (MetaDataStruct) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.libelle==null && other.getLibelle()==null) || 
             (this.libelle!=null &&
              this.libelle.equals(other.getLibelle()))) &&
            ((this.comment==null && other.getComment()==null) || 
             (this.comment!=null &&
              this.comment.equals(other.getComment()))) &&
            this.required == other.isRequired() &&
            ((this.domain==null && other.getDomain()==null) || 
             (this.domain!=null &&
              java.util.Arrays.equals(this.domain, other.getDomain())));
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
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getLibelle() != null) {
            _hashCode += getLibelle().hashCode();
        }
        if (getComment() != null) {
            _hashCode += getComment().hashCode();
        }
        _hashCode += (isRequired() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getDomain() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDomain());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDomain(), i);
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
        new org.apache.axis.description.TypeDesc(MetaDataStruct.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "MetaDataStruct"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("libelle");
        elemField.setXmlName(new javax.xml.namespace.QName("", "libelle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("required");
        elemField.setXmlName(new javax.xml.namespace.QName("", "required"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domain");
        elemField.setXmlName(new javax.xml.namespace.QName("", "domain"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "string"));
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
