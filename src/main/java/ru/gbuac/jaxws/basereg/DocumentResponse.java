/**
 * DocumentResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.gbuac.jaxws.basereg;

public class DocumentResponse  extends ru.gbuac.jaxws.basereg.BaseResponse  implements java.io.Serializable {
    private ru.gbuac.jaxws.basereg.Document[] documentsList;

    private ru.gbuac.jaxws.basereg.ResponseStatus status;

    private java.lang.String text;

    public DocumentResponse() {
    }

    public DocumentResponse(
           java.lang.Boolean error,
           java.lang.String message,
           ru.gbuac.jaxws.basereg.Document[] documentsList,
           ru.gbuac.jaxws.basereg.ResponseStatus status,
           java.lang.String text) {
        super(
            error,
            message);
        this.documentsList = documentsList;
        this.status = status;
        this.text = text;
    }


    /**
     * Gets the documentsList value for this DocumentResponse.
     * 
     * @return documentsList
     */
    public ru.gbuac.jaxws.basereg.Document[] getDocumentsList() {
        return documentsList;
    }


    /**
     * Sets the documentsList value for this DocumentResponse.
     * 
     * @param documentsList
     */
    public void setDocumentsList(ru.gbuac.jaxws.basereg.Document[] documentsList) {
        this.documentsList = documentsList;
    }


    /**
     * Gets the status value for this DocumentResponse.
     * 
     * @return status
     */
    public ru.gbuac.jaxws.basereg.ResponseStatus getStatus() {
        return status;
    }


    /**
     * Sets the status value for this DocumentResponse.
     * 
     * @param status
     */
    public void setStatus(ru.gbuac.jaxws.basereg.ResponseStatus status) {
        this.status = status;
    }


    /**
     * Gets the text value for this DocumentResponse.
     * 
     * @return text
     */
    public java.lang.String getText() {
        return text;
    }


    /**
     * Sets the text value for this DocumentResponse.
     * 
     * @param text
     */
    public void setText(java.lang.String text) {
        this.text = text;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentResponse)) return false;
        DocumentResponse other = (DocumentResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.documentsList==null && other.getDocumentsList()==null) || 
             (this.documentsList!=null &&
              java.util.Arrays.equals(this.documentsList, other.getDocumentsList()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.text==null && other.getText()==null) || 
             (this.text!=null &&
              this.text.equals(other.getText())));
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
        if (getDocumentsList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocumentsList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocumentsList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getText() != null) {
            _hashCode += getText().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "DocumentResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentsList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "documentsList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "Document"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "Document"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "ResponseStatus"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("text");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "text"));
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
