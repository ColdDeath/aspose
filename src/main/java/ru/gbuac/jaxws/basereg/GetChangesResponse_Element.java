/**
 * GetChangesResponse_Element.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.gbuac.jaxws.basereg;

public class GetChangesResponse_Element  implements java.io.Serializable {
    private ru.gbuac.jaxws.basereg.GetChangesResponse getChangesResult;

    public GetChangesResponse_Element() {
    }

    public GetChangesResponse_Element(
           ru.gbuac.jaxws.basereg.GetChangesResponse getChangesResult) {
           this.getChangesResult = getChangesResult;
    }


    /**
     * Gets the getChangesResult value for this GetChangesResponse_Element.
     * 
     * @return getChangesResult
     */
    public ru.gbuac.jaxws.basereg.GetChangesResponse getGetChangesResult() {
        return getChangesResult;
    }


    /**
     * Sets the getChangesResult value for this GetChangesResponse_Element.
     * 
     * @param getChangesResult
     */
    public void setGetChangesResult(ru.gbuac.jaxws.basereg.GetChangesResponse getChangesResult) {
        this.getChangesResult = getChangesResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetChangesResponse_Element)) return false;
        GetChangesResponse_Element other = (GetChangesResponse_Element) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getChangesResult==null && other.getGetChangesResult()==null) || 
             (this.getChangesResult!=null &&
              this.getChangesResult.equals(other.getGetChangesResult())));
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
        if (getGetChangesResult() != null) {
            _hashCode += getGetChangesResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetChangesResponse_Element.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetChangesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getChangesResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetChangesResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "GetChangesResponse"));
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
