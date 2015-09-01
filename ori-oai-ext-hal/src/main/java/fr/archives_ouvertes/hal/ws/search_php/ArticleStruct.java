/**
 * ArticleStruct.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.search_php;

public class ArticleStruct  implements java.io.Serializable {
    private java.lang.String identifiant;

    private int version;

    private java.lang.String url;

    private java.lang.String title;

    private boolean havefile;

    private java.lang.String typdoc;

    public ArticleStruct() {
    }

    public ArticleStruct(
           java.lang.String identifiant,
           int version,
           java.lang.String url,
           java.lang.String title,
           boolean havefile,
           java.lang.String typdoc) {
           this.identifiant = identifiant;
           this.version = version;
           this.url = url;
           this.title = title;
           this.havefile = havefile;
           this.typdoc = typdoc;
    }


    /**
     * Gets the identifiant value for this ArticleStruct.
     * 
     * @return identifiant
     */
    public java.lang.String getIdentifiant() {
        return identifiant;
    }


    /**
     * Sets the identifiant value for this ArticleStruct.
     * 
     * @param identifiant
     */
    public void setIdentifiant(java.lang.String identifiant) {
        this.identifiant = identifiant;
    }


    /**
     * Gets the version value for this ArticleStruct.
     * 
     * @return version
     */
    public int getVersion() {
        return version;
    }


    /**
     * Sets the version value for this ArticleStruct.
     * 
     * @param version
     */
    public void setVersion(int version) {
        this.version = version;
    }


    /**
     * Gets the url value for this ArticleStruct.
     * 
     * @return url
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this ArticleStruct.
     * 
     * @param url
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }


    /**
     * Gets the title value for this ArticleStruct.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this ArticleStruct.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the havefile value for this ArticleStruct.
     * 
     * @return havefile
     */
    public boolean isHavefile() {
        return havefile;
    }


    /**
     * Sets the havefile value for this ArticleStruct.
     * 
     * @param havefile
     */
    public void setHavefile(boolean havefile) {
        this.havefile = havefile;
    }


    /**
     * Gets the typdoc value for this ArticleStruct.
     * 
     * @return typdoc
     */
    public java.lang.String getTypdoc() {
        return typdoc;
    }


    /**
     * Sets the typdoc value for this ArticleStruct.
     * 
     * @param typdoc
     */
    public void setTypdoc(java.lang.String typdoc) {
        this.typdoc = typdoc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArticleStruct)) return false;
        ArticleStruct other = (ArticleStruct) obj;
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
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            this.havefile == other.isHavefile() &&
            ((this.typdoc==null && other.getTypdoc()==null) || 
             (this.typdoc!=null &&
              this.typdoc.equals(other.getTypdoc())));
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
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        _hashCode += (isHavefile() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getTypdoc() != null) {
            _hashCode += getTypdoc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ArticleStruct.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "ArticleStruct"));
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
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("", "title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("havefile");
        elemField.setXmlName(new javax.xml.namespace.QName("", "havefile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("typdoc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "typdoc"));
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
