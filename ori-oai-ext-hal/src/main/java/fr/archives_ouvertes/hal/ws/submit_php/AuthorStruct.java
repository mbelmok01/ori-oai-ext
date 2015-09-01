/**
 * AuthorStruct.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.submit_php;

public class AuthorStruct  implements java.io.Serializable {
    private int[] labIds;

    private java.lang.String lastName;

    private java.lang.String firstName;

    private java.lang.String otherName;

    private java.lang.String email;

    private java.lang.String url;

    private java.lang.String organism;

    private java.lang.String researchTeam;

    private boolean corresponding;

    public AuthorStruct() {
    }

    public AuthorStruct(
           int[] labIds,
           java.lang.String lastName,
           java.lang.String firstName,
           java.lang.String otherName,
           java.lang.String email,
           java.lang.String url,
           java.lang.String organism,
           java.lang.String researchTeam,
           boolean corresponding) {
           this.labIds = labIds;
           this.lastName = lastName;
           this.firstName = firstName;
           this.otherName = otherName;
           this.email = email;
           this.url = url;
           this.organism = organism;
           this.researchTeam = researchTeam;
           this.corresponding = corresponding;
    }


    /**
     * Gets the labIds value for this AuthorStruct.
     * 
     * @return labIds
     */
    public int[] getLabIds() {
        return labIds;
    }


    /**
     * Sets the labIds value for this AuthorStruct.
     * 
     * @param labIds
     */
    public void setLabIds(int[] labIds) {
        this.labIds = labIds;
    }


    /**
     * Gets the lastName value for this AuthorStruct.
     * 
     * @return lastName
     */
    public java.lang.String getLastName() {
        return lastName;
    }


    /**
     * Sets the lastName value for this AuthorStruct.
     * 
     * @param lastName
     */
    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }


    /**
     * Gets the firstName value for this AuthorStruct.
     * 
     * @return firstName
     */
    public java.lang.String getFirstName() {
        return firstName;
    }


    /**
     * Sets the firstName value for this AuthorStruct.
     * 
     * @param firstName
     */
    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }


    /**
     * Gets the otherName value for this AuthorStruct.
     * 
     * @return otherName
     */
    public java.lang.String getOtherName() {
        return otherName;
    }


    /**
     * Sets the otherName value for this AuthorStruct.
     * 
     * @param otherName
     */
    public void setOtherName(java.lang.String otherName) {
        this.otherName = otherName;
    }


    /**
     * Gets the email value for this AuthorStruct.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this AuthorStruct.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the url value for this AuthorStruct.
     * 
     * @return url
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this AuthorStruct.
     * 
     * @param url
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }


    /**
     * Gets the organism value for this AuthorStruct.
     * 
     * @return organism
     */
    public java.lang.String getOrganism() {
        return organism;
    }


    /**
     * Sets the organism value for this AuthorStruct.
     * 
     * @param organism
     */
    public void setOrganism(java.lang.String organism) {
        this.organism = organism;
    }


    /**
     * Gets the researchTeam value for this AuthorStruct.
     * 
     * @return researchTeam
     */
    public java.lang.String getResearchTeam() {
        return researchTeam;
    }


    /**
     * Sets the researchTeam value for this AuthorStruct.
     * 
     * @param researchTeam
     */
    public void setResearchTeam(java.lang.String researchTeam) {
        this.researchTeam = researchTeam;
    }


    /**
     * Gets the corresponding value for this AuthorStruct.
     * 
     * @return corresponding
     */
    public boolean isCorresponding() {
        return corresponding;
    }


    /**
     * Sets the corresponding value for this AuthorStruct.
     * 
     * @param corresponding
     */
    public void setCorresponding(boolean corresponding) {
        this.corresponding = corresponding;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AuthorStruct)) return false;
        AuthorStruct other = (AuthorStruct) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.labIds==null && other.getLabIds()==null) || 
             (this.labIds!=null &&
              java.util.Arrays.equals(this.labIds, other.getLabIds()))) &&
            ((this.lastName==null && other.getLastName()==null) || 
             (this.lastName!=null &&
              this.lastName.equals(other.getLastName()))) &&
            ((this.firstName==null && other.getFirstName()==null) || 
             (this.firstName!=null &&
              this.firstName.equals(other.getFirstName()))) &&
            ((this.otherName==null && other.getOtherName()==null) || 
             (this.otherName!=null &&
              this.otherName.equals(other.getOtherName()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl()))) &&
            ((this.organism==null && other.getOrganism()==null) || 
             (this.organism!=null &&
              this.organism.equals(other.getOrganism()))) &&
            ((this.researchTeam==null && other.getResearchTeam()==null) || 
             (this.researchTeam!=null &&
              this.researchTeam.equals(other.getResearchTeam()))) &&
            this.corresponding == other.isCorresponding();
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
        if (getLabIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLabIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLabIds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLastName() != null) {
            _hashCode += getLastName().hashCode();
        }
        if (getFirstName() != null) {
            _hashCode += getFirstName().hashCode();
        }
        if (getOtherName() != null) {
            _hashCode += getOtherName().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        if (getOrganism() != null) {
            _hashCode += getOrganism().hashCode();
        }
        if (getResearchTeam() != null) {
            _hashCode += getResearchTeam().hashCode();
        }
        _hashCode += (isCorresponding() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AuthorStruct.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "AuthorStruct"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("labIds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "labIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lastName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firstName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "firstName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("otherName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "otherName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email"));
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
        elemField.setFieldName("organism");
        elemField.setXmlName(new javax.xml.namespace.QName("", "organism"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("researchTeam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "researchTeam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corresponding");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corresponding"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
