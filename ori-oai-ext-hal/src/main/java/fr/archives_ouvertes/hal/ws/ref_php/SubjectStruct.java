/**
 * SubjectStruct.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.ref_php;

public class SubjectStruct  implements java.io.Serializable {
    private java.lang.String code;

    private java.lang.String codeParent;

    private boolean deposable;

    private boolean haveNext;

    private java.lang.String libelle;

    public SubjectStruct() {
    }

    public SubjectStruct(
           java.lang.String code,
           java.lang.String codeParent,
           boolean deposable,
           boolean haveNext,
           java.lang.String libelle) {
           this.code = code;
           this.codeParent = codeParent;
           this.deposable = deposable;
           this.haveNext = haveNext;
           this.libelle = libelle;
    }


    /**
     * Gets the code value for this SubjectStruct.
     * 
     * @return code
     */
    public java.lang.String getCode() {
        return code;
    }


    /**
     * Sets the code value for this SubjectStruct.
     * 
     * @param code
     */
    public void setCode(java.lang.String code) {
        this.code = code;
    }


    /**
     * Gets the codeParent value for this SubjectStruct.
     * 
     * @return codeParent
     */
    public java.lang.String getCodeParent() {
        return codeParent;
    }


    /**
     * Sets the codeParent value for this SubjectStruct.
     * 
     * @param codeParent
     */
    public void setCodeParent(java.lang.String codeParent) {
        this.codeParent = codeParent;
    }


    /**
     * Gets the deposable value for this SubjectStruct.
     * 
     * @return deposable
     */
    public boolean isDeposable() {
        return deposable;
    }


    /**
     * Sets the deposable value for this SubjectStruct.
     * 
     * @param deposable
     */
    public void setDeposable(boolean deposable) {
        this.deposable = deposable;
    }


    /**
     * Gets the haveNext value for this SubjectStruct.
     * 
     * @return haveNext
     */
    public boolean isHaveNext() {
        return haveNext;
    }


    /**
     * Sets the haveNext value for this SubjectStruct.
     * 
     * @param haveNext
     */
    public void setHaveNext(boolean haveNext) {
        this.haveNext = haveNext;
    }


    /**
     * Gets the libelle value for this SubjectStruct.
     * 
     * @return libelle
     */
    public java.lang.String getLibelle() {
        return libelle;
    }


    /**
     * Sets the libelle value for this SubjectStruct.
     * 
     * @param libelle
     */
    public void setLibelle(java.lang.String libelle) {
        this.libelle = libelle;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SubjectStruct)) return false;
        SubjectStruct other = (SubjectStruct) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.code==null && other.getCode()==null) || 
             (this.code!=null &&
              this.code.equals(other.getCode()))) &&
            ((this.codeParent==null && other.getCodeParent()==null) || 
             (this.codeParent!=null &&
              this.codeParent.equals(other.getCodeParent()))) &&
            this.deposable == other.isDeposable() &&
            this.haveNext == other.isHaveNext() &&
            ((this.libelle==null && other.getLibelle()==null) || 
             (this.libelle!=null &&
              this.libelle.equals(other.getLibelle())));
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
        if (getCode() != null) {
            _hashCode += getCode().hashCode();
        }
        if (getCodeParent() != null) {
            _hashCode += getCodeParent().hashCode();
        }
        _hashCode += (isDeposable() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isHaveNext() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getLibelle() != null) {
            _hashCode += getLibelle().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SubjectStruct.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "SubjectStruct"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codeParent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codeParent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deposable");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deposable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("haveNext");
        elemField.setXmlName(new javax.xml.namespace.QName("", "haveNext"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("libelle");
        elemField.setXmlName(new javax.xml.namespace.QName("", "libelle"));
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
