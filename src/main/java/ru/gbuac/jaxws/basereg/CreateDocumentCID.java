/**
 * CreateDocumentCID.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.gbuac.jaxws.basereg;

public class CreateDocumentCID  implements java.io.Serializable {
    private java.lang.Integer BLOCKID;

    private java.lang.String PARENT_TAG_NAME;

    private java.lang.String TAG_NAME;

    private java.lang.String TAG_VALUE;

    public CreateDocumentCID() {
    }

    public CreateDocumentCID(
           java.lang.Integer BLOCKID,
           java.lang.String PARENT_TAG_NAME,
           java.lang.String TAG_NAME,
           java.lang.String TAG_VALUE) {
           this.BLOCKID = BLOCKID;
           this.PARENT_TAG_NAME = PARENT_TAG_NAME;
           this.TAG_NAME = TAG_NAME;
           this.TAG_VALUE = TAG_VALUE;
    }


    /**
     * Gets the BLOCKID value for this CreateDocumentCID.
     * 
     * @return BLOCKID
     */
    public java.lang.Integer getBLOCKID() {
        return BLOCKID;
    }


    /**
     * Sets the BLOCKID value for this CreateDocumentCID.
     * 
     * @param BLOCKID
     */
    public void setBLOCKID(java.lang.Integer BLOCKID) {
        this.BLOCKID = BLOCKID;
    }


    /**
     * Gets the PARENT_TAG_NAME value for this CreateDocumentCID.
     * 
     * @return PARENT_TAG_NAME
     */
    public java.lang.String getPARENT_TAG_NAME() {
        return PARENT_TAG_NAME;
    }


    /**
     * Sets the PARENT_TAG_NAME value for this CreateDocumentCID.
     * 
     * @param PARENT_TAG_NAME
     */
    public void setPARENT_TAG_NAME(java.lang.String PARENT_TAG_NAME) {
        this.PARENT_TAG_NAME = PARENT_TAG_NAME;
    }


    /**
     * Gets the TAG_NAME value for this CreateDocumentCID.
     * 
     * @return TAG_NAME
     */
    public java.lang.String getTAG_NAME() {
        return TAG_NAME;
    }


    /**
     * Sets the TAG_NAME value for this CreateDocumentCID.
     * 
     * @param TAG_NAME
     */
    public void setTAG_NAME(java.lang.String TAG_NAME) {
        this.TAG_NAME = TAG_NAME;
    }


    /**
     * Gets the TAG_VALUE value for this CreateDocumentCID.
     * 
     * @return TAG_VALUE
     */
    public java.lang.String getTAG_VALUE() {
        return TAG_VALUE;
    }


    /**
     * Sets the TAG_VALUE value for this CreateDocumentCID.
     * 
     * @param TAG_VALUE
     */
    public void setTAG_VALUE(java.lang.String TAG_VALUE) {
        this.TAG_VALUE = TAG_VALUE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreateDocumentCID)) return false;
        CreateDocumentCID other = (CreateDocumentCID) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.BLOCKID==null && other.getBLOCKID()==null) || 
             (this.BLOCKID!=null &&
              this.BLOCKID.equals(other.getBLOCKID()))) &&
            ((this.PARENT_TAG_NAME==null && other.getPARENT_TAG_NAME()==null) || 
             (this.PARENT_TAG_NAME!=null &&
              this.PARENT_TAG_NAME.equals(other.getPARENT_TAG_NAME()))) &&
            ((this.TAG_NAME==null && other.getTAG_NAME()==null) || 
             (this.TAG_NAME!=null &&
              this.TAG_NAME.equals(other.getTAG_NAME()))) &&
            ((this.TAG_VALUE==null && other.getTAG_VALUE()==null) || 
             (this.TAG_VALUE!=null &&
              this.TAG_VALUE.equals(other.getTAG_VALUE())));
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
        if (getBLOCKID() != null) {
            _hashCode += getBLOCKID().hashCode();
        }
        if (getPARENT_TAG_NAME() != null) {
            _hashCode += getPARENT_TAG_NAME().hashCode();
        }
        if (getTAG_NAME() != null) {
            _hashCode += getTAG_NAME().hashCode();
        }
        if (getTAG_VALUE() != null) {
            _hashCode += getTAG_VALUE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreateDocumentCID.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "CreateDocumentCID"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BLOCKID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "BLOCKID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PARENT_TAG_NAME");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "PARENT_TAG_NAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TAG_NAME");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "TAG_NAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TAG_VALUE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "TAG_VALUE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
