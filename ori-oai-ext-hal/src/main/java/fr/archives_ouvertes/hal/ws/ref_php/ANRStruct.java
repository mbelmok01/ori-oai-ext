/**
 * ANRStruct.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.ref_php;

public class ANRStruct  implements java.io.Serializable {
    private int code;

    private java.lang.String reference;

    private java.lang.String annee;

    private java.lang.String acronyme;

    private java.lang.String titre;

    private java.lang.String intitule;

    private java.lang.String acroappel;

    public ANRStruct() {
    }

    public ANRStruct(
           int code,
           java.lang.String reference,
           java.lang.String annee,
           java.lang.String acronyme,
           java.lang.String titre,
           java.lang.String intitule,
           java.lang.String acroappel) {
           this.code = code;
           this.reference = reference;
           this.annee = annee;
           this.acronyme = acronyme;
           this.titre = titre;
           this.intitule = intitule;
           this.acroappel = acroappel;
    }


    /**
     * Gets the code value for this ANRStruct.
     * 
     * @return code
     */
    public int getCode() {
        return code;
    }


    /**
     * Sets the code value for this ANRStruct.
     * 
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }


    /**
     * Gets the reference value for this ANRStruct.
     * 
     * @return reference
     */
    public java.lang.String getReference() {
        return reference;
    }


    /**
     * Sets the reference value for this ANRStruct.
     * 
     * @param reference
     */
    public void setReference(java.lang.String reference) {
        this.reference = reference;
    }


    /**
     * Gets the annee value for this ANRStruct.
     * 
     * @return annee
     */
    public java.lang.String getAnnee() {
        return annee;
    }


    /**
     * Sets the annee value for this ANRStruct.
     * 
     * @param annee
     */
    public void setAnnee(java.lang.String annee) {
        this.annee = annee;
    }


    /**
     * Gets the acronyme value for this ANRStruct.
     * 
     * @return acronyme
     */
    public java.lang.String getAcronyme() {
        return acronyme;
    }


    /**
     * Sets the acronyme value for this ANRStruct.
     * 
     * @param acronyme
     */
    public void setAcronyme(java.lang.String acronyme) {
        this.acronyme = acronyme;
    }


    /**
     * Gets the titre value for this ANRStruct.
     * 
     * @return titre
     */
    public java.lang.String getTitre() {
        return titre;
    }


    /**
     * Sets the titre value for this ANRStruct.
     * 
     * @param titre
     */
    public void setTitre(java.lang.String titre) {
        this.titre = titre;
    }


    /**
     * Gets the intitule value for this ANRStruct.
     * 
     * @return intitule
     */
    public java.lang.String getIntitule() {
        return intitule;
    }


    /**
     * Sets the intitule value for this ANRStruct.
     * 
     * @param intitule
     */
    public void setIntitule(java.lang.String intitule) {
        this.intitule = intitule;
    }


    /**
     * Gets the acroappel value for this ANRStruct.
     * 
     * @return acroappel
     */
    public java.lang.String getAcroappel() {
        return acroappel;
    }


    /**
     * Sets the acroappel value for this ANRStruct.
     * 
     * @param acroappel
     */
    public void setAcroappel(java.lang.String acroappel) {
        this.acroappel = acroappel;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ANRStruct)) return false;
        ANRStruct other = (ANRStruct) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.code == other.getCode() &&
            ((this.reference==null && other.getReference()==null) || 
             (this.reference!=null &&
              this.reference.equals(other.getReference()))) &&
            ((this.annee==null && other.getAnnee()==null) || 
             (this.annee!=null &&
              this.annee.equals(other.getAnnee()))) &&
            ((this.acronyme==null && other.getAcronyme()==null) || 
             (this.acronyme!=null &&
              this.acronyme.equals(other.getAcronyme()))) &&
            ((this.titre==null && other.getTitre()==null) || 
             (this.titre!=null &&
              this.titre.equals(other.getTitre()))) &&
            ((this.intitule==null && other.getIntitule()==null) || 
             (this.intitule!=null &&
              this.intitule.equals(other.getIntitule()))) &&
            ((this.acroappel==null && other.getAcroappel()==null) || 
             (this.acroappel!=null &&
              this.acroappel.equals(other.getAcroappel())));
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
        _hashCode += getCode();
        if (getReference() != null) {
            _hashCode += getReference().hashCode();
        }
        if (getAnnee() != null) {
            _hashCode += getAnnee().hashCode();
        }
        if (getAcronyme() != null) {
            _hashCode += getAcronyme().hashCode();
        }
        if (getTitre() != null) {
            _hashCode += getTitre().hashCode();
        }
        if (getIntitule() != null) {
            _hashCode += getIntitule().hashCode();
        }
        if (getAcroappel() != null) {
            _hashCode += getAcroappel().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ANRStruct.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ANRStruct"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reference");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "annee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acronyme");
        elemField.setXmlName(new javax.xml.namespace.QName("", "acronyme"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "titre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intitule");
        elemField.setXmlName(new javax.xml.namespace.QName("", "intitule"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acroappel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "acroappel"));
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
