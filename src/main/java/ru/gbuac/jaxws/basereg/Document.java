/**
 * Document.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.gbuac.jaxws.basereg;

public class Document  implements java.io.Serializable {
    private ru.gbuac.jaxws.basereg.DocumentXML XML;

    private ru.gbuac.jaxws.basereg.DocumentLink[] linkList;

    public Document() {
    }

    public Document(
           ru.gbuac.jaxws.basereg.DocumentXML XML,
           ru.gbuac.jaxws.basereg.DocumentLink[] linkList) {
           this.XML = XML;
           this.linkList = linkList;
    }


    /**
     * Gets the XML value for this Document.
     * 
     * @return XML
     */
    public ru.gbuac.jaxws.basereg.DocumentXML getXML() {
        return XML;
    }


    /**
     * Sets the XML value for this Document.
     * 
     * @param XML
     */
    public void setXML(ru.gbuac.jaxws.basereg.DocumentXML XML) {
        this.XML = XML;
    }


    /**
     * Gets the linkList value for this Document.
     * 
     * @return linkList
     */
    public ru.gbuac.jaxws.basereg.DocumentLink[] getLinkList() {
        return linkList;
    }


    /**
     * Sets the linkList value for this Document.
     * 
     * @param linkList
     */
    public void setLinkList(ru.gbuac.jaxws.basereg.DocumentLink[] linkList) {
        this.linkList = linkList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Document)) return false;
        Document other = (Document) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.XML==null && other.getXML()==null) || 
             (this.XML!=null &&
              this.XML.equals(other.getXML()))) &&
            ((this.linkList==null && other.getLinkList()==null) || 
             (this.linkList!=null &&
              java.util.Arrays.equals(this.linkList, other.getLinkList())));
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
        if (getXML() != null) {
            _hashCode += getXML().hashCode();
        }
        if (getLinkList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLinkList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLinkList(), i);
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
        new org.apache.axis.description.TypeDesc(Document.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "Document"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XML");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "XML"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", ">Document>XML"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("linkList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "linkList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "DocumentLink"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "DocumentLink"));
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
