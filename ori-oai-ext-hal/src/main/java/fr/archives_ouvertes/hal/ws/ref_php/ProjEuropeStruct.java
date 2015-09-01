/**
 * ProjEuropeStruct.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.ref_php;

public class ProjEuropeStruct  implements java.io.Serializable {
    private int code;

    private java.lang.String numero;

    private java.lang.String acronyme;

    private java.lang.String titre;

    private java.lang.String callid;

    private java.lang.String fundedby;

    private java.lang.String sdate;

    private java.lang.String edate;

    public ProjEuropeStruct() {
    }

    public ProjEuropeStruct(
           int code,
           java.lang.String numero,
           java.lang.String acronyme,
           java.lang.String titre,
           java.lang.String callid,
           java.lang.String fundedby,
           java.lang.String sdate,
           java.lang.String edate) {
           this.code = code;
           this.numero = numero;
           this.acronyme = acronyme;
           this.titre = titre;
           this.callid = callid;
           this.fundedby = fundedby;
           this.sdate = sdate;
           this.edate = edate;
    }


    /**
     * Gets the code value for this ProjEuropeStruct.
     * 
     * @return code
     */
    public int getCode() {
        return code;
    }


    /**
     * Sets the code value for this ProjEuropeStruct.
     * 
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }


    /**
     * Gets the numero value for this ProjEuropeStruct.
     * 
     * @return numero
     */
    public java.lang.String getNumero() {
        return numero;
    }


    /**
     * Sets the numero value for this ProjEuropeStruct.
     * 
     * @param numero
     */
    public void setNumero(java.lang.String numero) {
        this.numero = numero;
    }


    /**
     * Gets the acronyme value for this ProjEuropeStruct.
     * 
     * @return acronyme
     */
    public java.lang.String getAcronyme() {
        return acronyme;
    }


    /**
     * Sets the acronyme value for this ProjEuropeStruct.
     * 
     * @param acronyme
     */
    public void setAcronyme(java.lang.String acronyme) {
        this.acronyme = acronyme;
    }


    /**
     * Gets the titre value for this ProjEuropeStruct.
     * 
     * @return titre
     */
    public java.lang.String getTitre() {
        return titre;
    }


    /**
     * Sets the titre value for this ProjEuropeStruct.
     * 
     * @param titre
     */
    public void setTitre(java.lang.String titre) {
        this.titre = titre;
    }


    /**
     * Gets the callid value for this ProjEuropeStruct.
     * 
     * @return callid
     */
    public java.lang.String getCallid() {
        return callid;
    }


    /**
     * Sets the callid value for this ProjEuropeStruct.
     * 
     * @param callid
     */
    public void setCallid(java.lang.String callid) {
        this.callid = callid;
    }


    /**
     * Gets the fundedby value for this ProjEuropeStruct.
     * 
     * @return fundedby
     */
    public java.lang.String getFundedby() {
        return fundedby;
    }


    /**
     * Sets the fundedby value for this ProjEuropeStruct.
     * 
     * @param fundedby
     */
    public void setFundedby(java.lang.String fundedby) {
        this.fundedby = fundedby;
    }


    /**
     * Gets the sdate value for this ProjEuropeStruct.
     * 
     * @return sdate
     */
    public java.lang.String getSdate() {
        return sdate;
    }


    /**
     * Sets the sdate value for this ProjEuropeStruct.
     * 
     * @param sdate
     */
    public void setSdate(java.lang.String sdate) {
        this.sdate = sdate;
    }


    /**
     * Gets the edate value for this ProjEuropeStruct.
     * 
     * @return edate
     */
    public java.lang.String getEdate() {
        return edate;
    }


    /**
     * Sets the edate value for this ProjEuropeStruct.
     * 
     * @param edate
     */
    public void setEdate(java.lang.String edate) {
        this.edate = edate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProjEuropeStruct)) return false;
        ProjEuropeStruct other = (ProjEuropeStruct) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.code == other.getCode() &&
            ((this.numero==null && other.getNumero()==null) || 
             (this.numero!=null &&
              this.numero.equals(other.getNumero()))) &&
            ((this.acronyme==null && other.getAcronyme()==null) || 
             (this.acronyme!=null &&
              this.acronyme.equals(other.getAcronyme()))) &&
            ((this.titre==null && other.getTitre()==null) || 
             (this.titre!=null &&
              this.titre.equals(other.getTitre()))) &&
            ((this.callid==null && other.getCallid()==null) || 
             (this.callid!=null &&
              this.callid.equals(other.getCallid()))) &&
            ((this.fundedby==null && other.getFundedby()==null) || 
             (this.fundedby!=null &&
              this.fundedby.equals(other.getFundedby()))) &&
            ((this.sdate==null && other.getSdate()==null) || 
             (this.sdate!=null &&
              this.sdate.equals(other.getSdate()))) &&
            ((this.edate==null && other.getEdate()==null) || 
             (this.edate!=null &&
              this.edate.equals(other.getEdate())));
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
        if (getNumero() != null) {
            _hashCode += getNumero().hashCode();
        }
        if (getAcronyme() != null) {
            _hashCode += getAcronyme().hashCode();
        }
        if (getTitre() != null) {
            _hashCode += getTitre().hashCode();
        }
        if (getCallid() != null) {
            _hashCode += getCallid().hashCode();
        }
        if (getFundedby() != null) {
            _hashCode += getFundedby().hashCode();
        }
        if (getSdate() != null) {
            _hashCode += getSdate().hashCode();
        }
        if (getEdate() != null) {
            _hashCode += getEdate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProjEuropeStruct.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ProjEuropeStruct"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numero");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numero"));
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
        elemField.setFieldName("callid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "callid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fundedby");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fundedby"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sdate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sdate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("edate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "edate"));
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
