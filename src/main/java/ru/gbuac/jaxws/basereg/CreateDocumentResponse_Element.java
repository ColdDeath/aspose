/**
 * CreateDocumentResponse_Element.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.gbuac.jaxws.basereg;

public class CreateDocumentResponse_Element  implements java.io.Serializable {
    private ru.gbuac.jaxws.basereg.CreateDocumentResponse createDocumentResult;

    public CreateDocumentResponse_Element() {
    }

    public CreateDocumentResponse_Element(
           ru.gbuac.jaxws.basereg.CreateDocumentResponse createDocumentResult) {
           this.createDocumentResult = createDocumentResult;
    }


    /**
     * Gets the createDocumentResult value for this CreateDocumentResponse_Element.
     * 
     * @return createDocumentResult
     */
    public ru.gbuac.jaxws.basereg.CreateDocumentResponse getCreateDocumentResult() {
        return createDocumentResult;
    }


    /**
     * Sets the createDocumentResult value for this CreateDocumentResponse_Element.
     * 
     * @param createDocumentResult
     */
    public void setCreateDocumentResult(ru.gbuac.jaxws.basereg.CreateDocumentResponse createDocumentResult) {
        this.createDocumentResult = createDocumentResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreateDocumentResponse_Element)) return false;
        CreateDocumentResponse_Element other = (CreateDocumentResponse_Element) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.createDocumentResult==null && other.getCreateDocumentResult()==null) || 
             (this.createDocumentResult!=null &&
              this.createDocumentResult.equals(other.getCreateDocumentResult())));
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
        if (getCreateDocumentResult() != null) {
            _hashCode += getCreateDocumentResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreateDocumentResponse_Element.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">CreateDocumentResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createDocumentResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CreateDocumentResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "CreateDocumentResponse"));
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
