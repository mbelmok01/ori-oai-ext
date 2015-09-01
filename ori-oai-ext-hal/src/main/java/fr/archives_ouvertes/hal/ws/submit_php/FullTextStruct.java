/**
 * FullTextStruct.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.submit_php;

public class FullTextStruct  implements java.io.Serializable {
    private int right;

    private fr.archives_ouvertes.hal.ws.submit_php.FileStruct[] files;

    public FullTextStruct() {
    }

    public FullTextStruct(
           int right,
           fr.archives_ouvertes.hal.ws.submit_php.FileStruct[] files) {
           this.right = right;
           this.files = files;
    }


    /**
     * Gets the right value for this FullTextStruct.
     * 
     * @return right
     */
    public int getRight() {
        return right;
    }


    /**
     * Sets the right value for this FullTextStruct.
     * 
     * @param right
     */
    public void setRight(int right) {
        this.right = right;
    }


    /**
     * Gets the files value for this FullTextStruct.
     * 
     * @return files
     */
    public fr.archives_ouvertes.hal.ws.submit_php.FileStruct[] getFiles() {
        return files;
    }


    /**
     * Sets the files value for this FullTextStruct.
     * 
     * @param files
     */
    public void setFiles(fr.archives_ouvertes.hal.ws.submit_php.FileStruct[] files) {
        this.files = files;
    }
    
    
    public String toString() {
    	StringBuffer sb = new StringBuffer();
    	
    	sb.append("right="+right+"\n");
    	sb.append("files=\n");
    	if (files!=null) {
    		for (FileStruct file : files) {
    			sb.append(file+"\n");
    		}
    	}
    	
    	return sb.toString();
    }
    

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FullTextStruct)) return false;
        FullTextStruct other = (FullTextStruct) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.right == other.getRight() &&
            ((this.files==null && other.getFiles()==null) || 
             (this.files!=null &&
              java.util.Arrays.equals(this.files, other.getFiles())));
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
        _hashCode += getRight();
        if (getFiles() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFiles());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFiles(), i);
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
        new org.apache.axis.description.TypeDesc(FullTextStruct.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "FullTextStruct"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("right");
        elemField.setXmlName(new javax.xml.namespace.QName("", "right"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("files");
        elemField.setXmlName(new javax.xml.namespace.QName("", "files"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "FileStruct"));
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
