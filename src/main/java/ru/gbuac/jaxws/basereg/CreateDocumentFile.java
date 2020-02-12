/**
 * CreateDocumentFile.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.gbuac.jaxws.basereg;

public class CreateDocumentFile  implements java.io.Serializable {
    private java.lang.String DESCRIPTION;

    private byte[] FILE_BODY;

    private java.lang.String FILE_NAME;

    private byte[] SIGN_BODY;

    public CreateDocumentFile() {
    }

    public CreateDocumentFile(
           java.lang.String DESCRIPTION,
           byte[] FILE_BODY,
           java.lang.String FILE_NAME,
           byte[] SIGN_BODY) {
           this.DESCRIPTION = DESCRIPTION;
           this.FILE_BODY = FILE_BODY;
           this.FILE_NAME = FILE_NAME;
           this.SIGN_BODY = SIGN_BODY;
    }


    /**
     * Gets the DESCRIPTION value for this CreateDocumentFile.
     * 
     * @return DESCRIPTION
     */
    public java.lang.String getDESCRIPTION() {
        return DESCRIPTION;
    }


    /**
     * Sets the DESCRIPTION value for this CreateDocumentFile.
     * 
     * @param DESCRIPTION
     */
    public void setDESCRIPTION(java.lang.String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }


    /**
     * Gets the FILE_BODY value for this CreateDocumentFile.
     * 
     * @return FILE_BODY
     */
    public byte[] getFILE_BODY() {
        return FILE_BODY;
    }


    /**
     * Sets the FILE_BODY value for this CreateDocumentFile.
     * 
     * @param FILE_BODY
     */
    public void setFILE_BODY(byte[] FILE_BODY) {
        this.FILE_BODY = FILE_BODY;
    }


    /**
     * Gets the FILE_NAME value for this CreateDocumentFile.
     * 
     * @return FILE_NAME
     */
    public java.lang.String getFILE_NAME() {
        return FILE_NAME;
    }


    /**
     * Sets the FILE_NAME value for this CreateDocumentFile.
     * 
     * @param FILE_NAME
     */
    public void setFILE_NAME(java.lang.String FILE_NAME) {
        this.FILE_NAME = FILE_NAME;
    }


    /**
     * Gets the SIGN_BODY value for this CreateDocumentFile.
     * 
     * @return SIGN_BODY
     */
    public byte[] getSIGN_BODY() {
        return SIGN_BODY;
    }


    /**
     * Sets the SIGN_BODY value for this CreateDocumentFile.
     * 
     * @param SIGN_BODY
     */
    public void setSIGN_BODY(byte[] SIGN_BODY) {
        this.SIGN_BODY = SIGN_BODY;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreateDocumentFile)) return false;
        CreateDocumentFile other = (CreateDocumentFile) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DESCRIPTION==null && other.getDESCRIPTION()==null) || 
             (this.DESCRIPTION!=null &&
              this.DESCRIPTION.equals(other.getDESCRIPTION()))) &&
            ((this.FILE_BODY==null && other.getFILE_BODY()==null) || 
             (this.FILE_BODY!=null &&
              java.util.Arrays.equals(this.FILE_BODY, other.getFILE_BODY()))) &&
            ((this.FILE_NAME==null && other.getFILE_NAME()==null) || 
             (this.FILE_NAME!=null &&
              this.FILE_NAME.equals(other.getFILE_NAME()))) &&
            ((this.SIGN_BODY==null && other.getSIGN_BODY()==null) || 
             (this.SIGN_BODY!=null &&
              java.util.Arrays.equals(this.SIGN_BODY, other.getSIGN_BODY())));
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
        if (getDESCRIPTION() != null) {
            _hashCode += getDESCRIPTION().hashCode();
        }
        if (getFILE_BODY() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFILE_BODY());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFILE_BODY(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFILE_NAME() != null) {
            _hashCode += getFILE_NAME().hashCode();
        }
        if (getSIGN_BODY() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSIGN_BODY());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSIGN_BODY(), i);
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
        new org.apache.axis.description.TypeDesc(CreateDocumentFile.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "CreateDocumentFile"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DESCRIPTION");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "DESCRIPTION"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FILE_BODY");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "FILE_BODY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FILE_NAME");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "FILE_NAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SIGN_BODY");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "SIGN_BODY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
