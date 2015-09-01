/**
 * LaboratoryStruct.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.submit_php;

public class LaboratoryStruct  implements java.io.Serializable {
    private int labId;

    private int knownLabid;

    private java.lang.String shortName;

    private java.lang.String name;

    private java.lang.String address;

    private java.lang.String url;

    private java.lang.String pays;

    private java.lang.String[] affiliation;

    public LaboratoryStruct() {
    }

    public LaboratoryStruct(
           int labId,
           int knownLabid,
           java.lang.String shortName,
           java.lang.String name,
           java.lang.String address,
           java.lang.String url,
           java.lang.String pays,
           java.lang.String[] affiliation) {
           this.labId = labId;
           this.knownLabid = knownLabid;
           this.shortName = shortName;
           this.name = name;
           this.address = address;
           this.url = url;
           this.pays = pays;
           this.affiliation = affiliation;
    }


    /**
     * Gets the labId value for this LaboratoryStruct.
     * 
     * @return labId
     */
    public int getLabId() {
        return labId;
    }


    /**
     * Sets the labId value for this LaboratoryStruct.
     * 
     * @param labId
     */
    public void setLabId(int labId) {
        this.labId = labId;
    }


    /**
     * Gets the knownLabid value for this LaboratoryStruct.
     * 
     * @return knownLabid
     */
    public int getKnownLabid() {
        return knownLabid;
    }


    /**
     * Sets the knownLabid value for this LaboratoryStruct.
     * 
     * @param knownLabid
     */
    public void setKnownLabid(int knownLabid) {
        this.knownLabid = knownLabid;
    }


    /**
     * Gets the shortName value for this LaboratoryStruct.
     * 
     * @return shortName
     */
    public java.lang.String getShortName() {
        return shortName;
    }


    /**
     * Sets the shortName value for this LaboratoryStruct.
     * 
     * @param shortName
     */
    public void setShortName(java.lang.String shortName) {
        this.shortName = shortName;
    }


    /**
     * Gets the name value for this LaboratoryStruct.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this LaboratoryStruct.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the address value for this LaboratoryStruct.
     * 
     * @return address
     */
    public java.lang.String getAddress() {
        return address;
    }


    /**
     * Sets the address value for this LaboratoryStruct.
     * 
     * @param address
     */
    public void setAddress(java.lang.String address) {
        this.address = address;
    }


    /**
     * Gets the url value for this LaboratoryStruct.
     * 
     * @return url
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this LaboratoryStruct.
     * 
     * @param url
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }


    /**
     * Gets the pays value for this LaboratoryStruct.
     * 
     * @return pays
     */
    public java.lang.String getPays() {
        return pays;
    }


    /**
     * Sets the pays value for this LaboratoryStruct.
     * 
     * @param pays
     */
    public void setPays(java.lang.String pays) {
        this.pays = pays;
    }


    /**
     * Gets the affiliation value for this LaboratoryStruct.
     * 
     * @return affiliation
     */
    public java.lang.String[] getAffiliation() {
        return affiliation;
    }


    /**
     * Sets the affiliation value for this LaboratoryStruct.
     * 
     * @param affiliation
     */
    public void setAffiliation(java.lang.String[] affiliation) {
        this.affiliation = affiliation;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LaboratoryStruct)) return false;
        LaboratoryStruct other = (LaboratoryStruct) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.labId == other.getLabId() &&
            this.knownLabid == other.getKnownLabid() &&
            ((this.shortName==null && other.getShortName()==null) || 
             (this.shortName!=null &&
              this.shortName.equals(other.getShortName()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.address==null && other.getAddress()==null) || 
             (this.address!=null &&
              this.address.equals(other.getAddress()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl()))) &&
            ((this.pays==null && other.getPays()==null) || 
             (this.pays!=null &&
              this.pays.equals(other.getPays()))) &&
            ((this.affiliation==null && other.getAffiliation()==null) || 
             (this.affiliation!=null &&
              java.util.Arrays.equals(this.affiliation, other.getAffiliation())));
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
        _hashCode += getLabId();
        _hashCode += getKnownLabid();
        if (getShortName() != null) {
            _hashCode += getShortName().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        if (getPays() != null) {
            _hashCode += getPays().hashCode();
        }
        if (getAffiliation() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAffiliation());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAffiliation(), i);
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
        new org.apache.axis.description.TypeDesc(LaboratoryStruct.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "LaboratoryStruct"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("labId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "labId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("knownLabid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "knownLabid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shortName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "shortName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("", "address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pays");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("affiliation");
        elemField.setXmlName(new javax.xml.namespace.QName("", "affiliation"));
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
