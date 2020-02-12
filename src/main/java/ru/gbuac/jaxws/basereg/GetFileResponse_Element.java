/**
 * GetFileResponse_Element.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.gbuac.jaxws.basereg;

public class GetFileResponse_Element  implements java.io.Serializable {
    private ru.gbuac.jaxws.basereg.GetFileResponse getFileResult;

    public GetFileResponse_Element() {
    }

    public GetFileResponse_Element(
           ru.gbuac.jaxws.basereg.GetFileResponse getFileResult) {
           this.getFileResult = getFileResult;
    }


    /**
     * Gets the getFileResult value for this GetFileResponse_Element.
     * 
     * @return getFileResult
     */
    public ru.gbuac.jaxws.basereg.GetFileResponse getGetFileResult() {
        return getFileResult;
    }


    /**
     * Sets the getFileResult value for this GetFileResponse_Element.
     * 
     * @param getFileResult
     */
    public void setGetFileResult(ru.gbuac.jaxws.basereg.GetFileResponse getFileResult) {
        this.getFileResult = getFileResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetFileResponse_Element)) return false;
        GetFileResponse_Element other = (GetFileResponse_Element) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getFileResult==null && other.getGetFileResult()==null) || 
             (this.getFileResult!=null &&
              this.getFileResult.equals(other.getGetFileResult())));
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
        if (getGetFileResult() != null) {
            _hashCode += getGetFileResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetFileResponse_Element.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetFileResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getFileResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetFileResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "GetFileResponse"));
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
