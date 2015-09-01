/**
 * FileStruct.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.submit_php;

public class FileStruct  implements java.io.Serializable {
    private java.lang.String name;

    private java.lang.String md5;

    private java.lang.String format;

    private java.lang.String mainWebFile;

    private java.lang.String content;

    private boolean local;

    public FileStruct() {
    }

    public FileStruct(
           java.lang.String name,
           java.lang.String md5,
           java.lang.String format,
           java.lang.String mainWebFile,
           java.lang.String content,
           boolean local) {
           this.name = name;
           this.md5 = md5;
           this.format = format;
           this.mainWebFile = mainWebFile;
           this.content = content;
           this.local = local;
    }


    /**
     * Gets the name value for this FileStruct.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this FileStruct.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the md5 value for this FileStruct.
     * 
     * @return md5
     */
    public java.lang.String getMd5() {
        return md5;
    }


    /**
     * Sets the md5 value for this FileStruct.
     * 
     * @param md5
     */
    public void setMd5(java.lang.String md5) {
        this.md5 = md5;
    }


    /**
     * Gets the format value for this FileStruct.
     * 
     * @return format
     */
    public java.lang.String getFormat() {
        return format;
    }


    /**
     * Sets the format value for this FileStruct.
     * 
     * @param format
     */
    public void setFormat(java.lang.String format) {
        this.format = format;
    }


    /**
     * Gets the mainWebFile value for this FileStruct.
     * 
     * @return mainWebFile
     */
    public java.lang.String getMainWebFile() {
        return mainWebFile;
    }


    /**
     * Sets the mainWebFile value for this FileStruct.
     * 
     * @param mainWebFile
     */
    public void setMainWebFile(java.lang.String mainWebFile) {
        this.mainWebFile = mainWebFile;
    }


    /**
     * Gets the content value for this FileStruct.
     * 
     * @return content
     */
    public java.lang.String getContent() {
        return content;
    }


    /**
     * Sets the content value for this FileStruct.
     * 
     * @param content
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }


    /**
     * Gets the local value for this FileStruct.
     * 
     * @return local
     */
    public boolean isLocal() {
        return local;
    }


    /**
     * Sets the local value for this FileStruct.
     * 
     * @param local
     */
    public void setLocal(boolean local) {
        this.local = local;
    }
    
    
    public String toString() {
    	StringBuffer sb = new StringBuffer();
    	
    	sb.append("     local="+local+"\n");
    	sb.append("     name="+name+"\n");
    	sb.append("     format="+format+"\n");
    	sb.append("     mainWebFile="+mainWebFile+"\n");
    	sb.append("     md5="+md5+"\n");
    	//sb.append("     content="+content+"\n");
    	
    	return sb.toString();
    }
    
    
    
    

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FileStruct)) return false;
        FileStruct other = (FileStruct) obj;
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
            ((this.md5==null && other.getMd5()==null) || 
             (this.md5!=null &&
              this.md5.equals(other.getMd5()))) &&
            ((this.format==null && other.getFormat()==null) || 
             (this.format!=null &&
              this.format.equals(other.getFormat()))) &&
            ((this.mainWebFile==null && other.getMainWebFile()==null) || 
             (this.mainWebFile!=null &&
              this.mainWebFile.equals(other.getMainWebFile()))) &&
            ((this.content==null && other.getContent()==null) || 
             (this.content!=null &&
              this.content.equals(other.getContent()))) &&
            this.local == other.isLocal();
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
        if (getMd5() != null) {
            _hashCode += getMd5().hashCode();
        }
        if (getFormat() != null) {
            _hashCode += getFormat().hashCode();
        }
        if (getMainWebFile() != null) {
            _hashCode += getMainWebFile().hashCode();
        }
        if (getContent() != null) {
            _hashCode += getContent().hashCode();
        }
        _hashCode += (isLocal() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FileStruct.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "FileStruct"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("md5");
        elemField.setXmlName(new javax.xml.namespace.QName("", "md5"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("format");
        elemField.setXmlName(new javax.xml.namespace.QName("", "format"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mainWebFile");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mainWebFile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("content");
        elemField.setXmlName(new javax.xml.namespace.QName("", "content"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("local");
        elemField.setXmlName(new javax.xml.namespace.QName("", "local"));
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
