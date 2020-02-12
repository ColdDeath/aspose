/**
 * DocumentLink.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.gbuac.jaxws.basereg;

public class DocumentLink  implements java.io.Serializable {
    private java.lang.String DESC;

    private java.lang.String FILE_NAME;

    private java.math.BigDecimal ID_FILE;

    private byte[] SIG;

    public DocumentLink() {
    }

    public DocumentLink(
           java.lang.String DESC,
           java.lang.String FILE_NAME,
           java.math.BigDecimal ID_FILE,
           byte[] SIG) {
           this.DESC = DESC;
           this.FILE_NAME = FILE_NAME;
           this.ID_FILE = ID_FILE;
           this.SIG = SIG;
    }


    /**
     * Gets the DESC value for this DocumentLink.
     * 
     * @return DESC
     */
    public java.lang.String getDESC() {
        return DESC;
    }


    /**
     * Sets the DESC value for this DocumentLink.
     * 
     * @param DESC
     */
    public void setDESC(java.lang.String DESC) {
        this.DESC = DESC;
    }


    /**
     * Gets the FILE_NAME value for this DocumentLink.
     * 
     * @return FILE_NAME
     */
    public java.lang.String getFILE_NAME() {
        return FILE_NAME;
    }


    /**
     * Sets the FILE_NAME value for this DocumentLink.
     * 
     * @param FILE_NAME
     */
    public void setFILE_NAME(java.lang.String FILE_NAME) {
        this.FILE_NAME = FILE_NAME;
    }


    /**
     * Gets the ID_FILE value for this DocumentLink.
     * 
     * @return ID_FILE
     */
    public java.math.BigDecimal getID_FILE() {
        return ID_FILE;
    }


    /**
     * Sets the ID_FILE value for this DocumentLink.
     * 
     * @param ID_FILE
     */
    public void setID_FILE(java.math.BigDecimal ID_FILE) {
        this.ID_FILE = ID_FILE;
    }


    /**
     * Gets the SIG value for this DocumentLink.
     * 
     * @return SIG
     */
    public byte[] getSIG() {
        return SIG;
    }


    /**
     * Sets the SIG value for this DocumentLink.
     * 
     * @param SIG
     */
    public void setSIG(byte[] SIG) {
        this.SIG = SIG;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentLink)) return false;
        DocumentLink other = (DocumentLink) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DESC==null && other.getDESC()==null) || 
             (this.DESC!=null &&
              this.DESC.equals(other.getDESC()))) &&
            ((this.FILE_NAME==null && other.getFILE_NAME()==null) || 
             (this.FILE_NAME!=null &&
              this.FILE_NAME.equals(other.getFILE_NAME()))) &&
            ((this.ID_FILE==null && other.getID_FILE()==null) || 
             (this.ID_FILE!=null &&
              this.ID_FILE.equals(other.getID_FILE()))) &&
            ((this.SIG==null && other.getSIG()==null) || 
             (this.SIG!=null &&
              java.util.Arrays.equals(this.SIG, other.getSIG())));
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
        if (getDESC() != null) {
            _hashCode += getDESC().hashCode();
        }
        if (getFILE_NAME() != null) {
            _hashCode += getFILE_NAME().hashCode();
        }
        if (getID_FILE() != null) {
            _hashCode += getID_FILE().hashCode();
        }
        if (getSIG() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSIG());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSIG(), i);
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
        new org.apache.axis.description.TypeDesc(DocumentLink.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "DocumentLink"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DESC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "DESC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FILE_NAME");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "FILE_NAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_FILE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "ID_FILE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SIG");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "SIG"));
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
