/**
 * DocumentReceivedRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.gbuac.jaxws.basereg;

public class DocumentReceivedRequest  extends ru.gbuac.jaxws.basereg.BaseRequest  implements java.io.Serializable {
    private java.math.BigDecimal ID_DOCUMENTRES;

    public DocumentReceivedRequest() {
    }

    public DocumentReceivedRequest(
           java.lang.String ORG_GUID,
           java.math.BigDecimal ID_DOCUMENTRES) {
        super(
            ORG_GUID);
        this.ID_DOCUMENTRES = ID_DOCUMENTRES;
    }


    /**
     * Gets the ID_DOCUMENTRES value for this DocumentReceivedRequest.
     * 
     * @return ID_DOCUMENTRES
     */
    public java.math.BigDecimal getID_DOCUMENTRES() {
        return ID_DOCUMENTRES;
    }


    /**
     * Sets the ID_DOCUMENTRES value for this DocumentReceivedRequest.
     * 
     * @param ID_DOCUMENTRES
     */
    public void setID_DOCUMENTRES(java.math.BigDecimal ID_DOCUMENTRES) {
        this.ID_DOCUMENTRES = ID_DOCUMENTRES;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentReceivedRequest)) return false;
        DocumentReceivedRequest other = (DocumentReceivedRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.ID_DOCUMENTRES==null && other.getID_DOCUMENTRES()==null) || 
             (this.ID_DOCUMENTRES!=null &&
              this.ID_DOCUMENTRES.equals(other.getID_DOCUMENTRES())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getID_DOCUMENTRES() != null) {
            _hashCode += getID_DOCUMENTRES().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentReceivedRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "DocumentReceivedRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_DOCUMENTRES");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "ID_DOCUMENTRES"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
