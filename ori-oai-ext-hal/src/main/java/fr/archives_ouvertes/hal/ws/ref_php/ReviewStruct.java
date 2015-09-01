/**
 * ReviewStruct.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.ref_php;

public class ReviewStruct  implements java.io.Serializable {
    private java.lang.String name;

    private java.lang.String shortName;

    private java.lang.String ISSN;

    private java.lang.String editor;

    private java.lang.String EISSN;

    public ReviewStruct() {
    }

    public ReviewStruct(
           java.lang.String name,
           java.lang.String shortName,
           java.lang.String ISSN,
           java.lang.String editor,
           java.lang.String EISSN) {
           this.name = name;
           this.shortName = shortName;
           this.ISSN = ISSN;
           this.editor = editor;
           this.EISSN = EISSN;
    }


    /**
     * Gets the name value for this ReviewStruct.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this ReviewStruct.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the shortName value for this ReviewStruct.
     * 
     * @return shortName
     */
    public java.lang.String getShortName() {
        return shortName;
    }


    /**
     * Sets the shortName value for this ReviewStruct.
     * 
     * @param shortName
     */
    public void setShortName(java.lang.String shortName) {
        this.shortName = shortName;
    }


    /**
     * Gets the ISSN value for this ReviewStruct.
     * 
     * @return ISSN
     */
    public java.lang.String getISSN() {
        return ISSN;
    }


    /**
     * Sets the ISSN value for this ReviewStruct.
     * 
     * @param ISSN
     */
    public void setISSN(java.lang.String ISSN) {
        this.ISSN = ISSN;
    }


    /**
     * Gets the editor value for this ReviewStruct.
     * 
     * @return editor
     */
    public java.lang.String getEditor() {
        return editor;
    }


    /**
     * Sets the editor value for this ReviewStruct.
     * 
     * @param editor
     */
    public void setEditor(java.lang.String editor) {
        this.editor = editor;
    }


    /**
     * Gets the EISSN value for this ReviewStruct.
     * 
     * @return EISSN
     */
    public java.lang.String getEISSN() {
        return EISSN;
    }


    /**
     * Sets the EISSN value for this ReviewStruct.
     * 
     * @param EISSN
     */
    public void setEISSN(java.lang.String EISSN) {
        this.EISSN = EISSN;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReviewStruct)) return false;
        ReviewStruct other = (ReviewStruct) obj;
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
            ((this.shortName==null && other.getShortName()==null) || 
             (this.shortName!=null &&
              this.shortName.equals(other.getShortName()))) &&
            ((this.ISSN==null && other.getISSN()==null) || 
             (this.ISSN!=null &&
              this.ISSN.equals(other.getISSN()))) &&
            ((this.editor==null && other.getEditor()==null) || 
             (this.editor!=null &&
              this.editor.equals(other.getEditor()))) &&
            ((this.EISSN==null && other.getEISSN()==null) || 
             (this.EISSN!=null &&
              this.EISSN.equals(other.getEISSN())));
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
        if (getShortName() != null) {
            _hashCode += getShortName().hashCode();
        }
        if (getISSN() != null) {
            _hashCode += getISSN().hashCode();
        }
        if (getEditor() != null) {
            _hashCode += getEditor().hashCode();
        }
        if (getEISSN() != null) {
            _hashCode += getEISSN().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReviewStruct.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ReviewStruct"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shortName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "shortName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ISSN");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ISSN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("editor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "editor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EISSN");
        elemField.setXmlName(new javax.xml.namespace.QName("", "EISSN"));
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
