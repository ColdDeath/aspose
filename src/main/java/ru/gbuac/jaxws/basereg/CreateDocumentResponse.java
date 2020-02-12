/**
 * CreateDocumentResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.gbuac.jaxws.basereg;

public class CreateDocumentResponse  extends ru.gbuac.jaxws.basereg.BaseResponse  implements java.io.Serializable {
    private java.lang.Long documentId;

    private int[] filesId;

    private ru.gbuac.jaxws.basereg.ResponseStatus status;

    public CreateDocumentResponse() {
    }

    public CreateDocumentResponse(
           java.lang.Boolean error,
           java.lang.String message,
           java.lang.Long documentId,
           int[] filesId,
           ru.gbuac.jaxws.basereg.ResponseStatus status) {
        super(
            error,
            message);
        this.documentId = documentId;
        this.filesId = filesId;
        this.status = status;
    }


    /**
     * Gets the documentId value for this CreateDocumentResponse.
     * 
     * @return documentId
     */
    public java.lang.Long getDocumentId() {
        return documentId;
    }


    /**
     * Sets the documentId value for this CreateDocumentResponse.
     * 
     * @param documentId
     */
    public void setDocumentId(java.lang.Long documentId) {
        this.documentId = documentId;
    }


    /**
     * Gets the filesId value for this CreateDocumentResponse.
     * 
     * @return filesId
     */
    public int[] getFilesId() {
        return filesId;
    }


    /**
     * Sets the filesId value for this CreateDocumentResponse.
     * 
     * @param filesId
     */
    public void setFilesId(int[] filesId) {
        this.filesId = filesId;
    }


    /**
     * Gets the status value for this CreateDocumentResponse.
     * 
     * @return status
     */
    public ru.gbuac.jaxws.basereg.ResponseStatus getStatus() {
        return status;
    }


    /**
     * Sets the status value for this CreateDocumentResponse.
     * 
     * @param status
     */
    public void setStatus(ru.gbuac.jaxws.basereg.ResponseStatus status) {
        this.status = status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreateDocumentResponse)) return false;
        CreateDocumentResponse other = (CreateDocumentResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.documentId==null && other.getDocumentId()==null) || 
             (this.documentId!=null &&
              this.documentId.equals(other.getDocumentId()))) &&
            ((this.filesId==null && other.getFilesId()==null) || 
             (this.filesId!=null &&
              java.util.Arrays.equals(this.filesId, other.getFilesId()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus())));
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
        if (getDocumentId() != null) {
            _hashCode += getDocumentId().hashCode();
        }
        if (getFilesId() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFilesId());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFilesId(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreateDocumentResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "CreateDocumentResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "documentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filesId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "filesId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "ResponseStatus"));
        elemField.setMinOccurs(0);
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
