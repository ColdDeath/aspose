/**
 * DocumentRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.gbuac.jaxws.basereg;

public class DocumentRequest  extends ru.gbuac.jaxws.basereg.BaseRequest  implements java.io.Serializable {
    private java.lang.String CADNUM;

    private java.lang.String DATA_REGIS;

    private java.lang.String REGISTR_N;

    private java.lang.String TYPE_DOCUMENT;

    private java.lang.String UNOM;

    private java.lang.String USLNUM;

    public DocumentRequest() {
    }

    public DocumentRequest(
           java.lang.String ORG_GUID,
           java.lang.String CADNUM,
           java.lang.String DATA_REGIS,
           java.lang.String REGISTR_N,
           java.lang.String TYPE_DOCUMENT,
           java.lang.String UNOM,
           java.lang.String USLNUM) {
        super(
            ORG_GUID);
        this.CADNUM = CADNUM;
        this.DATA_REGIS = DATA_REGIS;
        this.REGISTR_N = REGISTR_N;
        this.TYPE_DOCUMENT = TYPE_DOCUMENT;
        this.UNOM = UNOM;
        this.USLNUM = USLNUM;
    }


    /**
     * Gets the CADNUM value for this DocumentRequest.
     * 
     * @return CADNUM
     */
    public java.lang.String getCADNUM() {
        return CADNUM;
    }


    /**
     * Sets the CADNUM value for this DocumentRequest.
     * 
     * @param CADNUM
     */
    public void setCADNUM(java.lang.String CADNUM) {
        this.CADNUM = CADNUM;
    }


    /**
     * Gets the DATA_REGIS value for this DocumentRequest.
     * 
     * @return DATA_REGIS
     */
    public java.lang.String getDATA_REGIS() {
        return DATA_REGIS;
    }


    /**
     * Sets the DATA_REGIS value for this DocumentRequest.
     * 
     * @param DATA_REGIS
     */
    public void setDATA_REGIS(java.lang.String DATA_REGIS) {
        this.DATA_REGIS = DATA_REGIS;
    }


    /**
     * Gets the REGISTR_N value for this DocumentRequest.
     * 
     * @return REGISTR_N
     */
    public java.lang.String getREGISTR_N() {
        return REGISTR_N;
    }


    /**
     * Sets the REGISTR_N value for this DocumentRequest.
     * 
     * @param REGISTR_N
     */
    public void setREGISTR_N(java.lang.String REGISTR_N) {
        this.REGISTR_N = REGISTR_N;
    }


    /**
     * Gets the TYPE_DOCUMENT value for this DocumentRequest.
     * 
     * @return TYPE_DOCUMENT
     */
    public java.lang.String getTYPE_DOCUMENT() {
        return TYPE_DOCUMENT;
    }


    /**
     * Sets the TYPE_DOCUMENT value for this DocumentRequest.
     * 
     * @param TYPE_DOCUMENT
     */
    public void setTYPE_DOCUMENT(java.lang.String TYPE_DOCUMENT) {
        this.TYPE_DOCUMENT = TYPE_DOCUMENT;
    }


    /**
     * Gets the UNOM value for this DocumentRequest.
     * 
     * @return UNOM
     */
    public java.lang.String getUNOM() {
        return UNOM;
    }


    /**
     * Sets the UNOM value for this DocumentRequest.
     * 
     * @param UNOM
     */
    public void setUNOM(java.lang.String UNOM) {
        this.UNOM = UNOM;
    }


    /**
     * Gets the USLNUM value for this DocumentRequest.
     * 
     * @return USLNUM
     */
    public java.lang.String getUSLNUM() {
        return USLNUM;
    }


    /**
     * Sets the USLNUM value for this DocumentRequest.
     * 
     * @param USLNUM
     */
    public void setUSLNUM(java.lang.String USLNUM) {
        this.USLNUM = USLNUM;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentRequest)) return false;
        DocumentRequest other = (DocumentRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.CADNUM==null && other.getCADNUM()==null) || 
             (this.CADNUM!=null &&
              this.CADNUM.equals(other.getCADNUM()))) &&
            ((this.DATA_REGIS==null && other.getDATA_REGIS()==null) || 
             (this.DATA_REGIS!=null &&
              this.DATA_REGIS.equals(other.getDATA_REGIS()))) &&
            ((this.REGISTR_N==null && other.getREGISTR_N()==null) || 
             (this.REGISTR_N!=null &&
              this.REGISTR_N.equals(other.getREGISTR_N()))) &&
            ((this.TYPE_DOCUMENT==null && other.getTYPE_DOCUMENT()==null) || 
             (this.TYPE_DOCUMENT!=null &&
              this.TYPE_DOCUMENT.equals(other.getTYPE_DOCUMENT()))) &&
            ((this.UNOM==null && other.getUNOM()==null) || 
             (this.UNOM!=null &&
              this.UNOM.equals(other.getUNOM()))) &&
            ((this.USLNUM==null && other.getUSLNUM()==null) || 
             (this.USLNUM!=null &&
              this.USLNUM.equals(other.getUSLNUM())));
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
        if (getCADNUM() != null) {
            _hashCode += getCADNUM().hashCode();
        }
        if (getDATA_REGIS() != null) {
            _hashCode += getDATA_REGIS().hashCode();
        }
        if (getREGISTR_N() != null) {
            _hashCode += getREGISTR_N().hashCode();
        }
        if (getTYPE_DOCUMENT() != null) {
            _hashCode += getTYPE_DOCUMENT().hashCode();
        }
        if (getUNOM() != null) {
            _hashCode += getUNOM().hashCode();
        }
        if (getUSLNUM() != null) {
            _hashCode += getUSLNUM().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "DocumentRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CADNUM");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "CADNUM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_REGIS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "DATA_REGIS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("REGISTR_N");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "REGISTR_N"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TYPE_DOCUMENT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "TYPE_DOCUMENT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UNOM");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "UNOM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("USLNUM");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "USLNUM"));
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
